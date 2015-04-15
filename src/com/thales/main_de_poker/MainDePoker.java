package com.thales.main_de_poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.thales.main_de_poker.model.Carte;

public class MainDePoker {

    private static final int TAILLE_MAIN = 5;
    private static final String phrase_depart = "Le jeu est composé de : ";
    private String main = "";
    private Set<Carte> cartes;
    private Annonce annonce;
    private Map<Valeur, Long> occurenceValeurs = new HashMap<>();
    private Map<Symbole, Long> occurenceSymboles = new HashMap<>();

    public MainDePoker(String main) {
        this.main = main;
        cartes = new LinkedHashSet<Carte>();

        String[] paires = main.split(" ");
        for (String paire : paires) {
            Valeur valeur = Valeur.getValeur(paire.charAt(0));
            Symbole symbole = Symbole.getSymbole(paire.charAt(1));

            cartes.add(new Carte(valeur, symbole));
        }

        verifierUnicite();

        construireMapOccurence();

        initAnnonce();

    }

    private void verifierUnicite() {
        if (TAILLE_MAIN != cartes.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void initAnnonce() {
        List<Annonce> listeAnnonce = Arrays.asList(new Paire(occurenceValeurs), new Brelan(occurenceValeurs),
                new Carre(occurenceValeurs), new Couleur(occurenceSymboles));

        Optional<Annonce> annonceOptional = listeAnnonce.stream().filter(a -> a.detecter()).findFirst();

        annonce = annonceOptional.orElse(new MainSansAnnonce());
    }

    private void construireMapOccurence() {

        // Map<Valeur, List<Carte>> collect =
        // cartes.stream().collect(Collectors.groupingBy(Carte::getValeur));
        // collect.entrySet().stream().collect(Collectors.toMap(Map<Valeur,
        // List<Carte>>.Entry::getKey, l -> l.size()));

        for (Carte carte : cartes) {
            Valeur valeurCarte = carte.getValeur();
            if (occurenceValeurs.containsKey(valeurCarte)) {
                Long index = occurenceValeurs.get(valeurCarte);
                occurenceValeurs.put(valeurCarte, ++index);
            } else {
                occurenceValeurs.put(valeurCarte, 1l);
            }
            Symbole symbole = carte.getSymbole();
            if (occurenceSymboles.containsKey(symbole)) {
                Long index = occurenceSymboles.get(symbole);
                occurenceSymboles.put(symbole, ++index);
            } else {
                occurenceSymboles.put(symbole, 1l);
            }
        }
    }

    public String getOutput() {
        boolean isFirst = true;
        StringBuilder builder = new StringBuilder();
        builder.append(phrase_depart);
        List<String> results = decomposition();
        for (String result : results) {
            if (!isFirst) {
                builder.append(", ");
            }
            builder.append(result);
            isFirst = false;
        }

        builder.append(annonce.getOutput());

        return builder.toString();
    }

    private List<String> decomposition() {
        List<String> results = new ArrayList<>();
        for (Carte carte : cartes) {
            results.add(carte.toString());
        }
        return results;
    }

    public Annonce getAnnonce() {
        return annonce;
    }
}

package com.thales.main_de_poker;

import java.util.Map;

public class Paire extends Annonce {

    public Paire(Map<Valeur, Long> occurenceValeurs) {
        super(occurenceValeurs);
    }

    @Override
    public boolean detecter() {
        return detecterNbOccurence(2);
    }

    @Override
    String getOutput() {
        return " et contient 1 paire";
    }

}

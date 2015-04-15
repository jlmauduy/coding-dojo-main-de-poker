package com.thales.main_de_poker;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MainDePokerParameterizedTest {

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] { MAIN_DEPART_PAIRE, OUTPUT_PAIRE, Paire.class},
                new Object[] { MAIN_DEPART_BRELAN, OUTPUT_BRELAN, Brelan.class},
                new Object[] { MAIN_DEPART_CARRE, OUTPUT_CARRE, Carre.class},
                new Object[] { MAIN_DEPART_COULEUR, OUTPUT_COULEUR, Couleur.class}
            );
    }
    
	private static final String MAIN_DEPART_PAIRE = "2H 3D 2D 5D 4H";
	private static final String MAIN_DEPART_BRELAN = "2H 3D 2D 5D 2S";
	private static final String MAIN_DEPART_CARRE = "2H 3D 2D 2C 2S";
	private static final String MAIN_DEPART_COULEUR = "2H 3H 4H 5H 9H";

	private static final String OUTPUT_PAIRE = "Le jeu est composé de : 2 de coeur, 3 de carreau, 2 de carreau, 5 de carreau, 4 de coeur et contient 1 paire";
	private static final String OUTPUT_BRELAN = "Le jeu est composé de : 2 de coeur, 3 de carreau, 2 de carreau, 5 de carreau, 2 de pique et contient 1 brelan";
	private static final String OUTPUT_CARRE = "Le jeu est composé de : 2 de coeur, 3 de carreau, 2 de carreau, 2 de trefle, 2 de pique et contient 1 carré";
	private static final String OUTPUT_COULEUR = "Le jeu est composé de : 2 de coeur, 3 de coeur, 4 de coeur, 5 de coeur, 9 de coeur et contient 1 couleur";

	
	private String mainDepart;
	private String output;
	private Class<? extends Annonce> annonceClass;
	
	
	public MainDePokerParameterizedTest(String mainDepart, String output, Class<? extends Annonce> annonceClass) {
        super();
        this.mainDepart = mainDepart;
        this.output = output;
        this.annonceClass = annonceClass;
    }

    @Test
	public void testOutput(){
        MainDePoker mainDePoker = new MainDePoker(mainDepart);
		assertEquals(output, mainDePoker.getOutput());
	}

	@Test
	public void testDetecterAnnonce(){
		MainDePoker mainDePoker = new MainDePoker(mainDepart);
		assertEquals(annonceClass, mainDePoker.getAnnonce().getClass());
	}
	
}

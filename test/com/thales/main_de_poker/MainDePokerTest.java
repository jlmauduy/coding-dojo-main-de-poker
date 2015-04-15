package com.thales.main_de_poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainDePokerTest {

	private static final String MAIN_DEPART_PAIRE = "2H 3D 2D 5D 4H";
	private static final String MAIN_DEPART_CARRE = "2H 3D 2D 2C 2S";
	private static final String MAIN_DEPART_BRELAN = "2H 3D 2D 5D 2S";
	private static final String MAIN_DEPART_COULEUR = "2H 3H 4H 5H 9H";

	private MainDePoker mainDePoker;
	
	@Test(expected = IllegalArgumentException.class)
	public void verifierTailleMain(){
		new MainDePoker("une main bizarre");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifierUniciteDesCartes(){
		mainDePoker = new MainDePoker("2H 4D TH 4D 5H");
	}
	
	@Test
	public void testOutputSansAnnonce(){
		mainDePoker = new MainDePoker("2H 3D TH 4D 5H");
		assertEquals("Le jeu est composé de : 2 de coeur, 3 de carreau, 10 de coeur, 4 de carreau, 5 de coeur", mainDePoker.getOutput());
	}
	
	@Test
	public void testOutputAvecPaire(){
		mainDePoker = new MainDePoker(MAIN_DEPART_PAIRE);
		assertEquals("Le jeu est composé de : 2 de coeur, 3 de carreau, 2 de carreau, 5 de carreau, 4 de coeur et contient 1 paire", mainDePoker.getOutput());
	}
	
	@Test
	public void testOutputAvecBrelan(){
		mainDePoker = new MainDePoker(MAIN_DEPART_BRELAN);
		assertEquals("Le jeu est composé de : 2 de coeur, 3 de carreau, 2 de carreau, 5 de carreau, 2 de pique et contient 1 brelan", mainDePoker.getOutput());
	}
	
	@Test
	public void nePasDetecterDoublePaire(){
		String main_depart= "2H 3D 2D 4D 4H";
		MainDePoker mainDePoker = new MainDePoker(main_depart);
		assertEquals(MainSansAnnonce.class, mainDePoker.getAnnonce().getClass());
	}
	
	@Test
	public void detecterPaireUnique(){
		MainDePoker mainDePoker = new MainDePoker(MAIN_DEPART_PAIRE);
		assertEquals(Paire.class, mainDePoker.getAnnonce().getClass());
	}
	
	@Test
	public void detecterBrelan(){
		MainDePoker mainDePoker = new MainDePoker(MAIN_DEPART_BRELAN);
		assertEquals(Brelan.class, mainDePoker.getAnnonce().getClass());
	}
	
	@Test
	public void testOutputAvecCarre(){
		mainDePoker = new MainDePoker(MAIN_DEPART_CARRE);
		assertEquals("Le jeu est composé de : 2 de coeur, 3 de carreau, 2 de carreau, 2 de trefle, 2 de pique et contient 1 carré", mainDePoker.getOutput());
	}

	@Test
	public void detecterCarre(){
		MainDePoker mainDePoker = new MainDePoker(MAIN_DEPART_CARRE);
		assertEquals(Carre.class, mainDePoker.getAnnonce().getClass());
	}
	
	@Test
	public void testOutputAvecCouleur(){
		mainDePoker = new MainDePoker(MAIN_DEPART_COULEUR);
		assertEquals("Le jeu est composé de : 2 de coeur, 3 de coeur, 4 de coeur, 5 de coeur, 9 de coeur et contient 1 couleur", mainDePoker.getOutput());
	}
	
	@Test
	public void detecterCouleur(){
		MainDePoker mainDePoker = new MainDePoker(MAIN_DEPART_COULEUR);
		assertEquals(Couleur.class, mainDePoker.getAnnonce().getClass());
	}
}

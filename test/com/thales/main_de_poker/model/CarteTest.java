package com.thales.main_de_poker.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thales.main_de_poker.Symbole;
import com.thales.main_de_poker.Valeur;

public class CarteTest {

	@Test
	public void testToString() {
		Carte carte = new Carte(Valeur.AS, Symbole.PIQUE);
		
		assertEquals("1 de pique", carte.toString());
	}
}

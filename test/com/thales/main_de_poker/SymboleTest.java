package com.thales.main_de_poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thales.main_de_poker.Symbole;

public class SymboleTest {

	@Test
	public void testToString() {
		assertEquals("carreau", Symbole.CARREAU.toString());
	}

	@Test
	public void testConstruction() {
		assertEquals(Symbole.CARREAU, Symbole.getSymbole('D'));
		assertEquals(Symbole.COEUR, Symbole.getSymbole('H'));
		assertEquals(Symbole.TREFLE, Symbole.getSymbole('C'));
		assertEquals(Symbole.PIQUE, Symbole.getSymbole('S'));
	}
}

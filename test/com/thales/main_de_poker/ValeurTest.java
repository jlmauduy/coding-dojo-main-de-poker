package com.thales.main_de_poker;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thales.main_de_poker.Valeur;

public class ValeurTest {

	@Test
	public void testToString() {
		assertEquals("2", Valeur.DEUX.toString());
	}
	@Test
	public void testConstruction() {
		assertEquals(Valeur.DEUX, Valeur.getValeur('2'));
	}
}

package com.thales.main_de_poker;

import java.util.Map;

public class Carre extends Annonce {
	
	public Carre(Map<Valeur, Long> mapOccurence) {
		super(mapOccurence);
	}

	@Override
	public boolean detecter() {
		return detecterNbOccurence(4);	
	}

	@Override
	String getOutput() {
		return " et contient 1 carré";
	}

}

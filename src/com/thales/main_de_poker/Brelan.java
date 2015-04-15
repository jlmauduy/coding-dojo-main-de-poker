package com.thales.main_de_poker;

import java.util.Map;

public class Brelan extends Annonce {

	
	public Brelan(Map<Valeur, Long> occurenceValeurs) {
		super(occurenceValeurs);
	}

	@Override
	public boolean detecter() {
		return detecterNbOccurence(3);	
	}

	@Override
	String getOutput() {
		return " et contient 1 brelan";
	}

}

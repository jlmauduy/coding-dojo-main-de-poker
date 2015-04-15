package com.thales.main_de_poker;

import java.util.Map;

public class Couleur extends Annonce {
	
	private Map<Symbole, Long> occurenceSymboles;
	
	public Couleur(Map<Symbole, Long> occurenceSymbole) {
		super();
		this.occurenceSymboles = occurenceSymbole;
	}

	@Override
	public boolean detecter() {
		return detecterUneCouleur();	
	}

	private boolean detecterUneCouleur() {
		return occurenceSymboles.containsValue(5l);
	}

	@Override
	String getOutput() {
		return " et contient 1 couleur";
	}

}

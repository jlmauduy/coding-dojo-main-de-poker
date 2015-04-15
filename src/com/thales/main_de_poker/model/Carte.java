package com.thales.main_de_poker.model;

import com.thales.main_de_poker.Symbole;
import com.thales.main_de_poker.Valeur;

public class Carte {

	private Valeur valeur;
	
	private Symbole symbole;

	public Carte(Valeur valeur, Symbole symbole){
		this.valeur = valeur;
		this.symbole = symbole;
	}
		
	public Valeur getValeur() {
		return valeur;
	}

	public Symbole getSymbole() {
		return symbole;
	}

	@Override
	public String toString() {
		return valeur + " de " + symbole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbole == null) ? 0 : symbole.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (symbole != other.symbole)
			return false;
		if (valeur != other.valeur)
			return false;
		return true;
	}

}

package com.thales.main_de_poker;

public enum Symbole {
	CARREAU('D', "carreau"),
	COEUR('H', "coeur"),
	TREFLE('C', "trefle"),
	PIQUE('S', "pique");
	
	private char input;
	private String output;
	
	private Symbole(char input, String output) {
		this.output = output;
		this.input = input;
	}
	
	public String toString() {
		return output;
	}
	
	public static Symbole getSymbole(char input){
		for (Symbole symb : Symbole.values()) {
			if(symb.input == input) {
				return symb;
			}
		}
		
		throw new IllegalArgumentException("mauvais symbole");
	}
	
}

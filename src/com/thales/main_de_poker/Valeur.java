package com.thales.main_de_poker;

public enum Valeur {
	AS('A', "1"),
	DEUX('2', "2"),
	TROIS('3', "3"),
	QUATRE('4',"4"),
	CINQ('5',"5"),
	SIX('6',"6"),
	SEPT('7',"7"),
	HUIT('8',"8"),
	NEUF('9',"9"),
	DIX('T',"10"),
	VALET('J',"valet"),
	DAME('Q',"dame"),
	ROI('K',"roi");
	
	private String output;
	private char input;
	
	private Valeur(char input, String output) {
		this.output = output;
		this.input = input;
	}
	
	public String toString() {
		return output;
	}
	
	public static Valeur getValeur(char input){
		for (Valeur val : Valeur.values()) {
			if(val.input == input){
				return val;
			}
		}
		
		throw new IllegalArgumentException("mauvaise valeur");
	}
	
}

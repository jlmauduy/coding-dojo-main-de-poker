package com.thales.main_de_poker;

import java.util.Map;
import java.util.stream.Stream;

public abstract class Annonce {
	
	protected Map<Valeur, Long> occurenceValeurs;
	
	public Annonce(Map<Valeur, Long> occurenceValeurs) {
		this.occurenceValeurs = occurenceValeurs;
	}
	
	public Annonce() {
		this(null);
	}

	abstract boolean detecter();
	
	abstract String getOutput();
	
	protected boolean detecterNbOccurence(int nbOccurence) {
		Stream<Long> stream = occurenceValeurs.values().stream(); // stream des values
		Stream<Long> filter = stream.filter(x -> x == nbOccurence); // on ne garde que les nbOccurences, ex : [2,2]
		
		return filter.count() == 1;
	}
	

}

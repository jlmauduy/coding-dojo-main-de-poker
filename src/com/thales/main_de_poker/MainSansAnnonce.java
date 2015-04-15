package com.thales.main_de_poker;


public class MainSansAnnonce extends Annonce {

	public MainSansAnnonce() {
		super();
	}

	@Override
	boolean detecter() {
		return false;
	}

	@Override
	String getOutput() {
		return "";
	}

}

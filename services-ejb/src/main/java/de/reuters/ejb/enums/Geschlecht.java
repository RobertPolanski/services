package de.reuters.ejb.enums;

public enum Geschlecht {
	
	FRAU("Frau"),
	MANN("Mann"),
	FIRMA("Firma");
	
	private String geschlecht;
	
	Geschlecht(String geschlecht){
		this.geschlecht = geschlecht;
	}
	
	public String getGeschlecht() {
		return geschlecht;
	}

}



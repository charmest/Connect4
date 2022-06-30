package com.thomasstodonte.puissance4;

public class Joueur {

	private String caractere;
	private String nom;
	
	public Joueur (String caractere, String nom) {
		setCaractere(caractere);
		setNom(nom);
	}
	
	public void joue(Jeu jeu) {}

	public String getCaractere() {
		return caractere;
	}

	public void setCaractere(String caractere) {
		this.caractere = caractere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

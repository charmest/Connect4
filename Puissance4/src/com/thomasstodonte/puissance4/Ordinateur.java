package com.thomasstodonte.puissance4;

import java.util.Random;

public class Ordinateur extends Joueur {

	public Ordinateur(String caractere, String nom) {
		super(caractere, nom);
	}

	public void joue(Jeu jeu) {
		Random r = new Random();
		int random = r.nextInt(jeu.getTaille()-1);
		while (! jeu.joueCoup(random, this.getCaractere())) {
			random = r.nextInt(jeu.getTaille()-1);
		}
		jeu.affichePlateau();
		System.out.println(this.getNom() + " a joué en " + (random + 1));
		return;
	}
}

package com.thomasstodonte.puissance4;

import java.util.Scanner;

public class Humain extends Joueur {

	public Humain(String caractere, String nom) {
		super(caractere, nom);
	}
	
	public void joue(Jeu jeu) {
		System.out.println("Dans quelle colonne souhaitez-vous jouer ?");
		Scanner clavier = new Scanner(System.in);
		int numColonne = clavier.nextInt();
		jeu.joueCoup(numColonne-1, this.getCaractere());
		jeu.affichePlateau();
	}

}

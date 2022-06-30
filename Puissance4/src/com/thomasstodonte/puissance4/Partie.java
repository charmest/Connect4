package com.thomasstodonte.puissance4;

import java.util.Scanner;

public class Partie {

	private Humain humain = new Humain("X", "Thomas");
	private Ordinateur ordinateur = new Ordinateur("O", "Ordinateur");
	private Jeu jeu = new Jeu(8);

	public Partie(Humain humain, Ordinateur ordinateur, Jeu jeu) {
		setHumain(humain);
		setOrdinateur(ordinateur);
		setJeu(jeu);
	}

	public Partie() {
		setHumain(humain);
		setOrdinateur(ordinateur);
		setJeu(jeu);
	}

	public Partie(Humain humain) {
		setHumain(humain);
		setOrdinateur(ordinateur);
		setJeu(jeu);
	}

	public Partie(Humain humain, Jeu jeu) {
		setHumain(humain);
		setOrdinateur(ordinateur);
		setJeu(jeu);
	}

	public Humain getHumain() {
		return humain;
	}

	public void setHumain(Humain humain) {
		this.humain = humain;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public void joue() {
		String vainqueur = "NO";
		Joueur tonTour = ordinateur;
		while (vainqueur.equals("NO")) {
			tonTour.joue(jeu);
			if (jeu.estPlein()) {
				vainqueur = "NO";
			}

			// Si 4 pions sont alignés, on a un vainqueur
			// (même si le jeu est plein!)

			if (jeu.cherche4()) {
				vainqueur = tonTour.getNom();
			}

			// On change de joueur pour l'itération suivante
			if(tonTour == ordinateur){ 
				tonTour = humain;
			}
			else {
				tonTour = ordinateur;
			}
		}

		System.out.println("La partie est finie !");
		jeu.affichePlateau();
		if (vainqueur.equals("NO")) {
			System.out.println("Match nul !");
		} else {
			System.out.println("Le vainqueur est " + vainqueur);
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenue pour cette partie de puissance 4 !");
		System.out.println("Avant toute chose, faisons plus ample connaissance ! Quel est ton nom ?");
		Scanner clavier = new Scanner(System.in);
		String nom = clavier.next();
		System.out.println("Voilà un très joli prénom !");
		Humain joueur = new Humain("X", nom);
		System.out.println("Veuillez maintenant renseigner le nombre de cases du côté du plateau : ");
		int taille = clavier.nextInt();
		Jeu jeu = new Jeu(taille);
		Partie partie = new Partie(joueur, jeu);
		System.out.println("Très bien ! La partie se déroulera sur un plateau de " + jeu.getTaille() + " x "
				+ jeu.getTaille() + " cases");
		partie.joue();
	}
}

package com.thomasstodonte.puissance4;

public class Jeu {

	private int taille;
	public final static String LIBRE = "*";
	private String[][] plateau;

	public Jeu(int taille) {
		setTaille(taille);
		plateau = new String[taille][taille];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				plateau[i][j] = LIBRE;
			}
		}
	}

	public boolean joueCoup(int numColonne, String caractere) {
		if ((numColonne < 0) || (numColonne >= taille)) {
			return false;
		}
		// Trouve la première place vide dans la colonne
		for (int ligne = 0; ligne < taille; ligne++) {
			if (plateau[numColonne][ligne] == LIBRE) {
				plateau[numColonne][ligne] = caractere;
				return true;
			}
		}
		// La colonne est pleine
		return false;
	}
	
	public boolean estPlein() {
		// On cherche une case vide. S'il n'y en a aucune, le tableau est plein
		for (int col = 0; col < getTaille(); col++) {
			for (int ligne = 0; ligne < getTaille(); ligne++) {
				if (getPlateau()[col][ligne].equals(LIBRE)) {
					return false;
				}
			}
		}
		return true;
	}

	public void affichePlateau() {
		System.out.println("----------");
		for (int i = plateau.length - 1; i >= 0; i--) {
			for (int j = 0; j < plateau[i].length; j++) {
				System.out.print(plateau[j][i] + " ");
			}
			System.out.println("");
		}
		System.out.println("----------");
	}

	public boolean cherche4() {
		// Vérifie les horizontales ( - )
		for (int ligne = 0; ligne < taille; ligne++) {
			if (cherche4alignes(0, ligne, 1, 0)) {
				return true;
			}
		}

		// Vérifie les verticales ( ¦ )
		for (int col = 0; col < taille; col++) {
			if (cherche4alignes(col, 0, 0, 1)) {
				return true;
			}
		}

		// Diagonales (cherche depuis la ligne du bas)
		for (int col = 0; col < taille; col++) {
			// Première diagonale ( / )
			if (cherche4alignes(col, 0, 1, 1)) {
				return true;
			}
			// Deuxième diagonale ( \ )
			if (cherche4alignes(col, 0, -1, 1)) {
				return true;
			}
		}

		// Diagonales (cherche depuis les colonnes gauches et droites)
		for (int ligne = 0; ligne < taille; ligne++) {
			// Première diagonale ( / )
			if (cherche4alignes(0, ligne, 1, 1)) {
				return true;
			}
			// Deuxième diagonale ( \ )
			if (cherche4alignes(taille - 1, ligne, -1, 1)) {
				return true;
			}
		}

		// On n'a rien trouvé
		return false;
	}

	private boolean cherche4alignes(int oCol, int oLigne, int dCol, int dLigne) {
		String caractere = LIBRE;
		int compteur = 0;

		int curCol = oCol;
		int curRow = oLigne;

		while ((curCol >= 0) && (curCol < taille) && (curRow >= 0) && (curRow < taille)) {
			if (!plateau[curRow][curCol].equals(caractere)) {
				// Si la couleur change, on réinitialise le compteur
				caractere = plateau[curRow][curCol];
				compteur = 1;
			} else {
				// Sinon on l'incrémente
				compteur++;
			}

			// On sort lorsque le compteur atteint 4
			if ((caractere != LIBRE) && (compteur == 4)) {
				return true;
			}

			// On passe à l'itération suivante
			curCol += dCol;
			curRow += dLigne;
		}

		// Aucun alignement n'a été trouvé
		return false;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(String[][] plateau) {
		this.plateau = plateau;
	}

}

package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


import java.util.Random;


public class UsineDePiece {
	
	public static final int ALEATOIRE_COMPLET = 1;
	public static final int ALEATOIRE_PIECE = 2;
	public static final int CYCLIC = 3;
	public static int mode = 2;
	private static boolean dernierePiece = true;


	
	private UsineDePiece() {
	}
	

	
	public static void setMode(int mode) {
		UsineDePiece.mode = mode;
	}

	public static Piece genererPiece() {
		Random random = new Random();
		Couleur[] couleur = Couleur.values();
		int nbType = random.nextInt(2); //Choisir entre IPiece ou OPiece
		int nbCoul = random.nextInt(7);
		Coordonnees coordonnees = new Coordonnees(2,3);
		
		
		if (mode == ALEATOIRE_COMPLET) {
			if (nbType == 0) {
				return new OPiece(coordonnees,couleur[nbCoul]);
			}
			else {
				return new IPiece (coordonnees, couleur[nbCoul]);
			}
		}
		if (mode == ALEATOIRE_PIECE) {
			if (nbType == 0) {
				return new OPiece(coordonnees, Couleur.ROUGE);
			}
			else {
				return new IPiece (coordonnees, Couleur.ORANGE);
			}
		}
		else {
			if (dernierePiece) {
				dernierePiece = false;
				return new OPiece(coordonnees, Couleur.ROUGE);
			}
			else {
				dernierePiece = true;
				return new IPiece (coordonnees, Couleur.ORANGE);
			}
		}
	}
}

package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {

	public static final double MULTIPLIER_TEINTE = 0.5;
	private int taille = 20;
	private final Piece piece;

	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.taille = taille;
	}

	public Color teinte(Color couleur) {
		double r = couleur.getRed();
		double g = couleur.getGreen();
		double b = couleur.getBlue();

		r = r + (255 - r) * MULTIPLIER_TEINTE;
		g = g + (255 - g) * MULTIPLIER_TEINTE;
		b = b + (255 - b) * MULTIPLIER_TEINTE;

		return new Color((int) (r), (int) (g), (int) (b));
	}

	public void afficherPiece(Graphics2D g2D) {

		Color couleur = this.piece.getElements().get(0).getCouleur().getCouleurPourAffichage();
		Color couleurTeinte = teinte(couleur);

		for (int i = 0; i < 4; i++) {

			if (i == 0) {
				g2D.setColor(couleurTeinte);
			} else {
				g2D.setColor(couleur);
			}
			g2D.fill3DRect(this.piece.getElements().get(i).getCoordonnees().getAbscisse() * taille,
					this.piece.getElements().get(i).getCoordonnees().getOrdonnee() * taille, this.taille, this.taille,
					true);
		}
	}

}

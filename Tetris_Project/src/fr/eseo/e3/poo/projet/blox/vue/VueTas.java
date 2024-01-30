package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {

	public static final double MULTIPLIER_NUANCE = 0.5;
	private final VuePuits vuePuits;
	private final Tas tas;

	public VueTas(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.tas = this.getVuePuits().getPuits().getTas();
	}

	public Color nuance(Color couleur) {

		double r = couleur.getRed();
		double g = couleur.getGreen();
		double b = couleur.getBlue();

		r = r * (1 - MULTIPLIER_NUANCE);
		g = g * (1 - MULTIPLIER_NUANCE);
		b = b * (1 - MULTIPLIER_NUANCE);

		return new Color((int) (r), (int) (g), (int) (b));

	}

	public void afficher(Graphics2D g2D) {

		Color couleur = this.tas.getPuits().getTas().getElements()[0][0].getCouleur().getCouleurPourAffichage();
		Color couleurNuance = nuance(couleur);

		for (int i = 0; i < 4; i++) {

			g2D.setColor(couleurNuance);

			g2D.fill3DRect(
					this.tas.getPuits().getTas().getElements()[0][i].getCoordonnees().getAbscisse()
							* this.tas.getElements().length,
					this.tas.getPuits().getTas().getElements()[0][i].getCoordonnees().getOrdonnee()
							* this.tas.getElements().length,
					this.tas.getElements().length, this.tas.getElements().length, true);
		}

	}

	public VuePuits getVuePuits() {
		return this.vuePuits;
	}

}

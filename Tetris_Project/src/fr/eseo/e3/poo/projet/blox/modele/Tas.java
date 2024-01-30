package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

public class Tas {

	private Element[][] elements;
	private Puits puits;
	private int nbLignes;
	private int nbElements;

	public Tas(Puits puits) {
		this.puits = puits;
		this.elements = new Element[this.puits.getProfondeur()][this.puits.getLargeur()];
	}

	public Tas(Puits puits, int nbElements) {

		this.puits = puits;
		this.nbLignes = nbElements / this.puits.getLargeur() + 1;
		this.nbElements = nbElements;
		this.construireTas(this.nbElements, this.nbLignes, new Random());

	}

	public Tas(Puits puits, int nbElements, int nbLignes) {

		this.puits = puits;
		this.nbLignes = nbLignes;
		this.nbElements = nbElements;
		this.construireTas(this.nbElements, this.nbLignes, new Random());

	}

	public Puits getPuits() {
		return this.puits;

	}

	public Element[][] getElements() {
		return this.elements;

	}

	private void construireTas(int nbElements, int nbLignes, Random rand) {
		this.elements = new Element[this.puits.getProfondeur()][this.puits.getLargeur()];
		if (nbElements == 0 || nbElements >= this.getPuits().getLargeur() * this.getPuits().getProfondeur()) {
			throw new IllegalArgumentException("Erreur");
		}
		int nbPlace = 0;

		while (nbPlace != nbElements) {
			// ordon = profondeur du puits - valeur aleatoire entre 1 et nombre lignes
			// inclusive
			int ordon = getPuits().getProfondeur() - (rand.nextInt(nbLignes) + 1);
			// absci = valeur aleatoir entre 0 et la largeur du puits (exclusive)
			int absci = rand.nextInt(getPuits().getLargeur());

			if (this.elements[ordon][absci] == null) {
				// indiceCouleur = valeur aléatoire entre 0 et le nombre de couleurs dans
				// l'enumeration Couleur (exclusif)
				int indiceCouleur = rand.nextInt(Couleur.values().length);
				// ajouter un element a ces coordonnees avec la couleur dans l'énumeration
				// Couleur qui se trouve à lindiceCouleur
				Element newElement = new Element(absci, ordon, Couleur.values()[indiceCouleur]);
				this.elements[ordon][absci] = newElement;
				nbPlace = nbPlace + 1;
			}
		}
	}

}

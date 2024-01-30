package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {

	private Coordonnees coordonnees;
	private int abscisse;
	private int ordonnee;
	private Couleur couleur;

	// Constructeurs

	public Element(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
		this.couleur = Couleur.ROUGE;
	}

	public Element(int abscisse, int ordonnee) {
		this.coordonnees = new Coordonnees(abscisse, ordonnee);
		this.couleur = Couleur.ROUGE;
	}

	public Element(Coordonnees coordonnees, Couleur couleur) {
		this.coordonnees = coordonnees;
		this.couleur = couleur;
	}

	public Element(int abscisse, int ordonnee, Couleur couleur) {

		this.coordonnees = new Coordonnees(abscisse, ordonnee);
		this.couleur = couleur;
	}

	// //Accesseurs et Mutateurs

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	// Methode

	@Override
	public String toString() {
		return coordonnees.toString() + " - " + this.couleur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Element other = (Element) obj;
		return abscisse == other.abscisse && Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur
				&& ordonnee == other.ordonnee;
	}

	public void deplacerDe(int deltaX, int deltaY) {
		this.setCoordonnees(new Coordonnees(this.getCoordonnees().getAbscisse() + deltaX,
				this.getCoordonnees().getOrdonnee() + deltaY));
	}

}

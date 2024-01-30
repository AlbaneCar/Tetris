package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {

	private List<Element> elements = new ArrayList<Element>();
	private Puits puits;

	public Piece(Coordonnees coordonnees, Couleur couleur) {
		this.elements = new ArrayList<Element>();
		this.setElements(coordonnees, couleur);
		
	}

	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

	public List<Element> getElements() {

		return this.elements;
	}

	public void setPosition(int abscisse, int ordonnee) {
		Coordonnees coordonnees = new Coordonnees(abscisse, ordonnee);
		setElements(coordonnees, this.elements.get(0).getCouleur());
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public void deplacerDe(int deltaX, int deltaY) throws BloxException {
		if (deltaY < 0) {
			throw new IllegalArgumentException("deltaY sincorrect");
		} else if ((deltaY > 1) || (deltaX < -1) || (deltaX >1)) {
			throw new IllegalArgumentException("deltaY incorrect");
		}
		if (this.getPuits() != null) {
			for (int i = 0; i < this.getElements().size(); i++) {
				int x = this.getElements().get(i).getCoordonnees().getAbscisse() + deltaX;
				int y = this.getElements().get(i).getCoordonnees().getOrdonnee() + deltaY;

				if (x < 0 || x >= this.puits.getLargeur()) {
					throw new BloxException("Sortie du puits detectee", BloxException.BLOX_SORTIE_PUITS);
				}
				if (y >= 0) {
					if (y >= this.puits.getTas().getElements().length || x >= this.puits.getTas().getElements()[y].length
							|| this.puits.getTas().getElements()[y][x] != null || y >= this.puits.getProfondeur()) {
						throw new BloxException("Collision detectee", BloxException.BLOX_COLLISION);
					}
				}
			}
		}
		for (int i = 0; i < this.getElements().size(); i++) {
			this.getElements().get(i).deplacerDe(deltaX, deltaY);
		}

	}

	public void tourner(boolean sensHoraire) throws BloxException {
		int abscisseBase = this.getElements().get(0).getCoordonnees().getAbscisse();
		int ordonneeBase = this.getElements().get(0).getCoordonnees().getOrdonnee();
		if (this.getPuits() != null) {
			for (int i = 1; i < this.getElements().size(); i++) {
				int x, y;
				if (sensHoraire) {
					x = (this.getElements().get(i).getCoordonnees().getOrdonnee() - ordonneeBase) * (-1) + abscisseBase;
					y = (this.getElements().get(i).getCoordonnees().getAbscisse() - abscisseBase) + ordonneeBase;
				} else {
					x = (this.getElements().get(i).getCoordonnees().getOrdonnee() - ordonneeBase) + abscisseBase;
					y = (this.getElements().get(i).getCoordonnees().getAbscisse() - abscisseBase) * (-1) + ordonneeBase;
				}
				if (x < 0 || x >= this.puits.getLargeur()) {
					throw new BloxException("Sortie du puits detectee", BloxException.BLOX_SORTIE_PUITS);
				}
				if (y >= this.puits.getTas().getElements().length || x >= this.puits.getTas().getElements()[y].length
						|| this.puits.getTas().getElements()[y][x] != null || y >= this.puits.getProfondeur()) {
					throw new BloxException("Collision detectee", BloxException.BLOX_COLLISION);
				}
				
			}
		}
			for (int i = 1; i < this.getElements().size(); i++) {
				int x, y;
				if (sensHoraire) {
					x = (this.getElements().get(i).getCoordonnees().getOrdonnee() - ordonneeBase) * (-1) + abscisseBase;
					y = (this.getElements().get(i).getCoordonnees().getAbscisse() - abscisseBase) + ordonneeBase;
				} else {
					x = (this.getElements().get(i).getCoordonnees().getOrdonnee() - ordonneeBase) + abscisseBase;
					y = (this.getElements().get(i).getCoordonnees().getAbscisse() - abscisseBase) * (-1) + ordonneeBase;
				}
				this.getElements().get(i).setCoordonnees(new Coordonnees(x, y));
			}

	}

	@Override
	public String toString() {

		String s = "";
		s += this.getClass().getSimpleName() + " :\n";

		for (int i = 0; i < this.getElements().size(); i++) {
			s += "\t" + this.getElements().get(i) + "\n";
		}
		return s;
	}

}

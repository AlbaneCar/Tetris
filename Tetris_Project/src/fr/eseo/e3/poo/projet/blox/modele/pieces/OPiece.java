package fr.eseo.e3.poo.projet.blox.modele.pieces;


import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OPiece extends Piece {

	public OPiece(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees,couleur);

	}

	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		getElements().clear();
		Element element = new Element(coordonnees, couleur);
		Element element1 = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee(), couleur);
		Element element2 = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur);
		Element element3 = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1, couleur);
		getElements().add(element);
		getElements().add(element1);
		getElements().add(element2);
		getElements().add(element3);
	}
	
	public void tourner (boolean sensHoraire) {
		
	}
}

package fr.eseo.e3.poo.projet.blox.modele.pieces;





import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;


public class OPieceTest {

	@Test
	public void constructeurTest() {
		Coordonnees coordonnees = new Coordonnees(2,3);
		OPiece opiece = new OPiece (coordonnees, Couleur.ORANGE);
		assertEquals(new OPiece(coordonnees, Couleur.ORANGE).getElements() , 
					opiece.getElements() , "Problème dans la construction de OPiece");
		assertEquals(coordonnees, opiece.getElements().get(0).getCoordonnees(), "Les coordonnees ne sont pas bien construit" );
		assertEquals(Couleur.ORANGE, opiece.getElements().get(0).getCouleur(), "La couleur n'est pas bien construit" );
		
		
	}
	
	@Test
	public void testPuits() {
		OPiece opiece = new OPiece(new Coordonnees (10,15), Couleur.BLEU);
		Puits puits = new Puits();
		opiece.setPuits(puits);
		assertEquals(new Puits(),opiece.getPuits());
	}
	
	@Test 
	public void toStringTest() {
		Coordonnees coordonnees = new Coordonnees(2,3);
		OPiece opiece = new OPiece(coordonnees, Couleur.ORANGE);
		assertEquals ("OPiece :\n"
				+ "\t(2, 3) - ORANGE\n"
				+ "\t(3, 3) - ORANGE\n"
				+ "\t(2, 2) - ORANGE\n"
				+ "\t(3, 2) - ORANGE\n", opiece.toString(), "Problème dans l'affichage");
	}
	
	@Test
	public void testDeplaceDe() {
		Coordonnees coordonnees = new Coordonnees(2,3);
		OPiece opiece = new OPiece(coordonnees, Couleur.ORANGE);
		Puits puits = new Puits();
		opiece.setPuits(puits);
		try {
			opiece.deplacerDe(1, 0);
		} catch (BloxException e) {
			// TODO Auto-generated catch block
			System.out.println("Une erreur est survenue : ");
		}
		assertEquals (3, opiece.getElements().get(0).getCoordonnees().getAbscisse(), "Problème déplaceDe");
		assertEquals (4, opiece.getElements().get(1).getCoordonnees().getAbscisse(), "Problème déplaceDe");
		assertEquals (3, opiece.getElements().get(2).getCoordonnees().getAbscisse(), "Problème déplaceDe");
		assertEquals (4, opiece.getElements().get(3).getCoordonnees().getAbscisse(), "Problème déplaceDe");
		assertThrows(IllegalArgumentException.class, () -> opiece.deplacerDe(1, -1));
	}
	
	@Test
	public void tournerTest() {
		Coordonnees coordonnees = new Coordonnees(2,3);
		OPiece opiece = new OPiece(coordonnees, Couleur.ORANGE);
		Puits puits = new Puits();
		opiece.setPuits(puits);
		opiece.tourner(false);
		assertEquals(new Coordonnees(3,3), opiece.getElements().get(1).getCoordonnees(), "La pièce bouge, elle ne devrait pas." );
		
	}

}

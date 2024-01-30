package fr.eseo.e3.poo.projet.blox.modele.pieces;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class IPieceTest {

	@Test
	public void constructeurTest() {
		Coordonnees coordonnees = new Coordonnees(2,3);
		IPiece ipiece = new IPiece (coordonnees, Couleur.ORANGE);
		assertEquals(new IPiece(coordonnees, Couleur.ORANGE).getElements() , 
					ipiece.getElements() , "Problème dans la construction de IPiece");
		assertEquals(coordonnees, ipiece.getElements().get(0).getCoordonnees(), "Les coordonnees ne sont pas bien construit" );
		assertEquals(Couleur.ORANGE, ipiece.getElements().get(0).getCouleur(), "La couleur n'est pas bien construit" );
	}
	
	@Test
	public void testPuits() {
		IPiece ipiece = new IPiece(new Coordonnees (10,15), Couleur.BLEU);
		Puits puits = new Puits();
		ipiece.setPuits(puits);
		assertEquals(new Puits(),ipiece.getPuits());
	}
	
	@Test 
	public void toStringTest() {
		Coordonnees coordonnees = new Coordonnees(2,3);
		IPiece ipiece = new IPiece(coordonnees, Couleur.ORANGE);
		assertEquals ("IPiece :\n"
				+ "\t(2, 3) - ORANGE\n"
				+ "\t(2, 2) - ORANGE\n"
				+ "\t(2, 4) - ORANGE\n"
				+ "\t(2, 1) - ORANGE\n", ipiece.toString(), "Problème dans l'affichage");
	}
	
	@Test
	public void testDeplaceDe() {
		
		try {
			Coordonnees coordonnees = new Coordonnees(2,3);
			IPiece ipiece = new IPiece(coordonnees, Couleur.ORANGE);
			Puits puits = new Puits();
			ipiece.setPuits(puits);
			ipiece.deplacerDe(1, 0);
			assertEquals (3, ipiece.getElements().get(0).getCoordonnees().getAbscisse(), "Problème déplaceDe");
			assertThrows(IllegalArgumentException.class, () -> ipiece.deplacerDe(0, -1));
		} catch (BloxException e) {
			// TODO Auto-generated catch block
			System.out.println("Une erreur est survenue : ");
		}
		
		
	}
	
	@Test
	public void tournerTest() {
		
		try {
			Coordonnees coordonnees = new Coordonnees(2,3);
			IPiece ipiece = new IPiece(coordonnees, Couleur.ORANGE);
			Puits puits = new Puits();
			ipiece.setPuits(puits);
			ipiece.tourner(true);
			assertEquals(new Coordonnees(3,3), ipiece.getElements().get(1).getCoordonnees(), "La piece tourne mal." );
		} catch (BloxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

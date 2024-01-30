package fr.eseo.e3.poo.projet.blox.modele;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;

public class PuitsTest {

	@Test
	public void constructeurTest() {
		Puits puits = new Puits();
		assertEquals(5, puits.getLargeur(), "Constructeur : ");
		assertEquals(15, puits.getProfondeur(), "Constructeur : ");
	}
	
	@Test
	public void constructeur2Test() {
		Puits puits = new Puits(10,20);
		assertEquals(10, puits.getLargeur(), "Constructeur : ");
		assertEquals(20, puits.getProfondeur(), "Constructeur : ");
	}
	
	@Test
	public void constructeur3Test() {
		Puits puits = new Puits(15,20);
		//assertThrows(IllegalArgumentException, puits.getLargeur(), "La largeur doir etre entre 5 et 15.");
		assertEquals(15, puits.getLargeur(), "Constructeur : ");
		assertEquals(20, puits.getProfondeur(), "Constructeur : ");
	}
	
	@Test
	public void stringTest(){
		Puits puits = new Puits(10,20);
		Coordonnees coordonnees = new Coordonnees(2,3);
		IPiece ipiece = new IPiece (coordonnees, Couleur.ORANGE);
		puits.setPieceSuivante(ipiece);
		assertEquals("Puits : Dimension 10 x 20\n"
				+ "Piece Actuelle : <aucune>\n"
				+ "Piece Suivante : IPiece :\n"
				+ "\t(2, 3) - ORANGE\n"
				+ "\t(2, 2) - ORANGE\n"
				+ "\t(2, 4) - ORANGE\n"
				+ "\t(2, 1) - ORANGE\n", puits.toString(), "ToString : ");
	}

}

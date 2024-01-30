package fr.eseo.e3.poo.projet.blox.modele;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

public class CouleurTest {

	@Test
	public void getCouleurTest() {
		Coordonnees coordonnees = new Coordonnees(2,3);
		OPiece opiece = new OPiece (coordonnees, Couleur.ORANGE);
		assertEquals(Color.ORANGE, opiece.getElements().get(0).getCouleur().getCouleurPourAffichage(), "GetCouleur :");
	}

}

package fr.eseo.e3.poo.projet.blox.modele;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;


public class UsineDePieceTest {

	@Test
	public void setModeTest() {
		assertEquals(UsineDePiece.ALEATOIRE_PIECE, UsineDePiece.mode, "La methode par défaut ne fonctionne pas.");
		UsineDePiece.setMode(1);
		assertEquals(UsineDePiece.ALEATOIRE_COMPLET, UsineDePiece.mode, "La methode par setMode ne fonctionne pas.");
		UsineDePiece.setMode(3);
		assertEquals(UsineDePiece.CYCLIC, UsineDePiece.mode, "La methode par setMode ne fonctionne pas.");
	}
	
	@Test
	public void genererPieceTest() {
		assertEquals(UsineDePiece.ALEATOIRE_PIECE, UsineDePiece.mode, "La methode par défaut ne fonctionne pas.");
		assertEquals(new IPiece(new Coordonnees(2,3),Couleur.ORANGE	).getClass().getSuperclass(), 
					UsineDePiece.genererPiece().getClass().getSuperclass(), "La méthode genererPiece ne focntionne pas.");
	}

}

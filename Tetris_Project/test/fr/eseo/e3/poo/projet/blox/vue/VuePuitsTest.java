package fr.eseo.e3.poo.projet.blox.vue;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

	@Test
	public void constructeurTest() {
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits);
		assertEquals(new VuePuits(puits).getPuits().getLargeur(), vp.getPuits().getLargeur(), "Constructeur VuePuits");
		assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vp.getTaille(), "Constructeur VuePuits");
	}
	
	@Test
	public void constructeur2Test() {
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits,5);
		assertEquals(new VuePuits(puits).getPuits().getLargeur(), vp.getPuits().getLargeur(), "Constructeur VuePuits");
		assertEquals(5, vp.getTaille(), "Constructeur VuePuits");
	}

}

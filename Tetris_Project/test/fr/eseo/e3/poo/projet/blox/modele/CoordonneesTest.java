package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	public void constructeurTest() {
		Coordonnees coordonnees = new Coordonnees(2,3);
		assertEquals(new Coordonnees(2,3) , coordonnees, "Problème dans la construction de coordonnees");
	}
	
	@Test 
	public void stringTest () {
		Coordonnees coordonnees = new Coordonnees(2,3);
		assertEquals("(2, 3)",coordonnees.toString(),"Problème dans l'affichage");
	}
	
	@Test 
	public void equalsTest () {
		Coordonnees coordonnees = new Coordonnees(2,3);
		Coordonnees coordonnees2 = new Coordonnees(2,3);
		assertTrue(coordonnees.equals(coordonnees2), "La méthode equals ne focntionne pas.");
	}
	
	

}

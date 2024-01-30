package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	public void constructeurTest() {
		Coordonnees coordonnees = new Coordonnees(2, 3);
		Coordonnees coordonnees2 = new Coordonnees(4, 3);
		Element element1 = new Element(coordonnees);
		Element element2 = new Element(4, 3);
		Element element3 = new Element(coordonnees, Couleur.ORANGE);
		Element element4 = new Element(4, 3, Couleur.BLEU);
		assertEquals(new Element(coordonnees, Couleur.ROUGE), element1, "Problème dans la construction de l'element");
		assertEquals(new Element(coordonnees2, Couleur.ROUGE), element2, "Problème dans la construction de l'element");
		assertEquals(new Element(coordonnees, Couleur.ORANGE), element3, "Problème dans la construction de l'element");
		assertEquals(new Element(coordonnees2, Couleur.BLEU), element4, "Problème dans la construction de l'element");
	}

	@Test
	public void toStringTest() {
		Coordonnees coordonnees = new Coordonnees(2, 3);
		Element element3 = new Element(coordonnees, Couleur.ORANGE);
		assertEquals("(2, 3) - ORANGE", element3.toString(), "Problème dans l'affichage");
	}

	@Test
	public void hashCodeTest() {
		Coordonnees coordonnees = new Coordonnees(2, 3);
		Element element1 = new Element(coordonnees);
		Element element3 = new Element(coordonnees, Couleur.ROUGE);
		assertTrue(element1.equals(element3) && element3.equals(element1), "Erreur hashCode");
		assertTrue(element1.hashCode() == element3.hashCode(), "Erreur hashCode");

	}

	@Test
	public void deplacerDeTest() {
		Coordonnees coordonnees2 = new Coordonnees(4, 3);
		Element element1 = new Element(coordonnees2);
		element1.deplacerDe(1, 0);
		assertEquals(5, element1.getCoordonnees().getAbscisse(), "Problème déplaceDe");
	}

}

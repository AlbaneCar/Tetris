package fr.eseo.e3.poo.projet.blox.modele;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasTest {
	
	
	@Test
	public void constructeurTest() {
		Puits puits = new Puits();
		Tas tas = new Tas(puits);
		assertEquals(20, tas.getElements().length,"Constructeur :");
	}
	
	@Test
	public void constructeur2Test() {
		
	}
	
	@Test
	public void constructeur3Test() {
		
	}
}

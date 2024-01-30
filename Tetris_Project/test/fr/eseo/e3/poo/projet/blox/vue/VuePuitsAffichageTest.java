package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
//import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VuePuitsAffichageTest {
	
	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
	}



	 private void testConstructeurPuits() {
		JFrame maFenetre = new JFrame("Puits");
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits);
		vp.getPuits().addPropertyChangeListener(vp);
		Piece p = UsineDePiece.genererPiece();
		vp.getPuits().setPieceSuivante(p);
		vp.setSize(vp.getPreferredSize());
		
		//VuePiece vpi = new VuePiece(p , vp.getTaille());
		try {
			p.tourner(true);
		} catch (BloxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//vp.propertyChange(event);
		//vp.setVuePiece(vpi);

		maFenetre.add(vp,BorderLayout.CENTER);
		maFenetre.pack();
		maFenetre.setLocationRelativeTo(null);
		maFenetre.setVisible(true);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	private void testConstructeurPuitsTaille() {
		JFrame maFenetre2 = new JFrame("Puits et taille");
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits, 40);
		vp.getPuits().addPropertyChangeListener(vp);
		//Piece p = UsineDePiece.genererPiece();
		vp.getPuits().setPieceSuivante(UsineDePiece.genererPiece());
		vp.setSize(vp.getPreferredSize());
		
		
		//VuePiece vpi = new VuePiece(p , vp.getTaille());
		//vp.setVuePiece(vpi);
		
		maFenetre2.add(vp,BorderLayout.CENTER);
		maFenetre2.pack();
		maFenetre2.setLocationRelativeTo(null);
		maFenetre2.setVisible(true);
		maFenetre2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			@Override
			public void run() {
			new VuePuitsAffichageTest();
			}
			});
	}
}

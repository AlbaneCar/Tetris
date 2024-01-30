package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {

	
	public PieceDeplacementTest() {
		testConstructeurDeplacement();
	}
	
	private void testConstructeurDeplacement () {
		JFrame maFenetre = new JFrame("Deplacement");
		Puits puits = new Puits();
		VuePuits vp = new VuePuits(puits);
		Piece p = UsineDePiece.genererPiece();
		Piece p2 = UsineDePiece.genererPiece();
		
		//vp.getPuits().addPropertyChangeListener(vp);
		vp.getPuits().setPieceSuivante(p);
		vp.getPuits().setPieceSuivante(p2);
		vp.getPuits().getPieceActuelle().setPosition(3, 6);
		
		//System.out.println(vuePiece.getTaille());
		System.out.println("Piece suivante" + puits.getPieceSuivante());
		
		//maFenetre.setSize(vp.getPreferredSize());
		maFenetre.add(vp,BorderLayout.CENTER);
		maFenetre.setLocationRelativeTo(null);
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			@Override
			public void run() {
			new PieceDeplacementTest();
			}
			});
	}

}

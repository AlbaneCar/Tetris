package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;



public class PieceRotation extends java.awt.event.MouseAdapter {
	
	private VuePuits vuePuits;
	private Puits puits;

	public PieceRotation (VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		puits = this.vuePuits.getPuits();
	}
	
	public void mouseClicked (MouseEvent event) {
		try {
			if (puits.getPieceActuelle() != null) {
				if( SwingUtilities.isLeftMouseButton(event)) {
					this.puits.getPieceActuelle().tourner(false);				
				}
				else {
					this.puits.getPieceActuelle().tourner(true);
				}

				this.vuePuits.repaint();
			}
			
		} catch (BloxException e1) {
			System.out.println(e1.getMessage());
		}
	}
	

}

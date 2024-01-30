package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends java.awt.event.MouseAdapter {

	private VuePuits vuePuits;
	private Puits puits;
	int c;
	int oldC = -1;

	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		puits = this.vuePuits.getPuits();
	}

	@Override
	public void mouseMoved(MouseEvent event) {

		if (oldC == -1) {
			oldC = (int) Math.floor(event.getX() / vuePuits.getTaille());
		}
		if (this.puits.getPieceActuelle() != null) {
			c = (int) Math.floor(event.getX() / vuePuits.getTaille());
			if (c != oldC) {
				if (c < oldC) {
					// System.out.println("C"+c+"oldC"+oldC);
					try {
						this.puits.getPieceActuelle().deplacerDe(-1, 0);
					} catch (BloxException e1) {
						System.out.print(e1.getMessage());
					}
				} else {
					try {
						this.puits.getPieceActuelle().deplacerDe(1, 0);
						System.out.println("Piece" + puits.getPieceActuelle().getElements());
					} catch (BloxException e1) {
						System.out.print(e1.getMessage());
					}

				}
				oldC = c;
				this.vuePuits.repaint();

			}

		}

	}
	
	@Override
	public void mouseEntered(MouseEvent event) {
		oldC = (int) Math.floor(event.getX() / this.vuePuits.getTaille());

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		try {
			if (puits.getPieceActuelle() != null) {
				if (event.getWheelRotation() > 0) {
					this.puits.getPieceActuelle().deplacerDe(0, 1);
				}
			}
		} catch (BloxException e1) {
			System.out.println(e1.getMessage());
		}
		this.vuePuits.repaint();

	}

}

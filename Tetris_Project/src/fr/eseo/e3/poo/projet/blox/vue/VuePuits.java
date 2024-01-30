package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Color;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends javax.swing.JPanel implements PropertyChangeListener {
	public static final int TAILLE_PAR_DEFAUT = 15;
	private int taille;
	private Puits puits;
	private VuePiece vuePiece;
	//private final VueTas vueTas;
	

	public VuePuits(Puits puits) {
		this.taille = TAILLE_PAR_DEFAUT;
		this.puits = puits;
		this.puits.addPropertyChangeListener(this);
		this.vuePiece = null;
		this.vueTas = null;
		PieceDeplacement pieceDeplacement = new PieceDeplacement(this);
		PieceRotation pieceRotation = new PieceRotation(this);
		this.setPreferredSize(new Dimension(taille * puits.getLargeur(), taille * puits.getProfondeur()));
		this.setBackground(Color.WHITE);
		this.addMouseListener(pieceDeplacement);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
		this.addMouseListener(pieceRotation);
		this.addMouseMotionListener(pieceRotation);
		this.addMouseWheelListener(pieceRotation);
	}

	public VuePuits(Puits puits, int taille) {
		this.taille = taille;
		this.puits = puits;
		this.puits.addPropertyChangeListener(this);
		this.vuePiece = null;
		this.vueTas = null;
		PieceDeplacement pieceDeplacement = new PieceDeplacement(this);
		PieceRotation pieceRotation = new PieceRotation(this);
		this.setPreferredSize(new Dimension(taille * puits.getLargeur(), taille * puits.getProfondeur()));
		this.setBackground(Color.WHITE);
		this.addMouseListener(pieceDeplacement);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
		this.addMouseListener(pieceRotation);
		this.addMouseMotionListener(pieceRotation);
		this.addMouseWheelListener(pieceRotation);
	}

	public Puits getPuits() {
		return this.puits;
	}

	public int getTaille() {
		return this.taille;
	}

	public VuePiece getVuePiece() {
		return this.vuePiece;
	}
	
	public VueTas getVueTas() {
		return this.vueTas;
	}

	public void setTaille(int taille) {
		this.taille = taille;
		this.setPreferredSize(new Dimension(taille * puits.getLargeur(), taille * puits.getProfondeur()));
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
		this.setPreferredSize(new Dimension(taille * puits.getLargeur(), taille * puits.getProfondeur()));
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}

	protected void paintComponent(Graphics g) {

		g.setColor(Color.WHITE);
		super.paintComponent(g);
		/* appel vers super pour remplir le fond du JPanel */

		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < puits.getLargeur(); i++) {
			g.drawLine(this.taille * i, 0, this.taille * i, puits.getProfondeur() * this.taille);
		}
		for (int i = 0; i < puits.getProfondeur(); i++) { /* Horizontale */
			g.drawLine(0, this.taille * i, puits.getLargeur() * this.taille, this.taille * i);
		}

		/*
		 * Le paramètre g est copie en utilisant la méthode copie() puis converti en
		 * instance de Graphics2D grâce à un transtypage (cast) explicite.
		 */

		Graphics2D g2D = (Graphics2D) g.create();
		/* Nous utiliserons l'instance de Graphics2D */

		if (vuePiece != null) {
			vuePiece.afficherPiece(g2D);
		}

		/* Puis nous liberons la memoire */
		g2D.dispose();
		

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
			Piece piece = (Piece) event.getNewValue();
			System.out.println(piece);
			this.setVuePiece(new VuePiece(piece, this.getTaille()));
			
		}
	}

}

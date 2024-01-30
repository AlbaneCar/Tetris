package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {
	public static final int LARGEUR_PAR_DEFAUT = 10; /*Nombre de colonnes */
	public static final int PROFONDEUR_PAR_DEFAUT = 20; /*Nombre de lignes */
	public static final String MODIFICATION_PIECE_ACTUELLE = "pieceActuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE ="pieceSuivante";
	private int profondeur;
	private int largeur;
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private PropertyChangeSupport pcs;
	private Tas tas;
	
	public Puits(){
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.profondeur = PROFONDEUR_PAR_DEFAUT;
		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
		
	}
	
	public Puits(int largeur , int profondeur){
		this.largeur = largeur;
		this.profondeur = profondeur;
		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
		if (largeur>15 || largeur<5) {
			throw new IllegalArgumentException ("La largeur doir etre entre 5 et 15.");
		}
		else if (profondeur > 25 || profondeur < 15) {
			throw new IllegalArgumentException ("La profondeur doit etre etre 15 et 25.");
		}
		
	}
	
	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
		this.largeur = largeur;
		this.profondeur = profondeur;
		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this,nbElements,nbLignes);
		if (largeur>15 || largeur<5) {
			throw new IllegalArgumentException ("La largeur doir etre entre 5 et 15.");
		}
		else if (profondeur > 25 || profondeur < 15) {
			throw new IllegalArgumentException ("La profondeur doit etre etre 15 et 25.");
		}
	}

	public int getProfondeur() {
		return this.profondeur;
	}

	public int getLargeur() {
		return this.largeur;
	}

	public void setProfondeur(int profondeur) {
		if (profondeur > 25 || profondeur < 15) {
            throw new IllegalArgumentException ("La profondeur doit etre dans [15, 25]");
        }
		else {
			this.profondeur = profondeur;}
		
	}

	public void setLargeur(int largeur) {
		if (largeur > 15 || largeur < 5) {
            throw new IllegalArgumentException ("La profondeur doit etre dans [5, 15]");
        }
		this.largeur = largeur;
		
	}
	
	public Piece getPieceActuelle() {
		return this.pieceActuelle;
	}
	
	public Piece getPieceSuivante () {
		return this.pieceSuivante;
	}
	
	public void setPieceSuivante(Piece piece) {
		
		if (this.pieceSuivante != null) {
			Piece ancienValeurActuelle = this.pieceActuelle;
			this.pieceActuelle = this.pieceSuivante; 
			this.pieceActuelle.setPosition(this.largeur/2,-4);
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, ancienValeurActuelle, this.pieceActuelle );
		}
		Piece ancienValeurSuivante = this.pieceSuivante;
		this.pieceSuivante = piece;

		this.pieceSuivante.setPuits(this);
		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE,ancienValeurSuivante, this.pieceSuivante);
		


	}

	@Override
    public String toString() {
        if (this.getPieceActuelle()==null && this.getPieceSuivante()==null) {
            return "Puits : Dimension "+this.getLargeur()+" x "+this.getProfondeur()+"\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>\n";
        }else if (this.getPieceActuelle()==null) {
            return "Puits : Dimension "+this.getLargeur()+" x "
            		+this.getProfondeur()+"\nPiece Actuelle : <aucune>\nPiece Suivante : "+this.getPieceSuivante().toString();
        } else if (this.getPieceSuivante()==null) {
            return "Puits : Dimension "+this.getLargeur()+" x "
            		+this.getProfondeur()+"\nPiece Actuelle : "+this.getPieceActuelle().toString()+"Piece Suivante : <aucune>\n";
        } else {
        	return "Puits : Dimension "+this.getLargeur()+" x "
        		+this.getProfondeur()+"\nPiece Actuelle : "
        		+this.getPieceActuelle().toString()+"Piece Suivante : "+this.getPieceSuivante().toString();
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(largeur, pieceActuelle, pieceSuivante, profondeur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Puits other = (Puits) obj;
		return largeur == other.largeur && Objects.equals(pieceActuelle, other.pieceActuelle)
				&& Objects.equals(pieceSuivante, other.pieceSuivante) && profondeur == other.profondeur;
	}
	
	
	public void addPropertyChangeListener (PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}
	
	
	public void removePropertyChangeListener (PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
	
	public Tas getTas() {
		return this.tas;
		
	}


	
}
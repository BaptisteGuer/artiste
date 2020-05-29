package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.Color;
import javax.swing.UIManager;

import fr.eseo.poo.projet.artiste.modele.Coloriable;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public abstract class Forme implements Coloriable{

	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 150;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");
	private double largeur;
	private double hauteur;
	private Color couleur;
	private Coordonnees position;

	public Forme() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Forme(Coordonnees position, double largeur, double hauteur) {
		setPosition(position);
		setLargeur(largeur);
		setHauteur(hauteur);
		this.couleur = COULEUR_PAR_DEFAUT;
	}

	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	public Forme(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);	
	}

	public Coordonnees getPosition() {
		return position;
	}

	public void setPosition(Coordonnees position) {
		this.position = position;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	@Override
	public Color getCouleur() {
		return couleur;
	}

	@Override
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public double getCadreMaxX() {
		if (this.largeur > 0) {
			return this.position.getAbscisse() + this.largeur;
		} else {
			return this.position.getAbscisse();
		}
	}

	public double getCadreMaxY() {
		if (this.hauteur > 0) {
			return this.position.getOrdonnee() + this.hauteur;
		} else {
			return this.position.getOrdonnee();
		}
	}

	public double getCadreMinX() {
		if (this.largeur > 0) {
			return this.position.getAbscisse();
		} else {
			return this.position.getAbscisse() + this.largeur;
		}
	}

	public double getCadreMinY() {
		if (this.hauteur > 0) {
			return this.position.getOrdonnee();
		} else {
			return this.position.getOrdonnee() + this.hauteur;
		}
	}

	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.position.deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
	}

	public void deplacerDe(double deltaX, double deltaY) {
		this.position.deplacerDe(deltaX, deltaY);
	}

	public abstract double aire();

	public abstract double perimetre();

	public abstract boolean contient(Coordonnees coordonnee);
	
	

}

package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public abstract class Forme {

	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 150;
	private double largeur;
	private double hauteur;
	private Coordonnees position;

	public Forme() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Forme(Coordonnees position, double largeur, double hauteur) {
		setPosition(position);
		setLargeur(largeur);
		setHauteur(hauteur);
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
	
	public  void  setPosition(Coordonnees  position){
		this.position=position;
	}
	
	public double getLargeur() {
		return largeur;
	}
	
	public  void  setLargeur(double  largeur){
		this.largeur=largeur;
	}
	
	public double getHauteur() {
		return hauteur;
	}
	
	public  void  setHauteur(double  hauteur){
		this.hauteur=hauteur;
	}
	
	public double getCadreMaxX() {
		return this.position.getAbscisse() + this.largeur;
	}
	
	public double getCadreMaxY() {
		return this.position.getOrdonnee() + this.hauteur;
	}
	
	public double getCadreMinX() {
		return this.position.getAbscisse();
	}
	
	public double getCadreMinY() {
		return this.position.getOrdonnee();
	}
	
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.position.deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.position.deplacerDe(deltaX, deltaY);
	}
	
	@Override
	public String toString() {
		return " largeur= " + largeur + ", hauteur= " + hauteur + ", position= " + position;
	}

	public abstract double aire();

	public abstract double perimetre();
	
}

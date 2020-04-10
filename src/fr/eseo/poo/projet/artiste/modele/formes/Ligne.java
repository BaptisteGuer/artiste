package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {

	public Ligne() {
		super(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ligne(Coordonnees coordonnees, double largeur, double hauteur) {
		super(coordonnees, largeur, hauteur);
	}

	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
	}

	public Ligne(Coordonnees coordonnees) {
		super(coordonnees);
	}

	public Coordonnees getC1() {
		return super.getPosition();
	}

	public void setC1(Coordonnees coordonnees) {
		super.setPosition(coordonnees);
	}

	public Coordonnees getC2() {
		return new Coordonnees(super.getPosition().getAbscisse() + getLargeur(),
				super.getPosition().getOrdonnee() + getHauteur());
	}

	public void setC2(Coordonnees coordonnees) {
		setHauteur(coordonnees.getOrdonnee() - getC1().getOrdonnee());
		setLargeur(coordonnees.getAbscisse() - getC1().getAbscisse());
	}

	public double getXMin() {
		return (getC1().getAbscisse() < getC2().getAbscisse()) ? getC1().getAbscisse() : getC2().getAbscisse();
	}

	public double getXMax() {
		return (getC1().getAbscisse() > getC2().getAbscisse()) ? getC1().getAbscisse() : getC2().getAbscisse();
	}

	public double getYMin() {
		return (getC1().getOrdonnee() < getC2().getOrdonnee()) ? getC1().getOrdonnee() : getC2().getOrdonnee();
	}

	public double getYMax() {
		return (getC1().getOrdonnee() > getC2().getOrdonnee()) ? getC1().getOrdonnee() : getC2().getOrdonnee();
	}

	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return getC1().distanceVers(getC2());
	}

	@Override
	public String toString() {
		return "[Ligne] C1 : (" + getC1() + ") C2 : (" + getC2() + ") longueur : " + getC1().distanceVers(getC2())
				+ " angle : " + Math.toDegrees(getC1().angleVers(getC2())) + "°";
	}

}

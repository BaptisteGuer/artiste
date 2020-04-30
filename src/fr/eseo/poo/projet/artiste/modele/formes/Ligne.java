package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {

	public static final double EPSILON = 0.9;

	public Ligne() {
		super();
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
		Coordonnees c2 = this.getC2();
		super.setPosition(coordonnees);
		setC2(c2);
	}

	public Coordonnees getC2() {
		return new Coordonnees(super.getPosition().getAbscisse() + getLargeur(),
				super.getPosition().getOrdonnee() + getHauteur());
	}

	public void setC2(Coordonnees coordonnees) {
		setHauteur(coordonnees.getOrdonnee() - getC1().getOrdonnee());
		setLargeur(coordonnees.getAbscisse() - getC1().getAbscisse());
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return getC1().distanceVers(getC2());
	}

	@Override
	public boolean contient(Coordonnees coordonnee) {
		double distanceC1C = getC1().distanceVers(coordonnee);
		double distanceCC2 = coordonnee.distanceVers(getC2());
		double distanceC1C2 = getC1().distanceVers(getC2());
		return (distanceC1C + distanceCC2 - distanceC1C2) <= EPSILON;
	}

	public String toString() {
		Locale locale = Locale.getDefault();
		NumberFormat format = NumberFormat.getInstance(locale);
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(1);
		format.setGroupingUsed(false);
		double angle = Math.toDegrees(getC1().angleVers(getC2()));
		if (angle < 0) {
			angle = angle + 360;
		}
		return "[Ligne] c1 : " + getC1() + " c2 : " + getC2() + " longueur : "
				+ format.format(getC1().distanceVers(getC2())) + " angle : " + format.format(angle) + "°";
	}

}

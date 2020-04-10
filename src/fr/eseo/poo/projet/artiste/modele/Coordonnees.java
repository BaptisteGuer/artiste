package fr.eseo.poo.projet.artiste.modele;

import java.lang.Math;

public class Coordonnees {

	public static final double ABSCISSE_PAR_DEFAUT = 0;
	public static final double ORDONNEE_PAR_DEFAUT = 0;

	private double abscisse;
	private double ordonnee;

	public Coordonnees() {
		this.abscisse = ABSCISSE_PAR_DEFAUT;
		this.ordonnee = ORDONNEE_PAR_DEFAUT;
	}

	public Coordonnees(double x, double y) {
		this.abscisse = x;
		this.ordonnee = y;
	}

	public double getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}

	public double getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(double y) {
		this.ordonnee = y;
	}

	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.abscisse = nouvelleAbscisse;
		this.ordonnee = nouvelleOrdonnee;
	}

	public void deplacerDe(double deltaX, double deltaY) {
		this.abscisse += deltaX;
		this.ordonnee += deltaY;
	}

	public double distanceVers(Coordonnees autre) {
		return Math.sqrt(Math.pow(autre.abscisse - this.abscisse, 2) + Math.pow(autre.ordonnee - this.ordonnee, 2));
	}

	public double angleVers(Coordonnees autre) {
		double angleCoord = Math.atan2(this.ordonnee - autre.ordonnee, this.abscisse - autre.abscisse);
		double angleAbscisse = Math.atan2(0, 1);
		return angleCoord - angleAbscisse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(abscisse);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ordonnee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnees other = (Coordonnees) obj;
		if (Double.doubleToLongBits(abscisse) != Double.doubleToLongBits(other.abscisse))
			return false;
		if (Double.doubleToLongBits(ordonnee) != Double.doubleToLongBits(other.ordonnee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(x=" + abscisse + ", y=" + ordonnee + ")";
	}
}
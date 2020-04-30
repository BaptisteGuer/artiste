package fr.eseo.poo.projet.artiste.modele;

import java.text.NumberFormat;
import java.util.Locale;

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

	public double distanceVers(Coordonnees autreCoordonnees) {
		return Math.sqrt(Math.pow(autreCoordonnees.abscisse - this.abscisse, 2)
				+ Math.pow(autreCoordonnees.ordonnee - this.ordonnee, 2));
	}

	public double angleVers(Coordonnees autreCoordonnees) {
		double angleCoord = Math.atan2(autreCoordonnees.ordonnee - this.ordonnee,
				autreCoordonnees.abscisse - this.abscisse);
		return angleCoord;
	}

	// Issu d'une réflexion de groupe avec Adrien CASTANIE, Evan DELAUNAY & Quentin
	// PINEAU
	@Override
	public String toString() {
		Locale locale = Locale.getDefault();

		NumberFormat format = NumberFormat.getInstance(locale);
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(1);
		format.setGroupingUsed(false);
		return "(" + format.format(this.getAbscisse()) + " , " + format.format(this.getOrdonnee()) + ')';
	}
}
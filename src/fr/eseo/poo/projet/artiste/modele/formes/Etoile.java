package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable {

	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 0;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;
	private List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();
	private int nombreBranches;
	private double anglePremiereBranche;
	private double longueurBranche;
	private boolean estRempli;

	public Etoile() {
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(double taille) {
		this(new Coordonnees(), taille, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(Coordonnees coordonnees) {
		this(coordonnees, Forme.LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(Coordonnees coordonnees, double taille) {
		this(coordonnees, taille, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				LONGUEUR_BRANCHE_PAR_DEFAUT);

	}

	public Etoile(Coordonnees coordonnees, double taille, int nombreBranches, double anglePremiereBranche,
			double longueurBranche) {
		super(coordonnees, taille, taille);
		this.setPosition(coordonnees);
		this.setLargeur(taille);
		this.setNombreBranches(nombreBranches);
		this.setAnglePremiereBranche(anglePremiereBranche);
		this.setLongueurBranche(longueurBranche);
		calculCoordonneesPoints();
	}

	public void calculCoordonneesPoints() {
		if (this.coordonnees != null) {
			this.coordonnees.clear();
		}
		double rayonExter = this.getLargeur() / 2;
		double rayonInter = (this.getLargeur() / 2) * (1 - this.longueurBranche);
		for (int i = 0; i < (2 * this.nombreBranches); i++) {
			double r = (i & 1) == 0 ? rayonExter : rayonInter;
			this.coordonnees.add(new Coordonnees(
					rayonExter + this.getPosition().getAbscisse()
							+ Math.cos(i * (Math.PI / this.nombreBranches) + this.anglePremiereBranche) * r,
					rayonExter + this.getPosition().getOrdonnee()
							+ Math.sin(i * (Math.PI / this.nombreBranches) + this.anglePremiereBranche) * r));
		}
	}

	public List<Coordonnees> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(ArrayList<Coordonnees> coordonnees) {
		this.coordonnees = coordonnees;
	}

	public int getNombreBranches() {
		return nombreBranches;
	}

	public void setNombreBranches(int nbBranches) {
		if (nbBranches < 3 || nbBranches > 15) {
			throw new IllegalArgumentException("Le nombre de branche d'une étoile doit être compris entre 3 et 15.");
		}
		this.nombreBranches = nbBranches;
		calculCoordonneesPoints();
	}

	public double getAnglePremiereBranche() {
		return anglePremiereBranche;
	}

	public void setAnglePremiereBranche(double angle) {
		if (angle < -Math.PI || angle > Math.PI) {
			throw new IllegalArgumentException(
					"L'angle formé entre la première branche et l’horizontale doit être compris entre PI et -PI");
		}
		this.anglePremiereBranche = angle;
		calculCoordonneesPoints();
	}

	public double getLongueurBranche() {
		return longueurBranche;
	}

	public void setLongueurBranche(double longueur) {
		if (longueur < 0.0 || longueur > 1.0) {
			throw new IllegalArgumentException(
					"La longueur d'une branche ne peut être inférieure à 0 ou supérieure à 1.");
		}
		this.longueurBranche = longueur;
		calculCoordonneesPoints();
	}

	@Override
	public void setPosition(Coordonnees position) {
		super.setPosition(position);
		calculCoordonneesPoints();
	}

	@Override
	public void setHauteur(double hauteur) {
		if (hauteur < 0) {
			throw new IllegalArgumentException("La hauteur d'une étoile ne peut être < 0.");
		}
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
		calculCoordonneesPoints();
	}

	@Override
	public void setLargeur(double largeur) {
		if (largeur < 0) {
			throw new IllegalArgumentException("La largeur d'une étoile ne peut être < 0.");
		}
		super.setLargeur(largeur);
		super.setHauteur(largeur);
		calculCoordonneesPoints();
	}

	@Override
	public double aire() {
		double base = this.coordonnees.get(1).distanceVers(this.coordonnees.get(3));
		double ht = (this.getLargeur() / 2) * (1 - this.longueurBranche);
		double hT = (this.getLargeur() / 2) - ht;
		double aT = (base * hT) / 2;
		double at = (base * ht) / 2;
		return aT * nombreBranches + at * nombreBranches;
	}

	@Override
	public double perimetre() {
		return this.coordonnees.get(0).distanceVers(this.coordonnees.get(1)) * (nombreBranches * 2);
	}

	@Override
	public boolean contient(Coordonnees coordonnee) {
		boolean result = false;
		int j = this.coordonnees.size() - 1;
		for (int i = 0; i < this.coordonnees.size(); i++) {
			if (this.coordonnees.get(i).getOrdonnee() < coordonnee.getOrdonnee()
					&& this.coordonnees.get(j).getOrdonnee() >= coordonnee.getOrdonnee()
					|| this.coordonnees.get(j).getOrdonnee() < coordonnee.getOrdonnee()
							&& this.coordonnees.get(i).getOrdonnee() >= coordonnee.getOrdonnee()) {
				if (this.coordonnees.get(i).getAbscisse()
						+ (coordonnee.getOrdonnee() - this.coordonnees.get(i).getOrdonnee())
								/ (this.coordonnees.get(j).getOrdonnee() - this.coordonnees.get(i).getOrdonnee())
								* (this.coordonnees.get(j).getAbscisse()
										- this.coordonnees.get(i).getAbscisse()) < coordonnee.getAbscisse()) {
					result = !result;
				}
			}
			j = i;
		}
		return result;
	}

	@Override
	public boolean estRempli() {
		return estRempli;
	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.estRempli = modeRemplissage;
	}

	public String toString() {
		String sorte = "[Etoile]";
		if (this.estRempli) {
			sorte = "[Etoile-Rempli]";
		}
		Locale locale = Locale.getDefault();
		NumberFormat format = NumberFormat.getInstance(locale);
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(1);
		format.setGroupingUsed(false);
		char vert = 'V';
		if (locale.getLanguage().equals("en")) {
			vert = 'G';
		}
		return sorte + " : pos " + getPosition() + " dim " + format.format(getLargeur()) + " x "
				+ format.format(getHauteur()) + " périmètre : " + format.format(perimetre()) + " aire : "
				+ format.format(aire()) + " couleur = R" + this.getCouleur().getRed() + "," + vert
				+ this.getCouleur().getGreen() + ",B" + this.getCouleur().getBlue();
	}

}

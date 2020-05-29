package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Ellipse extends Forme implements Remplissable {

	private boolean estRempli;

	public Ellipse() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		this.estRempli = false;
	}

	public Ellipse(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	public Ellipse(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	@Override
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		if (hauteur < 0) {
			throw new IllegalArgumentException("La hauteur d'un(e) cercle/ellipse ne peut être < 0.");
		}
	}

	@Override
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		if (largeur < 0) {
			throw new IllegalArgumentException("La largeur d'un(e) cercle/ellipse ne peut être < 0.");
		}
	}

	@Override
	public double aire() {
		return Math.PI * (getHauteur() / 2) * (getLargeur() / 2);
	}

	@Override
	public double perimetre() {
		double grandRayon, petitRayon, h;
		if (getHauteur() < getLargeur()) {
			petitRayon = getLargeur() / 2;
			grandRayon = getHauteur() / 2;
		} else {
			grandRayon = getLargeur() / 2;
			petitRayon = getHauteur() / 2;
		}
		h = Math.pow((grandRayon - petitRayon) / (grandRayon + petitRayon), 2);
		return Math.PI * (grandRayon + petitRayon) * (1 + ((3 * h) / (10 + Math.sqrt(4 - 3 * h))));
	}

	@Override
	public boolean contient(Coordonnees coordonnee) {
		double demiLargeur = getLargeur() / 2;
		double demiHauteur = getHauteur() / 2;
		double centreX = getPosition().getAbscisse() + demiLargeur;
		double centreY = getPosition().getOrdonnee() + demiHauteur;
		return (Math.pow((coordonnee.getAbscisse() - centreX), 2) / Math.pow(demiLargeur, 2)
				+ Math.pow((coordonnee.getOrdonnee() - centreY), 2) / Math.pow(demiHauteur, 2)) <= 1;
	}

	public String toString() {
		String sorte;
		if (this instanceof Cercle) {
			sorte = "[Cercle]";
			if (this.estRempli()) {
				sorte = "[Cercle-Rempli]";
			}
		} else {
			sorte = "[Ellipse]";
			if (this.estRempli()) {
				sorte = "[Ellipse-Rempli]";
			}
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

	@Override
	public boolean estRempli() {
		return estRempli;
	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.estRempli = modeRemplissage;
	}

}

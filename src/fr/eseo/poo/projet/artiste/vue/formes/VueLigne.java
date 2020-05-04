package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme {

	public VueLigne(Ligne ligne) {
		super(ligne);
	}

	public void affiche(Graphics2D g2d) {
		g2d.drawLine((int) Math.round(((Ligne) this.forme).getC1().getAbscisse()),
				(int) Math.round(((Ligne) this.forme).getC1().getOrdonnee()),
				(int) Math.round(((Ligne) this.forme).getC2().getAbscisse()),
				(int) Math.round(((Ligne) this.forme).getC2().getOrdonnee()));
	}

}

package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme {

	public VueEtoile(Etoile etoile) {
		super(etoile);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		g2d.setColor(this.forme.getCouleur());
		Etoile e = (Etoile) this.forme;
		Path2D shape = new Path2D.Double();
		shape.moveTo(Math.round(e.getCoordonnees().get(0).getAbscisse()),Math.round(e.getCoordonnees().get(0).getOrdonnee()));
		for(int i = 1; i<e.getCoordonnees().size(); i++) {
			shape.lineTo(Math.round(e.getCoordonnees().get(i).getAbscisse()), Math.round(e.getCoordonnees().get(i).getOrdonnee()));
		}
		shape.lineTo(Math.round(e.getCoordonnees().get(0).getAbscisse()),Math.round(e.getCoordonnees().get(0).getOrdonnee()));
		shape.closePath();
		if (((Etoile) this.forme).estRempli()) {
			g2d.fill(shape);
			g2d.draw(shape);
		} else {
			g2d.draw(shape);
		}
	}
}

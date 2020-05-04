package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {

	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		g2d.draw(new Ellipse2D.Double(((Ellipse) this.forme).getPosition().getAbscisse(),
				((Ellipse) this.forme).getPosition().getOrdonnee(), ((Ellipse) this.forme).getLargeur(),
				((Ellipse) this.forme).getHauteur()));
	}

}

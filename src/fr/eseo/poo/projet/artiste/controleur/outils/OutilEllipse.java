package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		Ellipse ellipse = new Ellipse();
		Double maxY = Math.max(getDebut().getOrdonnee(), getFin().getOrdonnee());
		Double minY = Math.min(getDebut().getOrdonnee(), getFin().getOrdonnee());
		Double maxX = Math.max(getDebut().getAbscisse(), getFin().getAbscisse());
		Double minX = Math.min(getDebut().getAbscisse(), getFin().getAbscisse());
		
		ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
		ellipse.setPosition(new Coordonnees(minX, minY));
		ellipse.setHauteur(maxY - minY);
		ellipse.setLargeur(maxX - minX);
		ellipse.setRempli(this.getPanneauDessin().getModeRemplissage());
		VueEllipse vueE = new VueEllipse(ellipse);
		return vueE;
	}
}

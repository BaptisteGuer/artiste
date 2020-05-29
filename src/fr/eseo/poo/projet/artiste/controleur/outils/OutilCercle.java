package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme {

	// Issu d'une réflexion de groupe avec Adrien CASTANIE, Evan DELAUNAY & Quentin
	// PINEAU
	@Override
	protected VueForme creerVueForme() {
		Cercle cercle = new Cercle();
		cercle.setLargeur(Math.max(Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee()),
				Math.abs(getFin().getAbscisse() - getDebut().getAbscisse())));
		if (getDebut().getAbscisse() > getFin().getAbscisse() && getDebut().getOrdonnee() > getFin().getOrdonnee()) {
			cercle.setPosition(new Coordonnees(getDebut().getAbscisse() - cercle.getLargeur(),
					getDebut().getOrdonnee() - cercle.getLargeur()));
		} else if (getDebut().getAbscisse() > getFin().getAbscisse()
				&& getDebut().getOrdonnee() < getFin().getOrdonnee()) {
			cercle.setPosition(
					new Coordonnees(getDebut().getAbscisse() - cercle.getLargeur(), getDebut().getOrdonnee()));
		} else if (getDebut().getAbscisse() < getFin().getAbscisse()
				&& getDebut().getOrdonnee() > getFin().getOrdonnee()) {
			cercle.setPosition(
					new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - cercle.getLargeur()));
		} else {
			cercle.setPosition(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee()));
		}
		cercle.setRempli(this.getPanneauDessin().getModeRemplissage());
		cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		VueCercle vueC = new VueCercle(cercle);
		return vueC;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			setDebut(new Coordonnees(event.getX(), event.getY()));
			setFin(new Coordonnees(event.getX() + Cercle.LARGEUR_PAR_DEFAUT, event.getY() + Cercle.LARGEUR_PAR_DEFAUT));
			this.getPanneauDessin().ajouterVueForme(creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}

}

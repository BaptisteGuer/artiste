package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {

	@Override
	public void mouseReleased(MouseEvent event) {
		super.mouseReleased(event);
		if (getDebut().getAbscisse() != getFin().getAbscisse() || getDebut().getOrdonnee() != getFin().getOrdonnee()) {
			this.getPanneauDessin().ajouterVueForme(creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			setDebut(new Coordonnees(event.getX(), event.getY()));
			setFin(new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT, event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
			this.getPanneauDessin().ajouterVueForme(creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}

	protected abstract VueForme creerVueForme();

}

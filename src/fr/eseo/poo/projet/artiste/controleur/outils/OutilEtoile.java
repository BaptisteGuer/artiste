package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme {

	private PanneauBarreOutils panneauBarreOutils;

	public OutilEtoile(PanneauBarreOutils panneauBarreOutils) {
		this.panneauBarreOutils = panneauBarreOutils;
	}

	@Override
	protected VueForme creerVueForme() {
		Etoile etoile = new Etoile();
		if (getFin() == null) {
			etoile.setPosition(getDebut());
			etoile.setLargeur(Forme.LARGEUR_PAR_DEFAUT);
			etoile.setAnglePremiereBranche(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT);

		} else {
			double distance = getDebut().distanceVers(getFin());
			double angle = getFin().angleVers(getDebut());
			etoile.setAnglePremiereBranche(angle);
			etoile.setLargeur(distance * 2);
			etoile.setPosition(new Coordonnees(getFin().getAbscisse() - etoile.getLargeur() / 2,
					getFin().getOrdonnee() - etoile.getLargeur() / 2));
		}
		etoile.setCouleur(this.getPanneauDessin().getCouleurCourante());
		etoile.setLongueurBranche(this.panneauBarreOutils.getLongueurBranche());
		etoile.setNombreBranches(this.panneauBarreOutils.getNbBranches());
		etoile.setRempli(this.getPanneauDessin().getModeRemplissage());

		VueEtoile ve = new VueEtoile(etoile);
		return ve;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			setDebut(new Coordonnees(event.getX(), event.getY()));
			setFin(null);
			this.getPanneauDessin().ajouterVueForme(creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}

}

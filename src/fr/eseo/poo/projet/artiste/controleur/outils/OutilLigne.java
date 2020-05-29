package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		Ligne ligne = new Ligne();
		ligne.setC1(getDebut());
		ligne.setC2(getFin());
		ligne.setCouleur(this.getPanneauDessin().getCouleurCourante());
		VueLigne vueL = new VueLigne(ligne);
		return vueL;
	}

}

package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends AbstractAction {

	public static final String NOM_ACTION = "Choix couleur";
	private PanneauDessin panneauDessin;

	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.setPanneauDessin(panneauDessin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color couleur = JColorChooser.showDialog(panneauDessin, NOM_ACTION, this.panneauDessin.getCouleurCourante());
		if (couleur != null) {
			this.panneauDessin.setCouleurCourante(couleur);
		}
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}

}

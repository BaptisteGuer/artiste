package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissage extends AbstractAction {

	public static final String NOM_ACTION = "Choix remplissage";
	private PanneauDessin panneauDessin;

	public ActionChoisirRemplissage(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.setPanneauDessin(panneauDessin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.panneauDessin.getModeRemplissage()) {
			this.panneauDessin.setModeRemplissage(false);
		} else {
			this.panneauDessin.setModeRemplissage(true);
		}
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}

}

package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends AbstractAction {

	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	private PanneauDessin panneauDessin;
	private PanneauBarreOutils panneauOutils;
	private String action;

	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String action) {
		super(action);
		this.panneauDessin = panneauDessin;
		this.panneauOutils = panneauOutils;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case NOM_ACTION_LIGNE:
			this.action = NOM_ACTION_LIGNE;
			this.panneauDessin.associerOutil(new OutilLigne());
			break;
		case NOM_ACTION_ELLIPSE:
			this.action = NOM_ACTION_ELLIPSE;
			this.panneauDessin.associerOutil(new OutilEllipse());
			break;
		case NOM_ACTION_CERCLE:
			this.action = NOM_ACTION_CERCLE;
			this.panneauDessin.associerOutil(new OutilCercle());
			break;
		default:
			
		}
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}

	public PanneauBarreOutils getPanneauOutils() {
		return panneauOutils;
	}

	public void setPanneauOutils(PanneauBarreOutils panneauOutils) {
		this.panneauOutils = panneauOutils;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}

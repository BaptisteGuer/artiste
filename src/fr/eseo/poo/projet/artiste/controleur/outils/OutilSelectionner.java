package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilSelectionner extends Outil {

	private Forme formeSelectionnee;

	@Override
	public void mouseClicked(MouseEvent event) {
		this.setFormeSelectionnee(null);
		for (VueForme vf : this.getPanneauDessin().getVueFormes()) {
			if (vf.getForme().contient(new Coordonnees(event.getX(), event.getY()))) {
				this.setFormeSelectionnee(vf.getForme());
			}
		}
		if (this.getFormeSelectionnee() != null) {
			JOptionPane.showMessageDialog(this.getPanneauDessin(), this.formeSelectionnee.toString(),
					ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public Forme getFormeSelectionnee() {
		return formeSelectionnee;
	}

	public void setFormeSelectionnee(Forme formeSelectionnee) {
		this.formeSelectionnee = formeSelectionnee;
	}

}

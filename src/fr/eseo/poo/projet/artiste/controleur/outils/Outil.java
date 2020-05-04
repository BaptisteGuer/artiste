package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements MouseInputListener {

	private Coordonnees debut;
	private Coordonnees fin;
	private PanneauDessin panneauDessin;

	public void setDebut(Coordonnees debut) {
		this.debut = debut;
	}

	public void setFin(Coordonnees fin) {
		this.fin = fin;
	}

	public Coordonnees getDebut() {
		return this.debut;
	}

	public Coordonnees getFin() {
		return this.fin;
	}

	public PanneauDessin getPanneauDessin() {
		return this.panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setDebut(new Coordonnees(e.getX(), e.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setFin(new Coordonnees(e.getX(), e.getY()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

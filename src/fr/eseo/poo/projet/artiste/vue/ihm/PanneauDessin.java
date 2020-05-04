package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends JPanel {

	public static final int LARGEUR_PAR_DEFAUT = 300;
	public static final int HAUTEUR_PAR_DEFAUT = 300;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.green;
	private final List<VueForme> vueFormes;
	private Outil outilCourant;

	public PanneauDessin(int largeur, int hauteur, Color color) {
		this.vueFormes = new ArrayList<VueForme>();
		setPreferredSize(new Dimension(largeur, hauteur));
		setBackground(color);
	}

	public PanneauDessin() {
		this.vueFormes = new ArrayList<VueForme>();
		setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		setBackground(COULEUR_FOND_PAR_DEFAUT);
	}

	public List<VueForme> getVueFormes() {
		return this.vueFormes;
	}

	public void ajouterVueForme(VueForme vueForme) {
		this.vueFormes.add(vueForme);
	}

	@Override
	protected void paintComponent(Graphics g2d) {
		super.paintComponent(g2d);
		Graphics2D g2D = (Graphics2D) g2d.create();
		for (VueForme vue : vueFormes) {
			vue.affiche(g2D);
		}
		g2D.dispose();
	}

	public void associerOutil(Outil outil) {
		if (outil != null) {
			dissocierOutil();
			setOutilCourant(outil);
			outil.setPanneauDessin(this);
			addMouseListener(outil);
			addMouseMotionListener(outil);
		}
	}

	private void dissocierOutil() {
		if (this.outilCourant != null) {
			removeMouseListener(this.outilCourant);
			removeMouseMotionListener(this.outilCourant);
			getOutilCourant().setPanneauDessin(null);
			setOutilCourant(null);
		}
	}

	public Outil getOutilCourant() {
		return this.outilCourant;
	}

	private void setOutilCourant(Outil outilCourant) {
		this.outilCourant = outilCourant;
	}

}

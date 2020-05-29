package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueCercleTest();
			}
		});
	}

	public VueCercleTest() {
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);
		Cercle c1 = new Cercle(new Coordonnees(14, 15), 42);
		VueCercle vc1 = new VueCercle(c1);
		Cercle c2 = new Cercle(new Coordonnees(45, 35), 42);
		c2.setCouleur(Color.red);
		VueCercle vc2 = new VueCercle(c2);
		Cercle c3 = new Cercle(new Coordonnees(85, 12), 78);
		c3.setCouleur(Color.green);
		c3.setRempli(true);
		VueCercle vc3 = new VueCercle(c3);
		panel.ajouterVueForme(vc2);
		panel.ajouterVueForme(vc1);
		panel.ajouterVueForme(vc3);
		JFrame jframe = new JFrame("VueEllipseTest");
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
}

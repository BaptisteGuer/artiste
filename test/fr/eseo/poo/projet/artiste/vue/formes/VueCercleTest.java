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
		VueEllipse vc1 = new VueEllipse(c1);
		panel.ajouterVueForme(vc1);
		JFrame jframe = new JFrame("VueEllipseTest");
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
}

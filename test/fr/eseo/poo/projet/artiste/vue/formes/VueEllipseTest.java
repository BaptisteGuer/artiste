package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEllipseTest();
			}
		});
	}
	
	public VueEllipseTest(){
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);	
		Ellipse e1 = new Ellipse(new Coordonnees(14, 15), 42, 150);
		VueEllipse ve1 = new VueEllipse(e1);
		panel.ajouterVueForme(ve1);
		JFrame jframe = new JFrame("VueEllipseTest");
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}

}

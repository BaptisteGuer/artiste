package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEtoileTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEtoileTest();
			}
		});
	}
	
	public VueEtoileTest(){
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);	
		Etoile e1 = new Etoile(new Coordonnees(14, 15), 42, 5, Math.PI, 0.4);
		VueEtoile ve1 = new VueEtoile(e1);
		Etoile e2 = new Etoile(new Coordonnees(35, 45), 42, 7, -Math.PI, 0.2);
		e2.setCouleur(Color.cyan);
		VueEtoile ve2 = new VueEtoile(e2);
		Etoile e3 = new Etoile(new Coordonnees(10, 96), 54, 14, 0, 0.7);
		e3.setCouleur(Color.orange);
		e3.setRempli(true);
		VueEtoile ve3 = new VueEtoile(e3);
		panel.ajouterVueForme(ve3);
		panel.ajouterVueForme(ve2);
		panel.ajouterVueForme(ve1);
		JFrame jframe = new JFrame("VueEllipseTest");
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
}

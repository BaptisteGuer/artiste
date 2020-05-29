package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueLigneTest();
			}
		});
	}

	public VueLigneTest() {
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);	
		Ligne l1 = new Ligne(new Coordonnees(14, 15), 42, 150);
		VueLigne vl1 = new VueLigne(l1);
		Ligne l2 = new Ligne(new Coordonnees(30, 30), 42, 150);
		l2.setCouleur(Color.GREEN);
		VueLigne vl2 = new VueLigne(l2);
		panel.ajouterVueForme(vl2);
		panel.ajouterVueForme(vl1);
		JFrame jframe = new JFrame("VueLigneTest");
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}

}

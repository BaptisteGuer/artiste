package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilCercleTest();
			}
		});
	}

	public OutilCercleTest() {
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);
		OutilCercle oc = new OutilCercle();
		panel.associerOutil(oc);
		JFrame jframe = new JFrame("OutilCercleTest");
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}

}

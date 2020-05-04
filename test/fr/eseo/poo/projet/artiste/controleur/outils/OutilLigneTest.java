package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilLigneTest();
			}
		});
	}

	public OutilLigneTest() {
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);
		OutilLigne o1 = new OutilLigne();
		panel.associerOutil(o1);
		JFrame jframe = new JFrame("OutilLigneTest");
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	};
}

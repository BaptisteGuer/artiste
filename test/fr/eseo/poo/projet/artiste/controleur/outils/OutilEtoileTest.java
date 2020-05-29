package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEtoileTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilEtoileTest();
			}
		});
	}
	
	public OutilEtoileTest() {
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);
		PanneauBarreOutils po = new PanneauBarreOutils(panel);
		OutilEtoile oe1 = new OutilEtoile(po);
		panel.associerOutil(oe1);
		JFrame jframe = new JFrame("OutilEtoileTest");
		jframe.add(panel);
		jframe.add(po, BorderLayout.EAST);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	};
}

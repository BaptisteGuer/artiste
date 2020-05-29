package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauBarreOutilsTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauBarreOutilsTest();
			}
		});
	}
	
	public PanneauBarreOutilsTest() {
		PanneauDessin panneauDessin = new PanneauDessin(500, 500, Color.white);
		JFrame pboframe = new JFrame("PanneauBarreOutil");
		PanneauBarreOutils pbo = new PanneauBarreOutils(panneauDessin);
		pboframe.add(pbo, BorderLayout.EAST);
		pboframe.add(panneauDessin);
		pboframe.setSize(new Dimension(1000, 1000));
		pboframe.setLocationRelativeTo(null);
		pboframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pboframe.setVisible(true);
	}
}

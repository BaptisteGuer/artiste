package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissageTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ActionChoisirRemplissageTest();
			}
		});
	}
	
	public ActionChoisirRemplissageTest() {
		JFrame jframe = new JFrame("ChoisirRemplissageTest");
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);
		PanneauBarreOutils bo = new PanneauBarreOutils(panel);
		jframe.add(bo, BorderLayout.EAST);
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
}

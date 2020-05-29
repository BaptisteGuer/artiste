package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEllipseTest {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilEllipseTest();
			}
		});
	}
	
	public OutilEllipseTest() {
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);
		OutilEllipse oe1 = new OutilEllipse();
		panel.associerOutil(oe1);
		JFrame jframe = new JFrame("OutilEllipseTest");
		jframe.add(panel);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	};

}

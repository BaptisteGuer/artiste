package fr.eseo.poo.projet.artiste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EtreUnArtiste();
			}
		});
	}
	
	
	public EtreUnArtiste(){
		PanneauDessin panel = new PanneauDessin(500, 500, Color.white);	
		PanneauBarreOutils panelOutils = new PanneauBarreOutils(panel);
		JFrame jframe = new JFrame("Etre Un Artiste");
		jframe.add(panel);
		jframe.add(panelOutils, BorderLayout.EAST);
		jframe.setSize(new Dimension(1000, 1000));
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}

}

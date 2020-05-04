package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauDessinTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauDessinTest();
			}
		});
	}

	public PanneauDessinTest() {
		testConstructeur();
		testConstructeurParDefaut();
	}

	private void testConstructeurParDefaut() {
		PanneauDessin etreUnArtistePanel = new PanneauDessin();
		JFrame etreUnArtiste = new JFrame("Etre un Artiste");
		etreUnArtiste.add(etreUnArtistePanel);
		etreUnArtiste.setSize(new Dimension(1000, 1000));
		etreUnArtiste.setLocationRelativeTo(null);
		etreUnArtiste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		etreUnArtiste.setVisible(true);
	}

	private void testConstructeur() {
		PanneauDessin bluesDuBusinessmanPanel = new PanneauDessin(500, 500, Color.white);
		JFrame bluesDuBusinessman = new JFrame("Blues du Businessman");
		bluesDuBusinessman.add(bluesDuBusinessmanPanel);
		bluesDuBusinessman.setSize(new Dimension(1000, 1000));
		bluesDuBusinessman.setLocationRelativeTo(null);
		bluesDuBusinessman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bluesDuBusinessman.setVisible(true);
	}

}

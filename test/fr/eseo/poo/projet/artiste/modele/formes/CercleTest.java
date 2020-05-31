package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeur() {
		Cercle c1 = new Cercle(new Coordonnees(10, -10), 10);
		assertEquals("Test largeur du constructeur de Cercle avec coordonee, et largeur",10, c1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Cercle avec coordonee, et largeur",10, c1.getHauteur(), EPSILON);
		assertEquals("Test abscisse du constructeur de Cercle avec coordonee, et largeur",-10, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Cercle avec coordonee, et largeur",10, c1.getPosition().getAbscisse(), EPSILON);
	}

	@Test
	public void testConstructeurVide() {
		Cercle c1 = new Cercle();
		assertEquals("Test abscisse du constructeur de Cercle vide",0, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Cercle vide",0, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Cercle vide",Cercle.LARGEUR_PAR_DEFAUT, c1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Cercle vide",Cercle.LARGEUR_PAR_DEFAUT, c1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurOrdonneeAbscisse() {
		Cercle c1 = new Cercle(new Coordonnees(-14, 63));
		assertEquals("Test abscisse du constructeur de Cercle avec coordonnee",-14, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Cercle avec coordonnee",63, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Cercle avec coordonnee",Cercle.LARGEUR_PAR_DEFAUT, c1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Cercle avec coordonnee",Cercle.LARGEUR_PAR_DEFAUT, c1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurLargeurHauteur() {
		Cercle c1 = new Cercle(50);
		assertEquals("Test abscisse du constructeur de Cercle avec largeur",0, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Cercle avec largeur",0, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Cercle avec largeur",50, c1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Cercle avec largeur",50, c1.getHauteur(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Cercle c1 = new Cercle();
		c1.setHauteur(10);
		c1.setLargeur(7);
		assertEquals("Test perimetre de Cercle",21.991, c1.perimetre(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Cercle c1 = new Cercle(new Coordonnees(85, 50),10);
		Locale.setDefault(new Locale("fr"));
		assertEquals("Test toString FR de Cercle",
				"[Cercle] : pos (85,0 , 50,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51",
				c1.toString());
	}

	@Test
	public void testToStringUK() {
		Cercle c1 = new Cercle(new Coordonnees(85, 50),10);
		Locale.setDefault(new Locale("en"));
		assertEquals("Test toString EN de Cercle",
				"[Cercle] : pos (85.0 , 50.0) dim 10.0 x 10.0 périmètre : 31.42 aire : 78.54 couleur = R51,G51,B51",
				c1.toString());
	}

	@Test
	public void testCouleur() {
		Cercle c1 = new Cercle();
		c1.setCouleur(Color.gray);
		assertEquals("Test setter/getter de couleur de Cercle",Color.gray, c1.getCouleur());
	}

	@Test
	public void testRemplissage() {
		Cercle c1 = new Cercle(10);
		c1.setRempli(true);
		Locale.setDefault(new Locale("fr"));
		assertEquals("Test toString FR avec remplissage de Cercle",
				"[Cercle-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51",
				c1.toString());
	}
}

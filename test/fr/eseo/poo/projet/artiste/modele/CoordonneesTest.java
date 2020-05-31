package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

public class CoordonneesTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeurVide() {
		Coordonnees coordonnee = new Coordonnees();
		assertEquals("Test abscisse du constructeur vide de Coordonnee",0, coordonnee.getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur vide de Coordonnee",0, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeur() {
		Coordonnees coordonnee = new Coordonnees(15, 17);
		assertEquals("Test abscisse du constructeur avec X et Y positifs de Coordonnee",15, coordonnee.getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur avec X et Y positifs de Coordonnee",17, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonneesNegatives() {
		Coordonnees coordonnee = new Coordonnees(-5, -7);
		assertEquals("Test abscisse du constructeur avec X et Y negatifs de Coordonnee",-5, coordonnee.getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur avec X et Y negatifs de Coordonnee",-7, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonneesAbscisseNegative() {
		Coordonnees coordonnee = new Coordonnees(5, -7);
		assertEquals("Test abscisse du constructeur avec X positif et Y negatif de Coordonnee",5, coordonnee.getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur avec X positif et Y negatif de Coordonnee",-7, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonneesOrdonneeNegative() {
		Coordonnees coordonnee = new Coordonnees(-5, 7);
		assertEquals("Test abscisse du constructeur avec X negatif et Y positif de Coordonnee",-5, coordonnee.getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur avec X negatif et Y positif de Coordonnee",7, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testMutateurs() {
		Coordonnees coordonnee = new Coordonnees();
		coordonnee.setAbscisse(-5);
		coordonnee.setOrdonnee(7);
		assertEquals("Test setter/getter abscisse de la position de Coordonnee",-5, coordonnee.getAbscisse(), EPSILON);
		assertEquals("Test setter/getter ordonnee de la position de Coordonnee",7, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Coordonnees coordonnee = new Coordonnees(14.5, -9.378);
		Locale.setDefault(new Locale("fr"));
		assertEquals("Test toString FR de Coordonnee","(14,5 , -9,38)", coordonnee.toString());
	}

	@Test
	public void testToStringUK() {
		Coordonnees coordonnee = new Coordonnees(14.5, -9.378);
		Locale.setDefault(new Locale("en"));
		assertEquals("Test toString EN de Coordonnee","(14.5 , -9.38)", coordonnee.toString());
	}

	@Test
	public void testDeplacerVers() {
		Coordonnees coordonnee = new Coordonnees(1, 1);
		coordonnee.deplacerVers(14, -15);
		assertEquals("Test abscisse de deplacerVers de Coordonnee", 14, coordonnee.getAbscisse(), EPSILON);
		assertEquals("Test ordonnee de deplacerVers de Coordonnee",-15, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testDeplacerDe() {
		Coordonnees coordonnee = new Coordonnees(1, 1);
		coordonnee.deplacerDe(-8, 15);
		assertEquals("Test abscisse de deplacerDe de Coordonnee",-7, coordonnee.getAbscisse(), EPSILON);
		assertEquals("Test ordonnee de deplacerDe de Coordonnee",16, coordonnee.getOrdonnee(), EPSILON);
	}

}

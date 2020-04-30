package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

public class CoordonneesTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeurVide() {
		Coordonnees coordonnee = new Coordonnees();
		assertEquals(0, coordonnee.getAbscisse(), EPSILON);
		assertEquals(0, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeur() {
		Coordonnees coordonnee = new Coordonnees(15, 17);
		assertEquals(15, coordonnee.getAbscisse(), EPSILON);
		assertEquals(17, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonneesNegatives() {
		Coordonnees coordonnee = new Coordonnees(-5, -7);
		assertEquals(-5, coordonnee.getAbscisse(), EPSILON);
		assertEquals(-7, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonneesAbscisseNegative() {
		Coordonnees coordonnee = new Coordonnees(5, -7);
		assertEquals(5, coordonnee.getAbscisse(), EPSILON);
		assertEquals(-7, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonneesOrdonneeNegative() {
		Coordonnees coordonnee = new Coordonnees(-5, 7);
		assertEquals(-5, coordonnee.getAbscisse(), EPSILON);
		assertEquals(7, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testMutateurs() {
		Coordonnees coordonnee = new Coordonnees();
		coordonnee.setAbscisse(-5);
		coordonnee.setOrdonnee(7);
		assertEquals(-5, coordonnee.getAbscisse(), EPSILON);
		assertEquals(7, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Coordonnees coordonnee = new Coordonnees(14.5, -9.378);
		assertEquals("(14,5 , -9,38)", coordonnee.toString());
	}

	@Test
	public void testToStringUK() {
		Coordonnees coordonnee = new Coordonnees(14.5, -9.378);
		Locale.setDefault(new Locale("en"));
		assertEquals("(14.5 , -9.38)", coordonnee.toString());
	}

	@Test
	public void testDistanceVers() {
		Coordonnees coordonnee = new Coordonnees(1, 1);
		assertEquals(11.401, coordonnee.distanceVers(new Coordonnees(-8, 8)), EPSILON);
		assertEquals(4, coordonnee.distanceVers(new Coordonnees(5, 1)), EPSILON);
	}

	@Test
	public void testAngleVers() {
		Coordonnees coordonnee = new Coordonnees(1, 1);
		assertEquals(2.48, coordonnee.angleVers(new Coordonnees(-8, 8)), EPSILON);
	}

	@Test
	public void testDeplacerVers() {
		Coordonnees coordonnee = new Coordonnees(1, 1);
		coordonnee.deplacerVers(14, -15);
		assertEquals(14, coordonnee.getAbscisse(), EPSILON);
		assertEquals(-15, coordonnee.getOrdonnee(), EPSILON);
	}

	@Test
	public void testDeplacerDe() {
		Coordonnees coordonnee = new Coordonnees(1, 1);
		coordonnee.deplacerDe(-8, 15);
		assertEquals(-7, coordonnee.getAbscisse(), EPSILON);
		assertEquals(16, coordonnee.getOrdonnee(), EPSILON);
	}

}

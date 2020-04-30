package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeur() {
		Ligne l1 = new Ligne(new Coordonnees(10, 10), -5, 20);
		assertEquals(10, l1.getC1().getAbscisse(), EPSILON);
		assertEquals(10, l1.getC1().getOrdonnee(), EPSILON);
		assertEquals(-5, l1.getLargeur(), EPSILON);
		assertEquals(20, l1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurVide() {
		Ligne l1 = new Ligne();
		assertEquals(0, l1.getC1().getAbscisse(), EPSILON);
		assertEquals(0, l1.getC1().getOrdonnee(), EPSILON);
		assertEquals(10, l1.getLargeur(), EPSILON);
		assertEquals(15, l1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurOrdonneeAbscisse() {
		Ligne l1 = new Ligne(new Coordonnees(15, -10));
		assertEquals(15, l1.getC1().getAbscisse(), EPSILON);
		assertEquals(-10, l1.getC1().getOrdonnee(), EPSILON);
		assertEquals(10, l1.getLargeur(), EPSILON);
		assertEquals(15, l1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurLargeurHauteur() {
		Ligne l1 = new Ligne(14, 200);
		assertEquals(0, l1.getC1().getAbscisse(), EPSILON);
		assertEquals(0, l1.getC1().getOrdonnee(), EPSILON);
		assertEquals(14, l1.getLargeur(), EPSILON);
		assertEquals(200, l1.getHauteur(), EPSILON);
	}

	@Test
	public void testMutateurs() {
		Ligne l1 = new Ligne(new Coordonnees(15, -10));
		l1.setC1(new Coordonnees(-52, 12));
		assertEquals(-52, l1.getC1().getAbscisse(), EPSILON);
		assertEquals(12, l1.getC1().getOrdonnee(), EPSILON);
		l1.setC2(new Coordonnees(252, 98));
		assertEquals(252, l1.getC2().getAbscisse(), EPSILON);
		assertEquals(98, l1.getC2().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCadre1() {
		Ligne l1 = new Ligne();
		l1.setC1(new Coordonnees(280, 300));
		l1.setC2(new Coordonnees(50, 10));
		assertEquals(280, l1.getCadreMaxX(), EPSILON);
		assertEquals(50, l1.getCadreMinX(), EPSILON);
		assertEquals(300, l1.getCadreMaxY(), EPSILON);
		assertEquals(10, l1.getCadreMinY(), EPSILON);
	}

	@Test
	public void testCadre2() {
		Ligne l2 = new Ligne();
		l2.setC1(new Coordonnees(50, 10));
		l2.setC2(new Coordonnees(150, 200));
		assertEquals(150, l2.getCadreMaxX(), EPSILON);
		assertEquals(50, l2.getCadreMinX(), EPSILON);
		assertEquals(200, l2.getCadreMaxY(), EPSILON);
		assertEquals(10, l2.getCadreMinY(), EPSILON);
	}

	@Test
	public void testAire() {
		Ligne l1 = new Ligne(new Coordonnees(15, -10));
		assertEquals(0, l1.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		assertEquals(18.027, l1.perimetre(), EPSILON);
	}
	
	@Test
	public void testDeplacerDe() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		l1.deplacerDe(50, -10);
		assertEquals(135, l1.getC1().getAbscisse(), EPSILON);
		assertEquals(40, l1.getC1().getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testDeplacerVers() {
		Ligne l1 = new Ligne(new Coordonnees(10, 15));
		l1.deplacerVers(96, 110);
		assertEquals(96, l1.getC1().getAbscisse(), EPSILON);
		assertEquals(110, l1.getC1().getOrdonnee(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		Locale.setDefault(new Locale("fr"));
		assertEquals("[Ligne] c1 : (85,0 , 50,0) c2 : (95,0 , 65,0) longueur : 18,03 angle : 56,31°", l1.toString());
	}
	
	@Test
	public void testToStringUK() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		Locale.setDefault(new Locale("en"));
		assertEquals("[Ligne] c1 : (85.0 , 50.0) c2 : (95.0 , 65.0) longueur : 18.03 angle : 56.31°", l1.toString());
	}

	@Test
	public void testToStringAngleNegatif() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		Locale.setDefault(new Locale("fr"));
		l1.setC2(new Coordonnees(50, 10));
		assertEquals("[Ligne] c1 : (85,0 , 50,0) c2 : (50,0 , 10,0) longueur : 53,15 angle : 228,81°", l1.toString());
	}
	
	@Test
	public void testContient() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		assertEquals(true, l1.contient(new Coordonnees(84.8,49.8)));
	}
	
	@Test
	public void testContientPas() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		assertEquals(false, l1.contient(new Coordonnees(86,49)));
	}



}

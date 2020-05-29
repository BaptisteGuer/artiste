package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeur() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		assertEquals(20, e1.getLargeur(), EPSILON);
		assertEquals(10, e1.getHauteur(), EPSILON);
		assertEquals(-10, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals(10, e1.getPosition().getAbscisse(), EPSILON);
	}

	@Test
	public void testConstructeurVide() {
		Ellipse e1 = new Ellipse();
		assertEquals(0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals(Ellipse.LARGEUR_PAR_DEFAUT, e1.getLargeur(), EPSILON);
		assertEquals(Ellipse.HAUTEUR_PAR_DEFAUT, e1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurOrdonneeAbscisse() {
		Ellipse e1 = new Ellipse(new Coordonnees(-14, 63));
		assertEquals(-14, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(63, e1.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurLargeurHauteur() {
		Ellipse e1 = new Ellipse(52, 96);
		assertEquals(52, e1.getLargeur(), EPSILON);
		assertEquals(96, e1.getHauteur(), EPSILON);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurLargeurNegative() throws Exception {
		new Ellipse(-25, 15);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurHauteurNegative() throws Exception {
		new Ellipse(25, -15);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurCoordHauteurNegative() throws Exception {
		new Ellipse(new Coordonnees(-8, 12), 12, -5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurCoordLargeurNegative() throws Exception {
		new Ellipse(new Coordonnees(18, 20), -6, 5);
	}

	@Test
	public void testMutateurs() {
		Ellipse e1 = new Ellipse(52, 96);
		e1.setHauteur(85);
		e1.setLargeur(1);
		assertEquals(1, e1.getLargeur(), EPSILON);
		assertEquals(85, e1.getHauteur(), EPSILON);
		e1.setPosition(new Coordonnees(8, -12));
		assertEquals(8, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(-12, e1.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCadre1() {
		Ellipse e1 = new Ellipse();
		e1.setLargeur(10);
		assertEquals(10, e1.getCadreMaxX(), EPSILON);
		e1.setHauteur(20);
		assertEquals(20, e1.getCadreMaxY(), EPSILON);
	}

	@Test
	public void testAire() {
		Ellipse e1 = new Ellipse(new Coordonnees(15, 20));
		assertEquals(11780.972, e1.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Ellipse e1 = new Ellipse();
		e1.setHauteur(10);
		e1.setLargeur(7);
		assertEquals(26.911, e1.perimetre(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		Locale.setDefault(new Locale("fr"));
		assertEquals(
				"[Ellipse] : pos (10,0 , -10,0) dim 20,0 x 10,0 périmètre : 48,44 aire : 157,08 couleur = R51,V51,B51",
				e1.toString());
	}

	@Test
	public void testToStringUK() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		Locale.setDefault(new Locale("en"));
		assertEquals(
				"[Ellipse] : pos (10.0 , -10.0) dim 20.0 x 10.0 périmètre : 48.44 aire : 157.08 couleur = R51,G51,B51",
				e1.toString());
	}

	@Test
	public void testContient() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		assertEquals(true, e1.contient(new Coordonnees(15, -5)));
	}

	@Test
	public void testContientPas() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		assertEquals(false, e1.contient(new Coordonnees(32, -5)));
	}

	@Test
	public void testCouleur() {
		Ellipse e1 = new Ellipse();
		e1.setCouleur(Color.BLACK);
		assertEquals(Color.BLACK, e1.getCouleur());
	}

	@Test
	public void testRemplissage() {
		Ellipse e1 = new Ellipse(new Coordonnees(), 10, 15);
		e1.setRempli(true);
		Locale.setDefault(new Locale("fr"));
		assertEquals(
				"[Ellipse-Rempli] : pos (0,0 , 0,0) dim 10,0 x 15,0 périmètre : 39,66 aire : 117,81 couleur = R51,V51,B51",
				e1.toString());
		assertEquals(true, e1.estRempli());
	}

}

package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeurComplet() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		assertEquals("Test largeur du constructeur de Ellipse avec coordonnee, largeur et hauteur",20, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Ellipse avec coordonnee, largeur et hauteur",10, e1.getHauteur(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Ellipse avec coordonnee, largeur et hauteur",-10, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test abscisse du constructeur de Ellipse avec coordonnee, largeur et hauteur",10, e1.getPosition().getAbscisse(), EPSILON);
	}

	@Test
	public void testConstructeurVide() {
		Ellipse e1 = new Ellipse();
		assertEquals("Test abscisse du constructeur de Ellipse vide",0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Ellipse vide",0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Ellipse vide",Ellipse.LARGEUR_PAR_DEFAUT, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Ellipse vide",Ellipse.HAUTEUR_PAR_DEFAUT, e1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurOrdonneeAbscisse() {
		Ellipse e1 = new Ellipse(new Coordonnees(-14, 63));
		assertEquals("Test abscisse du constructeur de Ellipse avec coordonnee",-14, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Ellipse avec coordonnee",63, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Ellipse avec coordonnee",Ellipse.LARGEUR_PAR_DEFAUT, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Ellipse avec coordonnee",Ellipse.HAUTEUR_PAR_DEFAUT, e1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurLargeurHauteur() {
		Ellipse e1 = new Ellipse(52, 96);
		assertEquals("Test abscisse du constructeur de Ellipse avec largeur et hauteur",0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Ellipse avec largeur et hauteur",0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Ellipse avec largeur et hauteur",52, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Ellipse avec largeur et hauteur",96, e1.getHauteur(), EPSILON);
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
		assertEquals("Test largeur setter/getter de Ellipse",1, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur setter/getter de Ellipse",85, e1.getHauteur(), EPSILON);
		e1.setPosition(new Coordonnees(8, -12));
		assertEquals("Test abscisse setter/getter de Ellipse",8, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee setter/getter de Ellipse",-12, e1.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCadre() {
		Ellipse e1 = new Ellipse();
		e1.setLargeur(10);
		assertEquals("Test abscisse Max du cadre de Ellipse",10, e1.getCadreMaxX(), EPSILON);
		e1.setHauteur(20);
		assertEquals("Test ordonnee Max du cadre de Ellipse",20, e1.getCadreMaxY(), EPSILON);
	}

	@Test
	public void testAire() {
		Ellipse e1 = new Ellipse(new Coordonnees(15, 20));
		assertEquals("Test aire de Ellipse",11780.972, e1.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Ellipse e1 = new Ellipse();
		e1.setHauteur(10);
		e1.setLargeur(7);
		assertEquals("Test perimetre de Ellipse",26.911, e1.perimetre(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		Locale.setDefault(new Locale("fr"));
		assertEquals("Test toString FR de Ellipse",
				"[Ellipse] : pos (10,0 , -10,0) dim 20,0 x 10,0 périmètre : 48,44 aire : 157,08 couleur = R51,V51,B51",
				e1.toString());
	}

	@Test
	public void testToStringUK() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		Locale.setDefault(new Locale("en"));
		assertEquals("Test toString EN de Ellipse",
				"[Ellipse] : pos (10.0 , -10.0) dim 20.0 x 10.0 périmètre : 48.44 aire : 157.08 couleur = R51,G51,B51",
				e1.toString());
	}

	@Test
	public void testContient() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		assertEquals("Test contient avec coordonnee dedans de Ellipse", true, e1.contient(new Coordonnees(15, -5)));
	}

	@Test
	public void testContientPas() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, -10), 20, 10);
		assertEquals("Test contient avec coordonnee en dehors de Ellipse",false, e1.contient(new Coordonnees(32, -5)));
	}

	@Test
	public void testCouleur() {
		Ellipse e1 = new Ellipse();
		e1.setCouleur(Color.BLACK);
		assertEquals("Test setter/getter de couleur de Ellipse",Color.BLACK, e1.getCouleur());
	}

	@Test
	public void testRemplissage() {
		Ellipse e1 = new Ellipse(new Coordonnees(), 10, 15);
		e1.setRempli(true);
		Locale.setDefault(new Locale("fr"));
		assertEquals("Test toString FR avec remplissage de Ellipse",
				"[Ellipse-Rempli] : pos (0,0 , 0,0) dim 10,0 x 15,0 périmètre : 39,66 aire : 117,81 couleur = R51,V51,B51",
				e1.toString());
		assertEquals(true, e1.estRempli());
	}

}

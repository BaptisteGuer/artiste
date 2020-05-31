package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeurVide() {
		Ligne l1 = new Ligne();
		assertEquals("Test abscisse du constructeur de Ligne vide",0, l1.getC1().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Ligne vide",0, l1.getC1().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Ligne vide",Ligne.LARGEUR_PAR_DEFAUT, l1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Ligne vide",Ligne.HAUTEUR_PAR_DEFAUT, l1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurComplet() {
		Ligne l1 = new Ligne(new Coordonnees(15, -10), 10, 15);
		assertEquals("Test abscisse du constructeur de Ligne avec cordonnee, largeur et hauteur",15, l1.getC1().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Ligne avec  crdonnee, largeur et hauteur",-10, l1.getC1().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Ligne avec cordonnee, largeur et hauteur",10, l1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Ligne avec cordonnee, largeur et hauteur",15, l1.getHauteur(), EPSILON);
	}

	@Test
	public void testConstructeurLargeurHauteur() {
		Ligne l1 = new Ligne(14, 200);
		assertEquals("Test abscisse du constructeur de Ligne avec largeur et hauteur",0, l1.getC1().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee du constructeur de Ligne avec largeur et hauteur",0, l1.getC1().getOrdonnee(), EPSILON);
		assertEquals("Test largeur du constructeur de Ligne avec largeur et hauteur",14, l1.getLargeur(), EPSILON);
		assertEquals("Test hauteur du constructeur de Ligne avec largeur et hauteur",200, l1.getHauteur(), EPSILON);
	}

	@Test
	public void testMutateurs() {
		Ligne l1 = new Ligne(new Coordonnees(15, -10));
		l1.setC1(new Coordonnees(-52, 12));
		assertEquals("Test abscisse setter/getter de la 1ere coordonnee de Ligne",-52, l1.getC1().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee setter/getter de la 1ere coordonee de Ligne",12, l1.getC1().getOrdonnee(), EPSILON);
		l1.setC2(new Coordonnees(252, 98));
		assertEquals("Test abscisse setter/getter de la 2nde coordonnee de Ligne",252, l1.getC2().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee setter/getter de la 2nde coordonnee de Ligne",98, l1.getC2().getOrdonnee(), EPSILON);
	}

	@Test
	public void testCadre1() {
		Ligne l1 = new Ligne();
		l1.setC1(new Coordonnees(280, 300));
		l1.setC2(new Coordonnees(50, 10));
		assertEquals("Test point max X du cadre de Ligne",280, l1.getCadreMaxX(), EPSILON);
		assertEquals("Test point min X du cadre de Ligne",50, l1.getCadreMinX(), EPSILON);
		assertEquals("Test point max Y du cadre de Ligne",300, l1.getCadreMaxY(), EPSILON);
		assertEquals("Test point min Y du cadre de Ligne",10, l1.getCadreMinY(), EPSILON);
	}

	@Test
	public void testCadre2() {
		Ligne l2 = new Ligne();
		l2.setC1(new Coordonnees(50, -10));
		l2.setC2(new Coordonnees(-150, 200));
		assertEquals("Test point max X du cadre de Ligne avec coordonnee negative de Ligne",50, l2.getCadreMaxX(), EPSILON);
		assertEquals("Test point min X du cadre de Ligne avec coordonnee negative de Ligne",-150, l2.getCadreMinX(), EPSILON);
		assertEquals("Test point max Y du cadre de Ligne avec coordonnee negative de Ligne",200, l2.getCadreMaxY(), EPSILON);
		assertEquals("Test point min Y du cadre de Ligne avec coordonnee negative de Ligne",-10, l2.getCadreMinY(), EPSILON);
	}

	@Test
	public void testAire() {
		Ligne l1 = new Ligne(new Coordonnees(15, -10));
		assertEquals("Test aire de Ligne", 0, l1.aire(), EPSILON);
	}

	@Test
	public void testPerimetre() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50), 10, 15);
		assertEquals("Test perimetre de Ligne",18.027, l1.perimetre(), EPSILON);
	}

	@Test
	public void testDeplacerDe() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		l1.deplacerDe(50, -10);
		assertEquals("Test abscisse de deplacerDe de Ligne",135, l1.getC1().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee de deplacerDe de Ligne",40, l1.getC1().getOrdonnee(), EPSILON);
	}

	@Test
	public void testDeplacerVers() {
		Ligne l1 = new Ligne(new Coordonnees(10, 15));
		l1.deplacerVers(96, 110);
		assertEquals("Test abscisse de deplacerVers de Ligne",96, l1.getC1().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee de deplacerVers de Ligne",110, l1.getC1().getOrdonnee(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50), 10, 15);
		Locale.setDefault(new Locale("fr"));
		assertEquals("Test de toString en FR de Ligne", "[Ligne] c1 : (85,0 , 50,0) c2 : (95,0 , 65,0) longueur : 18,03 angle : 56,31° couleur = R51,V51,B51", l1.toString());
	}

	@Test
	public void testToStringUK() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50), 10, 15);
		Locale.setDefault(new Locale("en"));
		assertEquals("Test de toString en EN de Ligne","[Ligne] c1 : (85.0 , 50.0) c2 : (95.0 , 65.0) longueur : 18.03 angle : 56.31° couleur = R51,G51,B51", l1.toString());
	}

	@Test
	public void testToStringAngleNegatif() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		Locale.setDefault(new Locale("fr"));
		l1.setC2(new Coordonnees(50, 10));
		assertEquals("Test de toString de Ligne avec un angle negatif",
				"[Ligne] c1 : (85,0 , 50,0) c2 : (50,0 , 10,0) longueur : 53,15 angle : 228,81° couleur = R51,V51,B51",
				l1.toString());
	}

	@Test
	public void testContient() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		assertEquals("Test contient avec point dessus de Ligne",true, l1.contient(new Coordonnees(84.8, 49.8)));
	}

	@Test
	public void testContientPas() {
		Ligne l1 = new Ligne(new Coordonnees(85, 50));
		assertEquals("Test contient avec point en dehors de Ligne",false, l1.contient(new Coordonnees(86, 49)));
	}
	
	@Test
	public void testCouleur() {
		Ligne l1 = new Ligne();
		l1.setCouleur(Color.BLUE);
		assertEquals("Test setter/getter de couleur de Ligne",Color.BLUE, l1.getCouleur());
	}
}

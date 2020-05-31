package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EtoileTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeurTaille() {
		Etoile e1 = new Etoile(15);
		assertEquals("Test largeur de constructeur avec taille de Etoile",15, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur de constructeur avec taille de Etoile",15, e1.getHauteur(), EPSILON);
		assertEquals("Test nb branche de constructeur avec taille de Etoile",Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, e1.getNombreBranches());
		assertEquals("Test longueur branches de constructeur avec taille de Etoile",Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, e1.getLongueurBranche(), EPSILON);
		assertEquals("Test angle de constructeur avec taille de Etoile",Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, e1.getAnglePremiereBranche(), EPSILON);
		assertEquals("Test abscisse de constructeur avec taille de Etoile",0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee de constructeur avec taille de Etoile",0, e1.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurVide() {
		Etoile e1 = new Etoile();
		assertEquals("Test abcisse de constructeur vide de Etoile",0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee de constructeur vide de Etoile",0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test largeur de constructeur vide de Etoile",Etoile.LARGEUR_PAR_DEFAUT, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur de constructeur vide de Etoile",Etoile.LARGEUR_PAR_DEFAUT, e1.getHauteur(), EPSILON);
		assertEquals("Test nb branches de constructeur vide de Etoile",Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, e1.getNombreBranches());
		assertEquals("Test longueur branches de constructeur vide de Etoile",Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, e1.getLongueurBranche(), EPSILON);
		assertEquals("Test angle de constructeur vide de Etoile",Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, e1.getAnglePremiereBranche(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonnee() {
		Etoile e1 = new Etoile(new Coordonnees(-14, 63));
		assertEquals("Test abcisse de constructeur avec coordonnee de Etoile",-14, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee de constructeur avec coordonnee de Etoile",63, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test largeur de constructeur avec coordonnee de Etoile",Etoile.LARGEUR_PAR_DEFAUT, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur de constructeur avec coordonnee de Etoile",Etoile.LARGEUR_PAR_DEFAUT, e1.getHauteur(), EPSILON);
		assertEquals("Test nb branches de constructeur avec coordonnee de Etoile",Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, e1.getNombreBranches());
		assertEquals("Test longueur branches de constructeur avec coordonnee de Etoile",Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, e1.getLongueurBranche(), EPSILON);
		assertEquals("Test angle de constructeur avec coordonnee de Etoile",Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, e1.getAnglePremiereBranche(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonneeLargeur() {
		Etoile e1 = new Etoile(new Coordonnees(89, 15), 12);
		assertEquals("Test abcisse de constructeur avec coordonnee et taille de Etoile",12, e1.getLargeur(), EPSILON);
		assertEquals("Test ordonnee de constructeur avec coordonnee et taille de Etoile",12, e1.getHauteur(), EPSILON);
		assertEquals("Test largeur de constructeur avec coordonnee et taille de Etoile",89, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test hauteur de constructeur avec coordonnee et taille de Etoile",15, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test nb branches de constructeur avec coordonnee et taille de Etoile",Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, e1.getNombreBranches());
		assertEquals("Test longueur branches de constructeur avec coordonnee et taille de Etoile",Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, e1.getLongueurBranche(), EPSILON);
		assertEquals("Test angle de constructeur avec coordonnee et taille de Etoile",Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, e1.getAnglePremiereBranche(), EPSILON);
	}
	
	@Test
	public void testConstructeurComplet() {
		Etoile e1 = new Etoile(new Coordonnees(14, -47), 12, 8, 0, 0.7);
		assertEquals("Test abcisse de constructeur avec coordonnee, taille, nb branches, angle, longueur branches de Etoile",12, e1.getLargeur(), EPSILON);
		assertEquals("Test ordonnee de constructeur avec coordonnee, taille, nb branches, angle, longueur branches de Etoile",12, e1.getHauteur(), EPSILON);
		assertEquals("Test largeur de constructeur avec coordonnee, taille, nb branches, angle, longueur branches de Etoile",14, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test hauteur de constructeur avec coordonnee, taille, nb branches, angle, longueur branches de Etoile",-47, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test nb branches de constructeur avec coordonnee, taille, nb branches, angle, longueur branches de Etoile",8, e1.getNombreBranches());
		assertEquals("Test longueur branches de constructeur avec coordonnee, taille, nb branches, angle, longueur branches de Etoile",0.7, e1.getLongueurBranche(), EPSILON);
		assertEquals("Test angle de constructeur avec coordonnee, taille, nb branches, angle, longueur branches de Etoile",0, e1.getAnglePremiereBranche(), EPSILON);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurLargeurNegative() throws Exception {
		Etoile e1 = new Etoile();
		e1.setLargeur(-5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurHauteurNegative() throws Exception {
		Etoile e1 = new Etoile();
		e1.setHauteur(-6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurNbBranchesNegative() throws Exception {
		Etoile e1 = new Etoile();
		e1.setNombreBranches(-2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurNbBranchesHaut() throws Exception {
		Etoile e1 = new Etoile();
		e1.setNombreBranches(16);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurAngleHaut() throws Exception {
		Etoile e1 = new Etoile();
		e1.setAnglePremiereBranche(Math.PI*2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurAngleBas() throws Exception {
		Etoile e1 = new Etoile();
		e1.setAnglePremiereBranche(-Math.PI*2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurLongueurBrancheHaut() throws Exception {
		Etoile e1 = new Etoile();
		e1.setLongueurBranche(1.1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurLongueurBrancheBas() throws Exception {
		Etoile e1 = new Etoile();
		e1.setLongueurBranche(-0.1);
	}


	@Test
	public void testMutateurs() {
		Etoile e1 = new Etoile(52);
		e1.setLargeur(1);
		assertEquals("Test largeur setter/getter de Etoile",1, e1.getLargeur(), EPSILON);
		assertEquals("Test hauteur setter/getter de Etoile",1, e1.getHauteur(), EPSILON);
		e1.setPosition(new Coordonnees(8, -12));
		assertEquals("Test abscisse setter/getter de Etoile",8, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test ordonnee setter/getter de Etoile",-12, e1.getPosition().getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testMutateursCaractEtoile() {
		Etoile e1 = new Etoile();
		e1.setAnglePremiereBranche(-Math.PI);
		assertEquals("Test setter/getter de angle de Etoile",-Math.PI, e1.getAnglePremiereBranche(), EPSILON);
		e1.setLongueurBranche(0.8);
		assertEquals("Test setter/getter de longueur branches de Etoile",0.8, e1.getLongueurBranche(), EPSILON);
		e1.setNombreBranches(12);
		assertEquals("Test setter/getter de nb branches de Etoile",12, e1.getNombreBranches(), EPSILON);

	}

	@Test
	public void testAire() {
		Etoile e1 = new Etoile(new Coordonnees(), 10, 5, 0, 0.4 );
		assertEquals("Test aire de Etoile",44.083, e1.aire(), EPSILON);
	}
	
	@Test
	public void testCoordonnees() {
		Etoile e1 = new Etoile();
		List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();
		coordonnees.add(new Coordonnees(14.6, 12));
		coordonnees.add(new Coordonnees(4,8));
		e1.setCoordonnees(coordonnees);
		assertEquals("Test setter/getter liste de coordonnees de Etoile",coordonnees, e1.getCoordonnees());
	}

	@Test
	public void testPerimetre() {
		Etoile e1 = new Etoile();
		e1.setHauteur(10);
		e1.setLargeur(7);
		assertEquals("Test perimetre de Etoile",23.242, e1.perimetre(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Etoile e1 = new Etoile(new Coordonnees(10, -10), 20);
		Locale.setDefault(new Locale("fr"));
		assertEquals("Test toString FR de Etoile",
				"[Etoile] : pos (10,0 , -10,0) dim 20,0 x 20,0 périmètre : 66,41 aire : 146,95 couleur = R51,V51,B51",
				e1.toString());
	}

	@Test
	public void testToStringUK() {
		Etoile e1 = new Etoile(new Coordonnees(10, -10), 20);
		Locale.setDefault(new Locale("en"));
		assertEquals("Test toString EN de Etoile",
				"[Etoile] : pos (10.0 , -10.0) dim 20.0 x 20.0 périmètre : 66.41 aire : 146.95 couleur = R51,G51,B51",
				e1.toString());
	}

	
	@Test
	public void testContient1() {
		Etoile e1 = new Etoile(new Coordonnees(5, 9), 10);
		assertEquals("Test contient1 avec coordonnee interieur de Etoile",true, e1.contient(new Coordonnees(10, 14)));
	}
	
	@Test
	public void testContient2() {
		Etoile e1 = new Etoile(new Coordonnees(10, -10), 20);
		assertEquals("Test contient2 avec coordonnee interieur de Etoile",true, e1.contient(new Coordonnees(15, -5)));
	}

	@Test
	public void testContientPas() {
		Etoile e1 = new Etoile(new Coordonnees(10, -10), 20);
		assertEquals("Test contient3 avec coordonnee en dehors de Etoile",false, e1.contient(new Coordonnees(31, -5)));
	}
	
	@Test
	public void testContientPas2() {
		Etoile e1 = new Etoile(new Coordonnees(5, 9), 5);
		assertEquals("Test contient4 avec coordonnee en dehors de Etoile",false, e1.contient(new Coordonnees(5, 9)));
	}
	
	@Test
	public void testContientPas3() {
		Etoile e1 = new Etoile(new Coordonnees(20,30));
		assertEquals("Test contient5 avec coordonnee en dehors de Etoile",false, e1.contient(new Coordonnees(15, -5)));
	}
	

	@Test
	public void testCouleur() {
		Etoile e1 = new Etoile();
		e1.setCouleur(Color.BLACK);
		assertEquals("Test setter/getter de couleur de Etoile",Color.BLACK, e1.getCouleur());
	}

	@Test
	public void testRemplissage() {
		Etoile e1 = new Etoile(10);
		e1.setRempli(true);
		Locale.setDefault(new Locale("fr"));
		assertEquals("Test toString FR avec remplissage de Etoile",
				"[Etoile-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 33,2 aire : 36,74 couleur = R51,V51,B51",
				e1.toString());
		assertEquals(true, e1.estRempli());
		
	}

}

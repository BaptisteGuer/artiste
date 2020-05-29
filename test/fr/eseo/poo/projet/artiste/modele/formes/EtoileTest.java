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
		assertEquals(15, e1.getLargeur(), EPSILON);
		assertEquals(15, e1.getHauteur(), EPSILON);
		assertEquals(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, e1.getNombreBranches());
		assertEquals(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, e1.getLongueurBranche(), EPSILON);
		assertEquals(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, e1.getAnglePremiereBranche(), EPSILON);
		assertEquals(0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(0, e1.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testConstructeurVide() {
		Etoile e1 = new Etoile();
		assertEquals(0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals(Etoile.LARGEUR_PAR_DEFAUT, e1.getLargeur(), EPSILON);
		assertEquals(Etoile.LARGEUR_PAR_DEFAUT, e1.getHauteur(), EPSILON);
		assertEquals(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, e1.getNombreBranches());
		assertEquals(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, e1.getLongueurBranche(), EPSILON);
		assertEquals(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, e1.getAnglePremiereBranche(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonnee() {
		Etoile e1 = new Etoile(new Coordonnees(-14, 63));
		assertEquals(-14, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(63, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals(Etoile.LARGEUR_PAR_DEFAUT, e1.getLargeur(), EPSILON);
		assertEquals(Etoile.LARGEUR_PAR_DEFAUT, e1.getHauteur(), EPSILON);
		assertEquals(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, e1.getNombreBranches());
		assertEquals(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, e1.getLongueurBranche(), EPSILON);
		assertEquals(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, e1.getAnglePremiereBranche(), EPSILON);
	}

	@Test
	public void testConstructeurCoordonneeLargeur() {
		Etoile e1 = new Etoile(new Coordonnees(89, 15), 12);
		assertEquals(12, e1.getLargeur(), EPSILON);
		assertEquals(12, e1.getHauteur(), EPSILON);
		assertEquals(89, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(15, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, e1.getNombreBranches());
		assertEquals(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, e1.getLongueurBranche(), EPSILON);
		assertEquals(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, e1.getAnglePremiereBranche(), EPSILON);
	}
	
	@Test
	public void testConstructeurComplet() {
		Etoile e1 = new Etoile(new Coordonnees(14, -47), 12, 8, 0, 0.7);
		assertEquals(12, e1.getLargeur(), EPSILON);
		assertEquals(12, e1.getHauteur(), EPSILON);
		assertEquals(14, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(-47, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals(8, e1.getNombreBranches());
		assertEquals(0.7, e1.getLongueurBranche(), EPSILON);
		assertEquals(0, e1.getAnglePremiereBranche(), EPSILON);
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
		assertEquals(1, e1.getLargeur(), EPSILON);
		assertEquals(1, e1.getHauteur(), EPSILON);
		e1.setPosition(new Coordonnees(8, -12));
		assertEquals(8, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals(-12, e1.getPosition().getOrdonnee(), EPSILON);
	}

	@Test
	public void testAire() {
		Etoile e1 = new Etoile(new Coordonnees(), 10, 5, 0, 0.4 );
		assertEquals(44.083, e1.aire(), EPSILON);
	}
	
	@Test
	public void testCoordonnees() {
		Etoile e1 = new Etoile();
		List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();
		coordonnees.add(new Coordonnees(14.6, 12));
		coordonnees.add(new Coordonnees(4,8));
		e1.setCoordonnees(coordonnees);
		assertEquals(coordonnees, e1.getCoordonnees());
	}

	@Test
	public void testPerimetre() {
		Etoile e1 = new Etoile();
		e1.setHauteur(10);
		e1.setLargeur(7);
		assertEquals(23.242, e1.perimetre(), EPSILON);
	}

	@Test
	public void testToStringFR() {
		Etoile e1 = new Etoile(new Coordonnees(10, -10), 20);
		Locale.setDefault(new Locale("fr"));
		assertEquals(
				"[Etoile] : pos (10,0 , -10,0) dim 20,0 x 20,0 périmètre : 66,41 aire : 146,95 couleur = R51,V51,B51",
				e1.toString());
	}

	@Test
	public void testToStringUK() {
		Etoile e1 = new Etoile(new Coordonnees(10, -10), 20);
		Locale.setDefault(new Locale("en"));
		assertEquals(
				"[Etoile] : pos (10.0 , -10.0) dim 20.0 x 20.0 périmètre : 66.41 aire : 146.95 couleur = R51,G51,B51",
				e1.toString());
	}

	
	@Test
	public void testContient1() {
		Etoile e1 = new Etoile(new Coordonnees(5, 9), 10);
		assertEquals(true, e1.contient(new Coordonnees(10, 14)));
	}
	
	@Test
	public void testContient2() {
		Etoile e1 = new Etoile(new Coordonnees(10, -10), 20);
		assertEquals(true, e1.contient(new Coordonnees(15, -5)));
	}

	@Test
	public void testContientPas() {
		Etoile e1 = new Etoile(new Coordonnees(10, -10), 20);
		assertEquals(false, e1.contient(new Coordonnees(31, -5)));
	}
	
	@Test
	public void testContientPas2() {
		Etoile e1 = new Etoile(new Coordonnees(5, 9), 5);
		assertEquals(false, e1.contient(new Coordonnees(5, 9)));
	}
	
	@Test
	public void testContientPas3() {
		Etoile e1 = new Etoile(new Coordonnees(20,30));
		assertEquals(false, e1.contient(new Coordonnees(15, -5)));
	}
	

	@Test
	public void testCouleur() {
		Etoile e1 = new Etoile();
		e1.setCouleur(Color.BLACK);
		assertEquals(Color.BLACK, e1.getCouleur());
	}

	@Test
	public void testRemplissage() {
		Etoile e1 = new Etoile(10);
		e1.setRempli(true);
		Locale.setDefault(new Locale("fr"));
		assertEquals(
				"[Etoile-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 33,2 aire : 36,74 couleur = R51,V51,B51",
				e1.toString());
		assertEquals(true, e1.estRempli());
		
	}

}

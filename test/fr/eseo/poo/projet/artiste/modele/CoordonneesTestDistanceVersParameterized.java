package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CoordonneesTestDistanceVersParameterized {

	private double abscisse;
	private double ordonnee;
	private static final double EPSILON = 1e-3d;

	private Coordonnees coo;

	private double distanceAttendue;

	public CoordonneesTestDistanceVersParameterized(double x, double y, double distanceAttendue) {
		this.abscisse = x;
		this.ordonnee = y;
		this.distanceAttendue = distanceAttendue;
	}

	@Parameters(name = "dt[{index}] : {0}, {1}, {2}")
	public static Collection<Object[]> dt() {
		Object[][] data = new Object[][] { { 1, 1, 0 }, { 2, 2, 1.414 }, { -8, 8, 11.401 }, { 2, 9, 8.062 },
				{ 8, -6, 9.899 }, { 5, 1, 4 }, { -5, 1, 6 }, { 0, 1, 1 }, { 123.45, -122.5, 173.914 },
				{ -80999, 9, 81000 }

		};
		return Arrays.asList(data);
	}

	@Before
	public void setUp() {
		coo = new Coordonnees(abscisse, ordonnee);
	}

	@Test
	public void testDistanceVers() {
		assertEquals("Test de la distance entre deux coordonnees", distanceAttendue,
				coo.distanceVers(new Coordonnees(1, 1)), EPSILON);
	}

}

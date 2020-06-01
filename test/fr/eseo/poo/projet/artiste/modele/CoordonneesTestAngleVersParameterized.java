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
public class CoordonneesTestAngleVersParameterized {

	private double x;
	private double y;
	private static final double EPSILON = 1e-3d;

	private Coordonnees coo;

	private double angleAttendu;

	public CoordonneesTestAngleVersParameterized(double x, double y, double angleAttendu) {
		this.x = x;
		this.y = y;
		this.angleAttendu = angleAttendu;
	}

	@Parameters(name = "dt[{index}] : {0}, {1}, {2}")
	public static Collection<Object[]> dt() {
		Object[][] data = new Object[][] { { 0, 0, -2.356 }, { 0, 2, 2.356 }, { 2, 2, 0.785 }, { 2, 0, -0.785 },
				{ 1, 2.4, 1.570 }, { -0.4, 1, 3.141 }, { 2.4, 1, 0 }, { 1, -0.4, -1.570 }, { 0.5, 2.3, 1.938 },
				{ -0.3, 1.5, 2.774 } };
		return Arrays.asList(data);
	}

	@Before
	public void setUp() {
		coo = new Coordonnees(x, y);
	}

	@Test
	public void testAngleVers() {
		assertEquals("Test de l'angle entre deux coordonnees", angleAttendu, new Coordonnees(1, 1).angleVers(coo),
				EPSILON);
	}

}

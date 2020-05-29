package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EtoileTest {

	public static void main(String[] args) {
		Etoile e1 = new Etoile();
		int i = 0;
		for (Coordonnees c : e1.getCoordonnees()) {
			i += 1;
			System.out.println("Cercle cercle" + i + " = new Cercle(new Coordonnees(" + c.getAbscisse() + ","
					+ c.getOrdonnee() + "), 2);");
		}
	}

}

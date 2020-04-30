package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {
	
	
	public Cercle() {
		super(new Coordonnees(), LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT );
    }

    public Cercle(Coordonnees position, double hauteur) {
        super(position,hauteur,hauteur);
    }
    
    public Cercle(double hauteur) {
    	super(hauteur,hauteur);
    }

    public Cercle(Coordonnees position) {
    	super(position, LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
    }
    
    @Override
    public void setHauteur(double hauteur) {
    	super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}
    
    @Override
    public void setLargeur(double largeur) {
    	super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
    
    @Override
    public double perimetre() {
    	return 2*Math.PI*(getLargeur()/2);
	}

}

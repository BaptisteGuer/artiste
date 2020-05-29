package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class PanneauBarreOutils extends JPanel {

	private PanneauDessin panneauDessin;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JSpinner longBranches;
	private JSpinner nbBranches;

	public static final String BRANCHE_SPINNER_NOM = "Nombre de branches";
	public static final String LONGUEUR_SPINNER_NOM = "Longueur des branches";

	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.panneauDessin = panneauDessin;
		initComponents();
	}

	public void initComponents() {
		JButton effacer = new JButton(new ActionEffacer(this.panneauDessin));
		effacer.setName(ActionEffacer.NOM_ACTION);
		this.add(ActionEffacer.NOM_ACTION, effacer);
		JToggleButton outilLigne = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
		outilLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		JToggleButton outilEllipse = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		outilEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		JToggleButton outilCercle = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
		outilCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		JToggleButton outilEtoile = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ETOILE));
		outilEtoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
		buttonGroup.add(outilLigne);
		this.add(outilLigne);
		buttonGroup.add(outilEllipse);
		this.add(outilEllipse);
		buttonGroup.add(outilCercle);
		this.add(outilCercle);
		buttonGroup.add(outilEtoile);
		this.add(outilEtoile);
		JToggleButton selectionner = new JToggleButton(new ActionSelectionner(this.panneauDessin));
		selectionner.setName(ActionSelectionner.NOM_ACTION);
		buttonGroup.add(selectionner);
		this.add(selectionner);
		JButton couleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
		couleur.setName(ActionChoisirCouleur.NOM_ACTION);
		this.add(ActionChoisirCouleur.NOM_ACTION, couleur);
		JCheckBox remplissage = new JCheckBox(new ActionChoisirRemplissage(this.panneauDessin));
		remplissage.setName(ActionChoisirRemplissage.NOM_ACTION);
		this.add(ActionChoisirRemplissage.NOM_ACTION, remplissage);
		JLabel labelBranches = new JLabel(BRANCHE_SPINNER_NOM);
		this.add(BRANCHE_SPINNER_NOM, labelBranches);
		nbBranches = new JSpinner(new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1));
		nbBranches.setName(BRANCHE_SPINNER_NOM);
		this.add(BRANCHE_SPINNER_NOM, nbBranches);
		JLabel labelLongBranches = new JLabel(LONGUEUR_SPINNER_NOM);
		this.add(LONGUEUR_SPINNER_NOM, labelLongBranches);
		longBranches = new JSpinner(new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0.00, 1.00, 0.01));
		longBranches.setName(LONGUEUR_SPINNER_NOM);
		this.add(LONGUEUR_SPINNER_NOM, longBranches);
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}

	public int getNbBranches() {
		return (int) nbBranches.getValue();
	}

	public double getLongueurBranche() {
		return (double) longBranches.getValue();
	}
}

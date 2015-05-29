package algorithmes.genetique;

import java.util.ArrayList;

import model.DonneeAlgo;
import model.Model;
import clavier.Clavier;
import algorithmes.IAlgo;

public class Genetique implements IAlgo {

	protected ArrayList<Clavier> listeClaviers;
	protected Model model;
	
	public Genetique(Model model) {
		this.model = model;
		listeClaviers = new ArrayList<Clavier>();
	}

	@Override
	public DonneeAlgo getMeilleurClavier() {
		initialisation();
		do {
			evaluation();
			selection();
			croisement();
			mutation();
		} while (arret());
		return null;
	}

	public void initialisation() {
		
	}
	
	public void evaluation() {
		
	}
	
	public void selection() {
		
	}
	
	public void croisement() {
		
	}
	
	public void mutation() {
		
	}
	
	public boolean arret() {
		return true;
	}
}

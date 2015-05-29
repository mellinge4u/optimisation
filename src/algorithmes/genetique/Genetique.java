package algorithmes.genetique;

import model.DonneeAlgo;
import clavier.Clavier;
import algorithmes.IAlgo;

public class Genetique implements IAlgo {

	public Genetique() {
		// TODO Auto-generated constructor stub
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

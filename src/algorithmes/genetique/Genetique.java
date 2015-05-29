package algorithmes.genetique;

import java.util.ArrayList;
import java.util.Random;

import model.DonneeAlgo;
import model.Model;
import clavier.Clavier;
import algorithmes.IAlgo;

public class Genetique implements IAlgo {

	protected Model model;
	protected ArrayList<Clavier> listeClaviers;
	protected int population;
	protected int percentMutation;
	protected int percentCroissement;
	protected int iteration;

	public Genetique(Model model) {
		this.model = model;
	}

	@Override
	public DonneeAlgo getMeilleurClavier() {
		DonneeAlgo donnee;
		Clavier best;
		initialisation();
		do {
			iteration++;
			evaluation(); // ici, elle est faite dans la séléction
			selection();
			croisement(); // On n'en fait pas pour le moment
			mutation();
		} while (arret());
		best = getMeilleur();
		donnee = new DonneeAlgo(best, iteration);
		return donnee;
	}

	public void initialisation() {
		iteration = 0;
		population = model.getPopulation();
		percentMutation = model.getMutation();
		percentCroissement = 0;
		listeClaviers = new ArrayList<Clavier>();
		for (int i = 0; i < model.getPopulation(); i++) {
			listeClaviers.add(new Clavier());
		}
	}

	public void evaluation() {

	}

	public void selection() {
		ArrayList<Clavier> selection = new ArrayList<Clavier>();
		Random r = new Random();
		Clavier best, tmp;
		int selec, eval, newEval;
		for (int i = 0; i < population; i++) {
			best = null;
			tmp = null;
			eval = Integer.MAX_VALUE;
			for (int j = 0; j < population / 2; j++) {
				selec = r.nextInt(population);
				tmp = listeClaviers.get(selec);
				newEval = tmp.evaluation();
				if (newEval < eval) {
					eval = newEval;
					best = tmp;
				}
			}
			selection.add(best);
		}
		listeClaviers = selection;
	}

	public void croisement() {

	}

	public Clavier getMeilleur() {
		Clavier best = null;
		int newEval;
		int eval = Integer.MAX_VALUE;
		for (Clavier c : listeClaviers) {
			newEval = c.evaluation();
			if (newEval < eval) {
				eval = newEval;
				best = c;
			}
		}
		return best;
	}

	public void mutation() {
		Clavier c;
		for (int i = 0; i < (percentMutation * population / 100); i++) {
			c = listeClaviers.get(i);
			listeClaviers.set(i, c.mutation());
		}
	}

	public boolean arret() {
		return (iteration < 1000);
	}
}

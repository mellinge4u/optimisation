package model;

import java.util.Observable;

import algorithmes.genetique.Genetique;
import algorithmes.recuitSimule.RecuitSimule;
import clavier.Clavier;

public class Model extends Observable {

	public enum algo {
		genetique, recuit
	};

	private double temperature;
	private int mutation;
	private int population;
	private int iteration;
	private int fctionObj;
	private boolean tmpCorrect;
	private boolean popCorrect;
	private boolean mutaCorrect;
	private DonneeAlgo donneeGenetique;
	private DonneeAlgo donneeRecuit;
	private Genetique genet;
	private RecuitSimule recuit;

	public Model() {
		temperature = 0;
		mutation = 0;
		population = 0;
		// TODO instancier algo
		tmpCorrect = true;
		popCorrect = true;
		mutaCorrect = true;
		donneeGenetique = new DonneeAlgo(new Clavier("azerty"), 0);
		donneeRecuit = new DonneeAlgo(new Clavier("bepo"), 0);
		genet = new Genetique(this);
		recuit = new RecuitSimule(this);
	}

	public int getFctionObj() {
		return fctionObj;
	}

	public int getIteration() {
		return iteration;
	}

	public Clavier getClavierGenetique() {
		return donneeGenetique.getClavier();
	}

	public Clavier getClavierRecuit() {
		return donneeRecuit.getClavier();
	}

	public int getIterationGenetique() {
		return donneeGenetique.getIteration();
	}

	public int getIterationRecuit() {
		return donneeRecuit.getIteration();
	}

	public int getMutation() {
		return mutation;
	}

	public int getPopulation() {
		return population;
	}

	public double getTemperature() {
		return temperature;
	}

	public boolean isMutaCorrect() {
		return mutaCorrect;
	}

	public boolean isPopCorrect() {
		return popCorrect;
	}

	public boolean isTmpCorrect() {
		return tmpCorrect;
	}

	public void setFctionObj(int fctionObj) {
		this.fctionObj = fctionObj;
		update();
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
		update();
	}

	public void setClavierGenetique(Clavier clavier) {
		this.donneeGenetique.setClavier(clavier);
		update();
	}

	public void setClavierRecuit(Clavier clavier) {
		this.donneeRecuit.setClavier(clavier);
		update();
	}

	public void setIterationGenetique(int iteration) {
		this.donneeGenetique.setIteration(iteration);
		update();
	}

	public void setIterationRecuit(int iteration) {
		this.donneeRecuit.setIteration(iteration);
		update();
	}

	public void incIterationGenetique(int iteration) {
		this.donneeGenetique.incIteration();
		update();
	}

	public void incIterationRecuit(int iteration) {
		this.donneeRecuit.incIteration();
		update();
	}

	public void setMutaCorrect(boolean mutaCorrect) {
		this.mutaCorrect = mutaCorrect;
		update();
	}

	public void setMutation(int mutation) {
		this.mutation = mutation;
		update();
	}

	public void setPopCorrect(boolean popCorrect) {
		this.popCorrect = popCorrect;
		update();
	}

	public void setPopulation(int population) {
		this.population = population;
		update();
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		update();
	}

	public void setTmpCorrect(boolean tmpCorrect) {
		this.tmpCorrect = tmpCorrect;
		update();
	}

	public void demarrerAlgo(algo a) {
		switch (a) {
		case genetique:
			donneeGenetique = genet.getMeilleurClavier();
			break;
		case recuit:
			donneeRecuit = recuit.getMeilleurClavier();
			break;
		default:
			break;
		}
		update();
	}

	public void update() {
		setChanged();
		notifyObservers();
	}

}

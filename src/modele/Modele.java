package modele;

import java.util.Observable;

import algorithmes.IAlgo;

public class Modele extends Observable {

	private int temperature;
	private int mutation;
	private int population;
	private int iteration;
	private int fctionObj;
	private IAlgo algo;

	public Modele() {
		temperature = 0;
		mutation = 0;
		population = 0;
		// TODO instancier algo
	}

	public void update() {
		setChanged();
		notifyObservers();
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		update();
	}

	public int getMutation() {
		return mutation;
	}

	public void setMutation(int mutation) {
		this.mutation = mutation;
		update();
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
		update();
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
		update();
	}

	public int getFctionObj() {
		return fctionObj;
	}

	public void setFctionObj(int fctionObj) {
		this.fctionObj = fctionObj;
		update();
	}

}

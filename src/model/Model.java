package model;

import java.util.Observable;

import clavier.Clavier;

public class Model extends Observable {

	private int temperature;
	private int mutation;
	private int population;
	private int iteration;
	private int fctionObj;
	private boolean tmpCorrect;
	private boolean popCorrect;
	private boolean mutaCorrect;
	private Clavier keyboard;	// TODO Changer le nom, il n'est pas top.	PS : Pareil pour les geter et seter de c't'objet

	public Model() {
		temperature = 0;
		mutation = 0;
		population = 0;
		// TODO instancier algo
		tmpCorrect = true;
		popCorrect = true;
		mutaCorrect = true;
		keyboard = new Clavier("bepoj");
	}

	public int getFctionObj() {
		return fctionObj;
	}

	public int getIteration() {
		return iteration;
	}

	public Clavier getKeyboard() {
		return keyboard;
	}

	public int getMutation() {
		return mutation;
	}

	public int getPopulation() {
		return population;
	}

	public int getTemperature() {
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

	public void setKeyboard(Clavier keyboard) {
		this.keyboard = keyboard;
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

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		update();
	}

	public void setTmpCorrect(boolean tmpCorrect) {
		this.tmpCorrect = tmpCorrect;
		update();
	}

	public void update() {
		setChanged();
		notifyObservers();
	}

}

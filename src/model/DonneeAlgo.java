package model;

import clavier.Clavier;

public class DonneeAlgo {

	protected Clavier clavier;
	protected int iteration;
	
	public DonneeAlgo(Clavier clavier, int iteration) {
		this.clavier = clavier;
		this.iteration = iteration;
	}

	public Clavier getClavier() {
		return clavier;
	}

	public void setClavier(Clavier clavier) {
		this.clavier = clavier;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public void incIteration() {
		this.iteration++;
	}
}

package algorithmes.recuitSimule;

import java.util.Random;

import model.DonneeAlgo;
import model.Model;
import clavier.Clavier;
import algorithmes.IAlgo;

public class RecuitSimule implements IAlgo {

	protected Model model;
	protected Clavier clavierCourant;
	protected int evalCourrant;
	protected Clavier clavierModif;
	protected Clavier meilleurClavier;
	protected int evalMeil;
	protected int iteration;
	protected double temperature;
	protected int limite;

	public RecuitSimule(Model model) {
		this.model = model;
		this.clavierCourant = null;
		evalCourrant = Integer.MAX_VALUE;
		this.clavierModif = model.getClavierRecuit();
		this.meilleurClavier = clavierModif;
		iteration = 0;
		limite = 1000;
	}

	@Override
	public DonneeAlgo getMeilleurClavier() {
		initialisation();
		do {
			modification();
			evaluation();
			diminuerTmp();
			iteration++;
		} while (arret());
		DonneeAlgo da = new DonneeAlgo(meilleurClavier, iteration);
		return da;
	}

	/*
	 * initialisation de différents paramètres
	 */
	public void initialisation() {
		this.clavierCourant = new Clavier();
		this.clavierModif = clavierCourant;
		this.meilleurClavier = clavierCourant;
		temperature = model.getTemperature();
		evalCourrant = clavierCourant.evaluation();
		evalMeil = evalCourrant;
		iteration = 0;
	}

	/*
	 * 
	 */
	public void evaluation() {
		int evalModif = clavierModif.evaluation();
		if(evalCourrant < evalModif){
			Random r = new Random();
			int i = r.nextInt((int) temperature);
			if(i > limite){
				clavierCourant = clavierModif;
				evalCourrant = evalModif;
			}
		} else {
			clavierCourant = clavierModif;
			if (evalModif < evalMeil) {
				meilleurClavier = clavierModif;
				evalMeil = evalModif;
			}
		}
	}

	/*
	 * applique une modification sur le clavier
	 */
	public void modification() {
		clavierModif = clavierCourant.mutation();
	}

	public boolean arret() {
		return temperature > limite;
	}

	public void diminuerTmp() {
		temperature *= 0.999;
	}

}

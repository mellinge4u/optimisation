package algorithmes.recuitSimule;

import java.util.Random;

import model.DonneeAlgo;
import model.Model;
import clavier.Clavier;
import algorithmes.IAlgo;

public class RecuitSimule implements IAlgo {

	protected Model model;
	protected Clavier clavierPrec;
	protected int evalClavPrec;
	protected Clavier clavierCourant;
	protected Clavier meilleurClavier;
	protected int evalMeilClav;
	protected int iteration;
	protected double temperature;

	public RecuitSimule(Model model) {
		this.model = model;
		this.clavierPrec = null;
		evalClavPrec = Integer.MAX_VALUE;
		this.clavierCourant = model.getClavierRecuit();
		this.meilleurClavier = clavierCourant;
		iteration = 0;
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
		this.clavierPrec = null;
		this.clavierCourant = model.getClavierRecuit();
		this.meilleurClavier = clavierCourant;
		temperature = model.getTemperature();
		System.out.println(temperature);
		evalMeilClav = meilleurClavier.evaluation();
		iteration = 0;
		evalClavPrec = Integer.MAX_VALUE;
	}

	/*
	 * 
	 */
	public void evaluation() {
		int evalClavCour;
		if (clavierPrec != null) {
			evalClavPrec = clavierPrec.evaluation();
		}
		evalClavCour = clavierCourant.evaluation();
		if(evalClavPrec < evalClavCour){
			Random r = new Random();
			int i = r.nextInt((int) temperature);
			if(i > 1000){
				clavierPrec = clavierCourant;
				if (evalClavCour > evalMeilClav) {
					meilleurClavier = clavierCourant;
					evalMeilClav = evalClavCour;
				}
			}
		} else {
			clavierPrec = clavierCourant;
			if (evalClavCour > evalMeilClav) {
				meilleurClavier = clavierCourant;
				evalMeilClav = evalClavCour;
			}
		}
	}

	/*
	 * applique une modification sur le clavier
	 */
	public void modification() {
		clavierCourant = clavierCourant.mutation();
	}

	public boolean arret() {
		return temperature > 1000;
	}

	public void diminuerTmp() {
		temperature *= 0.999;
	}

}

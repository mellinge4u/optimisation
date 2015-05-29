package algorithmes.recuitSimule;

import java.util.Random;

import model.DonneeAlgo;
import model.Model;
import clavier.Clavier;
import algorithmes.IAlgo;

public class RecuitSimule implements IAlgo {

	protected Model model;
	protected int cptECst; // s'incr�mente quand "l'�nergie du systeme reste
							// constante sur plusieurs it�rations
	protected Clavier clavierPrec;
	protected int evalClavPrec;
	protected Clavier clavierCourant;
	protected Clavier meilleurClavier;

	public RecuitSimule(Model model) {
		this.model = model;
		this.clavierPrec = null;
		evalClavPrec = Integer.MAX_VALUE;
		cptECst = 0;
		this.clavierCourant = model.getClavierRecuit();
		this.meilleurClavier = clavierCourant;
	}

	@Override
	public DonneeAlgo getMeilleurClavier() {
		initialisation();
		do {
			modification();
			evaluation();
			if (clavierCourant == clavierPrec) {
				cptECst++;
			}
			if (cptECst == 10) {
				// si on arrive sur un �tat d'�quilibre thermodynamique apr�s 10
				// it�rations , on diminue la temp�rature
				diminuerTmp();
				cptECst = 0;
			}
		} while (arret());
		return null;
	}

	/*
	 * initialisation de diff�rents param�tres
	 */
	public void initialisation() {
		this.clavierPrec = null;
		this.clavierCourant = model.getClavierRecuit();
		this.meilleurClavier = clavierCourant;
		cptECst = 0;
		evalClavPrec = Integer.MAX_VALUE;
	}

	/*
	 * 
	 */
	public void evaluation() {
		if (clavierPrec != null) {
			evalClavPrec = clavierPrec.evaluation();
		}
		if(evalClavPrec < clavierCourant.evaluation()){
			meilleurClavier = clavierPrec;
			Random r = new Random();
			int i = r.nextInt((int) model.getTemperature());
			if(i > 1000){
				clavierPrec = clavierCourant;
			}
		} else {
			clavierPrec = clavierCourant;
		}
	}

	/*
	 * applique une modification sur le clavier
	 */
	public void modification() {
		clavierPrec = clavierCourant;
		clavierCourant = clavierCourant.mutation();
	}

	public boolean arret() {
		return model.getTemperature() < 1000;
	}

	public void diminuerTmp() {
		Double d = model.getTemperature() * 0.99;
		model.setTemperature(d);
	}

}

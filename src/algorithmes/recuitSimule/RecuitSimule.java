package algorithmes.recuitSimule;

import model.DonneeAlgo;
import model.Model;
import clavier.Clavier;
import algorithmes.IAlgo;

public class RecuitSimule implements IAlgo {

	protected Model model;
	protected Clavier clavierPrec;
	protected int cptECst; // s'incr�mente quand "l'�nergie du systeme reste
							// constante sur plusieurs it�rations
	protected Clavier clavierCourant;
	protected Clavier meilleurClavier;

	public RecuitSimule(Model model) {
		this.model = model;
		this.clavierPrec = null;
		cptECst = 0;
		this.clavierCourant = model.getClavierRecuit();
		this.meilleurClavier = clavierCourant;
	}

	@Override
	public DonneeAlgo getMeilleurClavier() {
		initialisation();
		do {
			evaluation();
			modification();
			if (clavierCourant == clavierPrec) {
				cptECst++;
			}
			if (cptECst == 10) {
				// si on arrive sur un �tat d'�quilibre thermodynamique apr�s 10
				// it�rations , on diminue la temp�rature 
				diminuerTmp();
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
	}

	/*
	 * 
	 */
	public void evaluation() {

	}

	/*
	 * applique une modification sur le clavier
	 */
	public void modification() {

	}

	public boolean arret() {
		return true;
	}
	
	public void diminuerTmp(){
		Double d = model.getTemperature() * 0.99;
		model.setTemperature(d);
	}

}

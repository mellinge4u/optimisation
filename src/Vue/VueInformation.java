package Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Model;

public class VueInformation extends JPanel implements Observer{
	
	private JLabel ite;
	private JLabel fonctionObj;
	private Model mod;
	private Model.algo algo;
	
	public VueInformation(Model mod, Model.algo algo) {
		super();
		this.mod = mod;
		this.mod.addObserver(this);
		this.algo = algo;
		this.ite = new JLabel("nombre d'itérations : "); 
		this.fonctionObj = new JLabel("valeur de la fonction Objectif : ");
		this.add(ite);
		this.add(fonctionObj);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		switch (algo) {
		case genetique:
			ite.setText("nombre d'itérations : " + mod.getIterationGenetique());
			fonctionObj.setText("valeur de la fonction Objectif : " + mod.getClavierGenetique().evaluation());
			break;
		case recuit:
			ite.setText("nombre d'itérations : " + mod.getIterationRecuit());
			fonctionObj.setText("valeur de la fonction Objectif : " + mod.getClavierRecuit().evaluation());
			break;
		}
	}
	
}

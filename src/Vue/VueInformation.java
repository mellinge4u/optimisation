package Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Model;

public class VueInformation extends JPanel implements Observer{
	
	private JLabel ite;
	private JLabel fonctionObj;
	private Model mod;
	
	//TODO ne pas oublier le model
	public VueInformation(Model mod) {
		super();
		this.mod = mod;
		this.ite = new JLabel("nombre d'it�rations: "); 
		this.fonctionObj = new JLabel("valeur de la fonction Objectif: ");
		this.add(ite);
		this.add(fonctionObj);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}

package Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Modele;

public class VueInformation extends JPanel implements Observer{
	
	private JLabel ite;
	private JLabel fonctionObj;
	private Modele mod;
	
	//TODO ne pas oublier le model
	public VueInformation(Modele mod) {
		super();
		this.mod = mod;
		this.ite = new JLabel("nombre d'itérations: "); 
		this.fonctionObj = new JLabel("valeur de la fonction Objectif: ");
		this.add(ite);
		this.add(fonctionObj);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}

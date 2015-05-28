package Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueInformation extends JPanel implements Observer{
	
	private JLabel ite;
	private JLabel fonctionObj;
	
	//TODO ne pas oublier le model
	public VueInformation() {
		super();
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

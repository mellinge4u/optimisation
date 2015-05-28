package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Model;

public class VueClavier extends JPanel implements Observer{
	
	private JButton[][] touches;
	private Model mod;

	//TODO ne pas oublier le modele
	
	public VueClavier(Model mod){
		super();
		this.mod = mod;
//		this.setPreferredSize(new Dimension(500,500));
		this.setLayout(new GridLayout(4,10));
		this.touches = new JButton[10][4];
		for(int i = 0 ; i < touches.length ; i++ ){
			for(int j = 0 ; j < touches[i].length ; j++){
				touches[i][j] = new JButton();
				touches[i][j].setPreferredSize(new Dimension(50,50));
				touches[i][j].setBackground(Color.LIGHT_GRAY);
				this.add(touches[i][j]);
			}
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}

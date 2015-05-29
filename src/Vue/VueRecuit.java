package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ecouteurs.EcouteurLancer;
import model.Model;

public class VueRecuit extends JPanel implements Observer {

	private VueClavier vc;
	private JButton lancer;
	private JLabel temp;
	private JTextField tempVal;
	private JPanel jp;
	private VueInformation vi;
	private Model mod;

	// TODO RAJOUTER LE MODELE

	public VueRecuit(Model mod) {
		this.mod = mod;
		this.vc = new VueClavier(mod, Model.algo.recuit);
		vi = new VueInformation(mod, Model.algo.recuit);
		lancer = new JButton("Lancer");
		lancer.addActionListener(new EcouteurLancer(mod, Model.algo.recuit));
		temp = new JLabel("Temp�rature: ");
		tempVal = new JTextField("");
		tempVal.getDocument().addDocumentListener(new DocumentListener() {
			
			 @Override
			public void removeUpdate(DocumentEvent e) {
				String data = tempVal.getText();
				update(data);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String data = tempVal.getText();
				update(data);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
		        String data = tempVal.getText();	
		        update(data);
			}
			
			public int update(String s){
				int i;
				try{
					i = Integer.parseInt(s);
					mod.setTemperature(i);
					mod.setTmpCorrect(true);
				}catch(NumberFormatException e){
					i = 0;
					mod.setTmpCorrect(false);
				} 
				return i;
			}
			
		});
		this.setLayout(new BorderLayout());
		jp = new JPanel();
		jp.setLayout(new GridLayout(1, 2));
		jp.add(temp);
		jp.add(tempVal);
		jp.add(lancer);
		this.add(vc, BorderLayout.CENTER);
		this.add(jp, BorderLayout.NORTH);
		this.add(vi, BorderLayout.SOUTH);
		mod.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		lancer.setEnabled(mod.isTmpCorrect());
	}
}

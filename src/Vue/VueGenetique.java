package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modele.Modele;

public class VueGenetique extends JPanel {

	private VueClavier vc;
	private JButton lancer;
	private JLabel mutation;
	private JLabel population;
	private JTextField mutaVal;
	private JTextField popVal;
	private JPanel jp;
	private VueInformation vi;
	private Modele mod;

	// TODO RAJOUTER LE MODELE

	public VueGenetique(Modele mod) {
		this.mod = new Modele();
		this.vc = new VueClavier(mod);
		vi = new VueInformation(mod);
		lancer = new JButton("Lancer");
		mutation = new JLabel("Probabilité de mutation (%): ");
		mutaVal = new JTextField("");
		mutaVal.getDocument().addDocumentListener(new DocumentListener() {
			
			 private void updateData() {
			        // mise à jour de l'attribut data
			        String data = mutaVal.getText();
			        update(data);
			    }
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String data = mutaVal.getText();
				update(data);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String data = mutaVal.getText();
				update(data);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
		        String data = mutaVal.getText();	
		        update(data);
			}
			
			public int update(String s){
				int i;
				try{
					i = Integer.parseInt(s);
					mod.setMutation(i);
					mod.setMutaCorrect(true);
				}catch(NumberFormatException e){
					i = 0;
					mod.setMutaCorrect(false);
				} 
				return i;
			}
			
		});
		population = new JLabel("Taille de la population: ");
		popVal = new JTextField("");
		this.setLayout(new BorderLayout());
		jp = new JPanel();
		jp.setLayout(new GridLayout(1, 4));
		jp.add(mutation);
		jp.add(mutaVal);
		jp.add(population);
		jp.add(popVal);
		jp.add(lancer);
		this.add(vc,BorderLayout.CENTER);
		this.add(jp,BorderLayout.NORTH);
		this.add(vi,BorderLayout.SOUTH);
	}
}

package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueRecuit extends JPanel {


	private VueClavier vc;
	private JButton lancer;
	private JLabel temp;
	private JTextField tempVal;
	private JPanel jp;
	private VueInformation vi;
	
	// TODO RAJOUTER LE MODELE

		public VueRecuit() {
			this.vc = new VueClavier();
			vi = new VueInformation();
			lancer = new JButton("Lancer");
			temp = new JLabel("Température: ");
			tempVal = new JTextField("");
			this.setLayout(new BorderLayout());
			jp = new JPanel();
			jp.setLayout(new GridLayout(1, 2));
			jp.add(temp);
			jp.add(tempVal);
			jp.add(lancer);
			this.add(vc,BorderLayout.CENTER);
			this.add(jp,BorderLayout.NORTH);
			this.add(vi,BorderLayout.SOUTH);
		}

	
}

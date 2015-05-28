package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import clavier.Clavier;
import model.Model;

public class VueClavier extends JPanel implements Observer {

	private JButton[][] touches;
	private Model mod;
	private int i, j;

	// TODO ne pas oublier le modele

	public VueClavier(Model mod) {
		super();
		this.mod = mod;
		mod.addObserver(this);
		// this.setPreferredSize(new Dimension(500,500));
		this.setLayout(new GridLayout(4, 10));
		this.touches = new JButton[10][4];
		for (i = 0; i < touches[0].length; i++) {
			for (j = 0; j < touches.length; j++) {
				touches[j][i] = new JButton();
				touches[j][i].setPreferredSize(new Dimension(50, 50));
				// touches[j][i].setEnabled(false);
				touches[j][i].setBackground(Color.LIGHT_GRAY);
				touches[j][i].addActionListener(new ActionListener() {

					int k = 10 * i + j;

					@Override
					public void actionPerformed(ActionEvent e) {
						javax.swing.JOptionPane.showMessageDialog(null,
								"Évaluation de la touche : "
										+ mod.getKeyboard().evaluationTouche(k));

					}
				});
				this.add(touches[j][i]);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Clavier c = mod.getKeyboard();
		int touche;
		char ch;
		for (int i = 0; i < touches[0].length; i++) {
			for (int j = 0; j < touches.length; j++) {
				touches[j][i].setText("");
				touches[j][i].setEnabled(false);
			}
		}
		for (int i = 0; i < 26; i++) {
			touche = c.getTouche(i);
			ch = (char) ('A' + i);
			touches[touche % 10][touche / 10].setText("" + ch);
			touches[touche % 10][touche / 10].setEnabled(true);
		}
	}
}

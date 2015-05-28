package Vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class VuePrincipale extends JFrame{
		
	JTabbedPane jtb1 ;
	
	public VuePrincipale(){
		super("Optimisation d'un clavier");
		jtb1 = new JTabbedPane();
		jtb1.add("Genetique", new VueGenetique());
		jtb1.add("Recuit simul�", new VueRecuit());
		this.add(jtb1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack() ;
        setVisible(true);
	}
	
	public static void main(String[] args) {
        new VuePrincipale() ;
    }

}

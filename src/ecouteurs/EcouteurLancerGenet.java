package ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class EcouteurLancerGenet implements ActionListener {
	
	private Model mod;
	private Model.algo enm;
	
	public EcouteurLancerGenet(Model mod,Model.algo enm){
		this.mod = mod;
		this.enm = enm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		mod.demarrerAlgo(enm);
	}

}

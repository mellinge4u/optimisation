package ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class EcouteurLancerRecuit implements ActionListener {

	private Model mod;
	private Model.algo enm;
	
	public EcouteurLancerRecuit(Model mod,Model.algo enm){
		this.mod = mod;
		this.enm = enm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mod.demarrerAlgo(enm);
	}

}

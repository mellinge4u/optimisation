package ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class EcouteurLancer implements ActionListener {
	
	private Model mod;
	private Model.algo enm;
	
	public EcouteurLancer(Model mod,Model.algo enm){
		this.mod = mod;
		this.enm = enm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mod.demarrerAlgo(enm);
	}

}

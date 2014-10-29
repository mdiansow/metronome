package command;

import moteur.IMetronomeEngine;

public class Click implements Command {

	IMetronomeEngine moteur;

	
	public Click(IMetronomeEngine pMoteur) {
		this.moteur = pMoteur;
	}
	
	@Override
	public void execute() {
		this.moteur.click();
	}
}

package moteur;

import command.Command;

/**
 * Created by mds on 01/10/14.
 */
public interface MetronomeEngine {
	
	public Integer getTempo();
	public Integer getBarLength();
	public void setTempo(Integer untemps);
	public void setBarLengthempo(Integer untemps);
	public void setRunning(Boolean on);
	public Boolean isRunning();
	public void setCmd (Command uneCommande, String eventName);
	
}

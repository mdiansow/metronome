package moteur;

import command.ICommand;

/**
 * Metronome engine interface.
 * <p>
 * Created by mds on 01/10/14.
 */
public interface IMetronomeEngine {

    public Integer getTempo();

    public void setTempo(Integer untemps);

    public Integer getBarLength();

    public void setBarLength(Integer untemps);

    public boolean isRunning();

    public void setRunning(boolean on);

    public void setBeatCmd(ICommand cmd);

    public void setBarCmd(ICommand cmd);

}

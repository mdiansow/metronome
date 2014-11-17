package moteur;

import command.ICommand;

/**
 * Created by mds on 01/10/14.
 */
public interface IMetronomeEngine {

    public static final String BEAT_EVENT = "beat";

    public Integer getTempo();

    public void setTempo(Integer untemps);

    public Integer getBarLength();

    public void setBarLength(Integer untemps);

    public void setRunning(Boolean on);

    public Boolean isRunning();

    public void setBeatCmd(ICommand cmd);

    public void setBarCmd(ICommand cmd);

}

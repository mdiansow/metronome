package moteur;

import command.ICommand;

/**
 * The metronome engine clock interface
 * <p>
 * Created by mds on 18/11/14.
 */
public interface IClock {

    void start();

    void stop();

    void setBeatCmd(ICommand c);

    void setBarCmd(ICommand c);

    int getBeat();

    void setBeat(int beat);

    int getBar();

    void setBar(Integer bar);

    boolean isRunning();
}

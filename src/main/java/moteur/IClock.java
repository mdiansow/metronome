package moteur;

import command.ICommand;

/**
 * Created by mds on 18/11/14.
 */
public interface IClock {

    void start();

    void stop();

    void setBeatCmd(ICommand c);

    void setBarCmd(ICommand c);

    void setBeat(int beat);
}

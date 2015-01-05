package controller;

import iIhm.IBouton;
import iIhm.IDisplay;
import iIhm.ILed;
import iIhm.ISound;
import ihmImpl.Molette;

/**
 * Created by mds on 01/10/14.
 */
public interface IController {

    void setDisplay(IDisplay display);

    void setLedBar(ILed ledBar);

    void setLedBeet(ILed ledBeet);

    void setStopButton(IBouton stopButton);

    void setStartButton(IBouton startButton);

    void setIncrButton(IBouton incrButton);

    void setDecrButton(IBouton decrButton);

    void setSound(ISound sound);

    void setMolette(Molette mol);
}

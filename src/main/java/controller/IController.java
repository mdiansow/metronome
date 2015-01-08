package controller;

import view.iIhm.iAffichage.IDisplay;
import view.iIhm.iAffichage.ILed;
import view.iIhm.iClavier.IBouton;
import view.iIhm.iMolette.ISpanner;
import view.iIhm.iSound.ISound;

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

    void setMolette(ISpanner mol);
}

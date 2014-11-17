package controller;

import ihm.IBouton;
import ihm.IDisplay;
import ihm.ILed;

/**
 * Created by mds on 01/10/14.
 */
public interface IController {
    void handleBeatEvent();
    void handleBarEvent();

    void setDisplay(IDisplay display);

    void setButton(IBouton starButton, String start);

    void setLedBar(ILed ledBar);

    void setLedBeet(ILed ledBeet);
}

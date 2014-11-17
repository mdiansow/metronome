package controller;

import ihm.IBouton;
import ihm.IDisplay;
import ihm.ILed;
import moteur.IMetronomeEngine;
import moteur.MetronomeEngineImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jerem on 24/10/14.
 */
public class MainController implements IController {

    private IDisplay display;
    private Map<Object, Object> buttonMap;
    private ILed ledBar;
    private ILed ledBeet;
    private IMetronomeEngine me;

    public MainController() {
        me = new MetronomeEngineImpl(3, 150);
        buttonMap = new HashMap<>();
        this.getMe().setBarCmd(() -> this.handleBarEvent());
        this.getMe().setBeatCmd(() -> this.handleBeatEvent());
    }

    public IMetronomeEngine getMe() {
        return me;
    }

    public void setMe(IMetronomeEngine me) {
        this.me = me;
    }

    @Override
    public void handleBeatEvent() {
        System.out.println("###### BEAT #####");
        //this.display.display(me.getTempo());
    }

    @Override
    public void handleBarEvent() {
        System.out.println("======= BAR =======");
    }
//
//    public static void main(String[] args) {
//
//        MainController controller = new MainController();
//        controller.me.setRunning(true);
//
//        controller.getMe().setBarCmd(() -> controller.handleBarEvent());
//        controller.getMe().setBeatCmd(() -> controller.handleBeatEvent());
//    }
//

    public IDisplay getDisplay() {
        return display;
    }

    @Override
    public void setDisplay(IDisplay display) {
        this.display = display;
    }

    @Override
    public void setButton(IBouton starButton, String start) {
        buttonMap.put(start, starButton);

        if (start.equals("start")) {
            starButton.setCmd(() -> this.start());
        }
    }

    public void start() {
        me.setRunning(!me.isRunning());
        System.out.println("I'm here!");
    }

    public ILed getLedBeet() {
        return ledBeet;
    }

    @Override
    public void setLedBeet(ILed ledBeet) {
        this.ledBeet = ledBeet;
    }

    public ILed getLedBar() {
        return ledBar;
    }

    @Override
    public void setLedBar(ILed ledBar) {
        this.ledBar = ledBar;
    }

}

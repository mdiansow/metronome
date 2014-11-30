package controller;

import iIhm.IBouton;
import iIhm.IDisplay;
import iIhm.ILed;
import moteur.IMetronomeEngine;
import moteur.MetronomeEngineImpl;

/**
 * Created by jerem on 24/10/14.
 */
public class MainController implements IController {

    private IDisplay display;
    private ILed ledBar;
    private ILed ledBeet;
    private IMetronomeEngine me;

    private IBouton startButton;
    private IBouton stopButton;
    private IBouton incrButton;

    public MainController() {
        this.me = new MetronomeEngineImpl(220, 4);
        this.me.setBeatCmd(() -> {
            handleBeatEvent();
        });
        this.me.setBarCmd(() -> {
            this.handleBarEvent();
        });
    }

    @Override
    public void handleBeatEvent() {
        if (this.ledBeet != null) {
            this.ledBeet.setTempo(this.me.getTempo());
            this.ledBeet.flash();
        }
    }

    @Override
    public void handleBarEvent() {
        if (this.ledBar != null) {
            this.ledBar.setTempo(this.me.getTempo());
            this.ledBar.flash();
        }
    }

    public IDisplay getDisplay() {
        return display;
    }

    @Override
    public void setDisplay(IDisplay display) {
        this.display = display;
        this.display.display(this.me.getTempo());
    }

    @Override
    public void setLedBeet(ILed ledBeet) {
        this.ledBeet = ledBeet;
    }

    @Override
    public void setStopButton(IBouton stopButton) {
        this.stopButton = stopButton;
        this.setStopCmd();
    }

    @Override
    public void setStartButton(IBouton startButton) {
        this.startButton = startButton;
        this.setStartCmd();
    }

    @Override
    public void setIncrButton(IBouton incrButton) {
        this.incrButton = incrButton;
        this.setIncrCmd();
    }

    private void setIncrCmd() {
        this.incrButton.setCmd(() -> {
            this.me.incrTempo();
            this.display.display(this.me.getTempo());
        });
    }

    public void setStopCmd() {
        this.stopButton.setCmd(() -> {
            this.stopStartME(false);
        });
    }

    @Override
    public void setLedBar(ILed ledBar) {
        this.ledBar = ledBar;
    }

    public void setStartCmd() {
        this.startButton.setCmd(() -> {
            this.stopStartME(true);
        });
    }

    public void stopStartME(boolean b) {
        this.me.setRunning(b);
    }


//    public static void main(String[] args) {
//        MainController c = new MainController();
//        // ICommand beatCmd = new BeetEvnt(c);
//        c.getMe().setRunning(true);
//        c.getMe().setBeatCmd(() -> c.handleBeatEvent());
//        c.getMe().setBarCmd(() -> c.handleBarEvent());
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("la valeur");
//        boolean b = scanner.nextBoolean();
//        while (b) {
//            System.out.println("la valeur");
//            b = scanner.nextBoolean();
//            c.getMe().setRunning(b);
//        }
//    }
}

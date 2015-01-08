package controller;

import view.iIhm.iAffichage.IDisplay;
import view.iIhm.iClavier.IBouton;
import view.iIhm.iAffichage.ILed;
import view.iIhm.iMolette.ISpanner;
import view.iIhm.iSound.ISound;
import moteur.IMetronomeEngine;
import moteur.MetronomeEngineImpl;

/**
 * Created by jerem on 24/10/14.
 */
public class MainController implements IController {
    private static final Integer INCREMENT = 10;

    private IDisplay display;
    private ILed ledBar;
    private ILed ledBeet;
    private IMetronomeEngine me;

    private IBouton startButton;
    private IBouton stopButton;
    private IBouton incrButton;
    private IBouton decrButton;
    private ISound sound;
    private ISpanner molette;

    public MainController() {
        this.me = new MetronomeEngineImpl(30, 4);
        this.me.setBeatCmd(() -> {
            handleBeatEvent();
        });
        this.me.setBarCmd(() -> {
            this.handleBarEvent();
        });
    }

    @Override
    public void setSound(ISound sound) {
        this.sound = sound;
    }

    @Override
    public void setMolette(ISpanner mol) {
        this.molette = mol;
        this.setMoletteCmd();
    }

    public void handleBeatEvent() {
        if (this.ledBeet != null) {
            this.ledBeet.setTempo(this.me.getTempo());
            this.ledBeet.flash();
            this.sound.sendClick();
            this.display.display(this.me.getTempo());
        }
    }

    public void handleBarEvent() {
        if (this.ledBar != null) {
            this.ledBar.setTempo(this.me.getTempo());
            this.ledBar.flash();
            this.sound.sendClick();
        }
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

    @Override
    public void setDecrButton(IBouton decrButton) {
        this.decrButton = decrButton;
        this.setDecrCmd();
    }


    private void setMoletteCmd() {
        this.molette.setMoletteCmd(() -> {
            int tempo = this.molette.getValue();
            System.out.println("Mon tempo " + tempo);
            this.me.setTempo(tempo);
        });
    }

    private void setDecrCmd() {
        this.decrButton.setClickedCmd(() -> {
            this.me.setBarLength(this.me.getBarLength() - 1);
            // this.display.display(this.me.getTempo());
        });
    }

    private void setIncrCmd() {
        this.incrButton.setClickedCmd(() -> {
            this.me.setBarLength(this.me.getBarLength() + 1);
            // this.display.display(this.me.getTempo());
        });
    }

    private void setStopCmd() {
        this.stopButton.setClickedCmd(() -> {
            this.stopStartME(false);
        });
    }

    @Override
    public void setLedBar(ILed ledBar) {
        this.ledBar = ledBar;
    }

    private void setStartCmd() {
        this.startButton.setClickedCmd(() -> {
            this.stopStartME(true);
        });
    }

    private void stopStartME(boolean b) {
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

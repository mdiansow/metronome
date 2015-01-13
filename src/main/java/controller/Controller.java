package controller;

import moteur.IMetronomeEngine;
import moteur.MetronomeEngineImpl;
import view.iIhm.iAffichage.IDisplay;
import view.iIhm.iAffichage.ILed;
import view.iIhm.iClavier.IBouton;
import view.iIhm.iMolette.ISpanner;
import view.iIhm.iSound.ISound;

/**
 * The implementation of app controller
 * Created by jerem on 24/10/14.
 */
public class Controller implements IController {

    private final static Controller CONTROLLER = new Controller();

    private static final String BEAT_SOUND = "losticks.wav";
    private static final String BAR_SOUND = "hi conga.wav";

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

    public Controller() {
        this.me = new MetronomeEngineImpl(30, 4);
        this.me.setBeatCmd(() -> {
            handleBeatEvent();
        });
        this.me.setBarCmd(() -> {
            this.handleBarEvent();
        });
    }

    /**
     * Singleton of controller.
     *
     * @return IController.
     */
    public static IController getInstance() {
        return CONTROLLER;
    }

    /**
     * Soud setter.
     *
     * @param sound ISound
     */
    @Override
    public void setSound(ISound sound) {
        this.sound = sound;
    }

    /**
     * Molette setter.
     *
     * @param mol ISpanner
     */
    @Override
    public void setMolette(ISpanner mol) {
        this.molette = mol;
        this.setMoletteCmd();
    }

    /**
     * Handle the beat event.
     * It is call when the Metronome engine beat change.
     */
    public void handleBeatEvent() {
        if (this.ledBeet != null) {
            // this.ledBeet.setTempo(this.me.getTempo());
            this.ledBeet.flash(this.me.getTempo());
            this.sound.sendClick();
            this.display.display(this.me.getTempo(), this.me.getBarLength());
        }
    }

    /**
     * Handle the bar event.
     * It is call when the Metronome engine bar change.
     */
    public void handleBarEvent() {
        if (this.ledBar != null) {
            this.ledBar.flash(this.me.getTempo());
            this.sound.sendClick();
        }
    }

    /**
     * Display setter
     *
     * @param display IDisplay
     */
    @Override
    public void setDisplay(IDisplay display) {
        this.display = display;
        this.display.display(this.me.getTempo(), this.me.getBarLength());
    }

    /**
     * Led of beat setter
     *
     * @param ledBeet ILed
     */
    @Override
    public void setLedBeet(ILed ledBeet) {
        this.ledBeet = ledBeet;
    }

    /**
     * Stop button setter
     *
     * @param stopButton IBouton
     */
    @Override
    public void setStopButton(IBouton stopButton) {
        this.stopButton = stopButton;
        this.setStopCmd();
    }

    /**
     * Start button setter.
     *
     * @param startButton IBouton
     */
    @Override
    public void setStartButton(IBouton startButton) {
        this.startButton = startButton;
        this.setStartCmd();
    }

    /**
     * Increment button setter.
     *
     * @param incrButton IBouton
     */
    @Override
    public void setIncrButton(IBouton incrButton) {
        this.incrButton = incrButton;
        this.setIncrCmd();
    }

    /**
     * Decrement button setter.
     *
     * @param decrButton IBouton
     */
    @Override
    public void setDecrButton(IBouton decrButton) {
        this.decrButton = decrButton;
        this.setDecrCmd();
    }

    /**
     * Setter of led bar.
     *
     * @param ledBar ILed
     */
    @Override
    public void setLedBar(ILed ledBar) {
        this.ledBar = ledBar;
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

    private void setStartCmd() {
        this.startButton.setClickedCmd(() -> {
            this.stopStartME(true);
        });
    }

    private void stopStartME(boolean b) {
        this.me.setRunning(b);
    }

}

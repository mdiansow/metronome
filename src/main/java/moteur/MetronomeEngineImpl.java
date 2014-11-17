package moteur;

import command.ICommand;

/**
 * Created by root on 20/10/14.
 */
public class MetronomeEngineImpl implements IMetronomeEngine {

    private static final Integer INCREMENT = 10;
    /**
     * Metronome tempo
     */
    private Integer tempo;

    /**
     * Metronome bar
     */
    private Integer bar;

    /**
     * This boolean indicate when the metronome is run.
     */
    private boolean isRunning = false;

    private ICommand beatCmd;
    private ICommand barCmd;

    private IClock clock;

    private boolean destroy = false;

    public MetronomeEngineImpl(int beat, int bar) {
        this.tempo = beat;
        this.bar = bar;
        this.clock = new Clock(beat, bar);
    }

    @Override
    public Integer getTempo() {
        return this.clock.getBeat();
    }

    @Override
    public void setTempo(Integer untemps) {
        this.tempo = untemps;
    }

    @Override
    public Integer getBarLength() {
        return this.clock.getBar();
    }

    @Override
    public void setBarLength(Integer untemps) {
        this.bar = untemps;
        this.clock.setBar(untemps);
    }

    @Override
    public void setRunning(Boolean on) {
        this.isRunning = on;
        if (on) {
            clock.start();
        } else {
            clock.stop();
        }
    }

    @Override
    public Boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public void setBeatCmd(ICommand cmd) {
        beatCmd = cmd;
        clock.setBeatCmd(cmd);
    }

    @Override
    public void setBarCmd(ICommand cmd) {
        barCmd = cmd;
        clock.setBarCmd(cmd);
    }
}


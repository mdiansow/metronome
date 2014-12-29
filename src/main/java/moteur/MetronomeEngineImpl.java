package moteur;

import command.ICommand;

/**
 * Metronome engine class implements
 * <p>
 * Created by root on 20/10/14.
 */
public class MetronomeEngineImpl implements IMetronomeEngine {

    private IClock clock;

    /**
     * The metronome engine constructor
     *
     * @param beat int
     * @param bar  int
     */
    public MetronomeEngineImpl(int beat, int bar) {
        this.clock = new Clock(beat, bar);
    }

    /**
     * The metronome engine tempo getter
     *
     * @return Integer
     */
    @Override
    public Integer getTempo() {
        return this.clock.getBeat();
    }

    /**
     * The metronome engine tempo setter
     *
     * @param untemps Integer
     */
    @Override
    public void setTempo(Integer untemps) {
        this.clock.setBeat(untemps);
    }

    /**
     * The metronome engine bar getter
     *
     * @return Integer
     */
    @Override
    public Integer getBarLength() {
        return this.clock.getBar();
    }

    /**
     * The metronome engine bar setter
     *
     * @param untemps Integer
     */
    @Override
    public void setBarLength(Integer untemps) {
        this.clock.setBar(untemps);
    }

    /**
     * This method indicate when the metronome is run.
     */
    @Override
    public boolean isRunning() {
        return this.clock.isRunning();
    }

    /**
     * The metronome engine star/stop method
     *
     * @param on boolean
     */
    @Override
    public void setRunning(boolean on) {
        if (on) {
            clock.start();
        } else {
            clock.stop();
        }
    }

    /**
     * Beat command setter
     *
     * @param cmd ICommand
     */
    @Override
    public void setBeatCmd(ICommand cmd) {
        clock.setBeatCmd(cmd);
    }

    /**
     * Bar command setter
     *
     * @param cmd ICommand
     */
    @Override
    public void setBarCmd(ICommand cmd) {
        clock.setBarCmd(cmd);
    }
}
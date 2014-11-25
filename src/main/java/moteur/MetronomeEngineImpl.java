package moteur;

import command.ICommand;

/**
 * Created by root on 20/10/14.
 */
public class MetronomeEngineImpl implements IMetronomeEngine {

    /**
     * Metronome tempo
     */
    private Integer tempo;

    /**
     * Metronome bar
     */
    private Integer bar;

    /**
     * Count number of tempo
     */
    private Integer count = 0;

    /**
     * This boolean indicate when the metronome is run.
     */
    private boolean isRunning = false;

    private ICommand beatCmd;
    private ICommand barCmd;

    private IClock clock;

    private boolean destroy = false;

    public MetronomeEngineImpl(int bar, int tempo) {
        this.tempo = tempo;
        this.bar = bar;
        this.clock = new Clock(tempo, bar);
    }

    @Override
    public Integer getTempo() {
        return this.tempo;
    }

    @Override
    public void setTempo(Integer untemps) {
        this.tempo = untemps;
    }

    @Override
    public Integer getBarLength() {
        return this.bar;
    }

    @Override
    public void setBarLengthempo(Integer untemps) {
        this.bar = untemps;
    }

    @Override
    public void setRunning(Boolean on) {
        this.isRunning = on;
        if (this.isRunning) {
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
        this.beatCmd = cmd;
        clock.setBeatCmd(this.beatCmd);
    }

    @Override
    public void setBarCmd(ICommand cmd) {
        this.barCmd = cmd;
        clock.setBarCmd(this.barCmd);
    }

//    public static void main(String[] args) {
//        IController c = new MainController();
//        IMetronomeEngine m = new MetronomeEngineImpl(3, 250);
//        m.setBeatCmd(() -> {
//            System.out.println("Beet");
//        });
//        m.setBarCmd(() -> {
//            System.err.println("Bar");
//        });
//        m.setRunning(true);
//
//    }
}


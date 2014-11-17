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

    private boolean destroy = true;

    public MetronomeEngineImpl(int bar, int tempo) {
        this.tempo = tempo;
        this.bar = bar;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Running!");
                while (destroy) {
                    if (isRunning) {
                        /*Command beatCmd = myCommand.get("beat");
                        beatCmd.execute()*/
                        try {
                            // System.out.println("tempo");
                            // Call tempo command.
                            if (beatCmd != null) {
                                beatCmd.execute();
                            }
                            count %= bar;
                            if (count++ == 0) {
                                // Call bar command
                                if (barCmd != null)
                                    barCmd.execute();
                                // System.out.println("bar");
                            }
                            Thread.sleep(60 / tempo);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
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
        System.out.println("Running!");
        this.isRunning = on;
    }

    @Override
    public Boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public void setCmd(ICommand uneCommande, String eventName) {
        if (uneCommande != null && eventName != null) {
            System.out.println("add cmd " + eventName);
            //this.myCommand.put(eventName, uneCommande);
        }
    }

    @Override
    public void setBeatCmd(ICommand cmd) {
        this.beatCmd = cmd;
    }

    @Override
    public void setBarCmd(ICommand cmd) {
        this.barCmd = cmd;
    }
}


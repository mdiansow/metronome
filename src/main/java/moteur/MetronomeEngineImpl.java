package moteur;

import command.Command;

import java.util.HashMap;

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

    /**
     * The commands about the metronome tempo.
     */
    private HashMap<String, Command> myCommand = new HashMap<>();

    private boolean destroy = true;

    @Override
    public Integer getTempo() {
        return this.tempo;
    }

    @Override
    public Integer getBarLength() {
        return this.bar;
    }

    @Override
    public void setTempo(Integer untemps) {
        this.tempo = untemps;
    }

    @Override
    public void setBarLengthempo(Integer untemps) {
        this.bar = untemps;
    }

    @Override
    public void setRunning(Boolean on) {
        this.isRunning = on;
    }

    @Override
    public Boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public void setCmd(Command uneCommande, String eventName) {
        if (uneCommande != null && eventName != null)
            this.myCommand.put(eventName, uneCommande);
    }

    public MetronomeEngineImpl(int bar, int tempo) {
        this.tempo = tempo;
        this.bar = bar;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (destroy) {
                    if (isRunning) {
                        /*Command beatCmd = myCommand.get("beat");
                        beatCmd.execute()*/;
                        try {
                            System.out.println("tempo");
                            // Call tempo command.
                            myCommand.get("tempo").execute();
                            count %= bar;
                            if(count++ == 0){
                                // Call bar command
                                myCommand.get("bar").execute();
                                System.out.println("bar");
                            }
                            Thread.sleep(60/tempo);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        IMetronomeEngine m = new MetronomeEngineImpl(5, 300);
        m.setRunning(true);
    }
}


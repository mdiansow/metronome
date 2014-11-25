package moteur;

import command.ICommand;

/**
 * Created by mds on 18/11/14.
 */
public class Clock implements IClock {

    private Thread t;
    private int beat;
    private int bar;
    private ICommand beatCmd;
    private ICommand barCmd;
    private int count = 0;

    public Clock(int beat, int bar) {
        this.beat = beat;
        this.bar = bar;
    }

    @Override
    public void start() {
        if (t == null) {
            t = createThread();
            t.start();
        }
    }

    @Override
    public void stop() {
        if (t != null) {
            t.stop();
        }
    }

    @Override
    public void setBeatCmd(ICommand c) {
        beatCmd = c;
    }

    @Override
    public void setBarCmd(ICommand c) {
        barCmd = c;
    }

    private Thread createThread() {
        return new Thread() {
            @Override
            public void run() {
                while (true) {
                    //System.out.println("now runnin");
                    // System.err.println("modif running!");
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
                            if (barCmd != null) {
                                barCmd.execute();
                            }
                            // System.out.println("bar");
                        }
                        Thread.sleep(60 / beat);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}

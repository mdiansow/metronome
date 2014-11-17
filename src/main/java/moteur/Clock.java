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
    private boolean isRunning = false;

    public Clock(int beat, int bar) {
        this.beat = beat;
        this.bar = bar;
    }

    @Override
    public void start() {
        if (t == null) {
            isRunning = true;
            t = createThread();
            t.start();
        }
    }

    @Override
    public void stop() {
        if (t != null) {
            isRunning = false;
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

    @Override
    public int getBeat() {
        return beat;
    }

    @Override
    public void setBeat(int beat) {
        if (beat > 0) {
            this.beat = beat;
        }
    }

    @Override
    public void setBar(Integer bar) {
        if (bar > 0) {
            this.bar = bar;
        }
    }

    @Override
    public int getBar() {
        return bar;
    }

    public ICommand getBeatCmd() {
        return beatCmd;
    }

    public ICommand getBarCmd() {
        return barCmd;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    private Thread createThread() {
        return new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (isRunning) {
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
                            }
                            Thread.sleep(beat * 5);
                            System.out.println("BEAT " + beat);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        };
    }
}

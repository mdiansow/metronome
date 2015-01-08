package moteur;

import command.ICommand;

/**
 * The metronome engine clock class implements
 * <p>
 * Created by mds on 18/11/14.
 */
public class Clock implements IClock {

    private int beat;
    private int bar;
    private ICommand beatCmd;
    private ICommand barCmd;
    private int count = 0;
    private boolean isRunning = false;

    /**
     * The metronome engine timer constructor.
     *
     * @param beat int
     * @param bar int
     */
    public Clock(int beat, int bar) {
        this.beat = beat;
        this.bar = bar;

    }

    /**
     * Start method.
     * This method start the metronome engine timer.
     */
    @Override
    public void start() {
        Thread t = createThread();
        t.start();
        isRunning = true;
    }

    /**
     * Stop method.
     * This method stop the metronome engine timer.
     */
    @Override
    public void stop() {
        isRunning = false;

    }

    /**
     * Beat command setter
     *
     * @param c ICommand parameter
     */
    @Override
    public void setBeatCmd(ICommand c) {
        beatCmd = c;
    }

    /**
     * Bar command setter
     *
     * @param c ICommand parameter
     */
    @Override
    public void setBarCmd(ICommand c) {
        barCmd = c;
    }

    /**
     * Beat value getter.
     *
     * @return int
     */
    @Override
    public int getBeat() {
        return beat;
    }

    /**
     * Beat value setter
     *
     * @param beat int
     */
    @Override
    public void setBeat(int beat) {
        if (isRunning && beat > 0) {
            this.beat = beat;
        }
    }

    /**
     * Bar value getter
     *
     * @return int
     */
    @Override
    public int getBar() {
        return bar;
    }

    /**
     * Bar value setter
     *
     * @param bar int
     */
    @Override
    public void setBar(Integer bar) {
        if (isRunning && bar > 0) {
            this.bar = bar;
        }
    }

    /**
     * Timer status getter
     *
     * @return boolean
     */
    @Override
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Timer status setter
     *
     * @param isRunning boolean
     */
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

/*
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
*/

    /**
     * Create the thread like timer.
     *
     * @return Thread
     */
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
                            int time = 60000 / beat;
                            System.out.println(time + " en ms");
                            Thread.sleep(time);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        };
    }

}

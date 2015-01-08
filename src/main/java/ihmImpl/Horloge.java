package ihmImpl;

import command.ICommand;
import iIhm.iHorloge.IHorloge;

/**
 * Created by mds on 07/01/15.
 */
public class Horloge implements IHorloge {
    private Thread thread;
    private boolean isRunning = false;
    private long time;
    private ICommand cmd;

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
                            Thread.sleep(time);
                            cmd.execute();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        };
    }

    @Override
    public void activatePeriodically(ICommand cmd, int periodInSecond) {
        this.cmd = cmd;
        time = periodInSecond;
        thread = createThread();
        thread.start();
        isRunning = true;
    }

    @Override
    public void activateAfterTimeout(ICommand cmd, int periodInSecond) {

    }

    @Override
    public void deActivate(ICommand cmd) {
        isRunning = !isRunning;
    }
}

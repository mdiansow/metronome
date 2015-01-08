package view.ihmImpl;

import command.ICommand;
import view.iIhm.iHorloge.IHorloge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mds on 07/01/15.
 */
public class Horloge implements IHorloge {
    private Thread thread;
    private boolean isRunning = false;
    private long time;
    private ICommand cmd;

    private List<ICommand> listCmd = new ArrayList<>();

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
                    if (isRunning && listCmd.size() > 0) {
                        try {
                            Thread.sleep(time);
                            for (ICommand cmd : listCmd) {
                                cmd.execute();
                            }
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
        this.listCmd.add(cmd);
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

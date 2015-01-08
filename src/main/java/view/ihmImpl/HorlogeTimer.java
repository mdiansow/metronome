package view.ihmImpl;

import command.ICommand;
import view.iIhm.iHorloge.IHorloge;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Metronome engine horloge class
 * Created by mds on 06/01/15.
 */
public class HorlogeTimer implements IHorloge {

    private Timer timer;
    private TimerTask timerTask;
    private ICommand cmd;
//    private boolean isActivate = true;

    public HorlogeTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello world!!!");
                cmd.execute();
            }
        };
    }

    @Override
    public void activatePeriodically(ICommand cmd, int periodInSecond) {
        this.cmd = cmd;
        timer = new Timer();
        timer.schedule(timerTask, 0, periodInSecond);
    }

    @Override
    public void activateAfterTimeout(ICommand cmd, int periodInSecond) {

    }

    @Override
    public void deActivate(ICommand cmd) {
        timer.cancel();
    }


    public static void main(String args[]) {
        IHorloge h = new HorlogeTimer();
        h.activatePeriodically(null, 1000);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.deActivate(null);
        try {
            Thread.sleep(5000);
            System.out.println("I'm here!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h = new HorlogeTimer();
        h.activatePeriodically(null, 2);
    }
}

package controller;

import command.BarEvnt;
import command.BeetEvnt;
import command.ICommand;
import moteur.IMetronomeEngine;
import moteur.MetronomeEngineImpl;

/**
 * Created by mds on 24/10/14.
 */
public class ControllerImpl implements IController {

    private static IMetronomeEngine me;

    @Override
    public void handleBeatEvent() {
        System.out.println("###### BEAT #####");
    }

    @Override
    public void handleBarEvent() {
        System.out.println("======= BAR =======");
    }

    public static void main (String [] args){
        IController controller = new ControllerImpl();
        me = new MetronomeEngineImpl(3,150);
        ICommand barCmd = new BarEvnt(controller);
        ICommand beetCmd = new BeetEvnt(controller);
        me.setCmd(barCmd,"bar");
        me.setCmd(beetCmd,"beet");
        me.setRunning(true);
    }
}

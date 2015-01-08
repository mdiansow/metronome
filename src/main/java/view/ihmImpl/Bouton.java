package view.ihmImpl;

import command.ICommand;
import view.iIhm.iClavier.IBouton;
import javafx.scene.control.Button;


/**
 * Created by jerem on 14/11/14.
 */
public class Bouton implements IBouton {

    private Button monBouton;

    private ICommand cmd;

    public Bouton(Button b1) {
        b1 = monBouton;
    }


    @Override
    public void click() {
        cmd.execute();
    }

    @Override
    public void setClickedCmd(ICommand cmd) {
        this.cmd = cmd;
    }

}

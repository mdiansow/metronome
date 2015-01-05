package ihmImpl;

import command.ICommand;
import iIhm.IBouton;
import javafx.scene.control.Button;


/**
 * Created by jerem on 14/11/14.
 */
public class Bouton implements IBouton {

    private Button monBouton;

    private ICommand cmd;

    private boolean isPressed = false;

    public Bouton(Button b1) {
        b1 = monBouton;
    }


    @Override
    public void click() {
        cmd.execute();
    }

    @Override
    public void setCmd(ICommand cmd) {
        this.cmd = cmd;
    }

    @Override
    public boolean isPressed() {
        return this.isPressed;
    }
}

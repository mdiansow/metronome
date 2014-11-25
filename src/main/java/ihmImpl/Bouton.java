package ihmImpl;

import command.ICommand;
import iIhm.IBouton;
import javafx.scene.control.Button;


/**
 * Created by jerem on 14/11/14.
 */
public class Bouton implements IBouton {
    Button monBouton;
    private ICommand cmd;

    public Bouton(Button b1) {
        b1 = monBouton;
    }

    @Override
    public void enabled() {
        //monBouton.setDisable(false);
        System.out.println("coucou");
        //monBouton.setStyle("-fx-background: #BBBBBB;");
    }

    @Override
    public void click() {
        cmd.execute();
    }

    @Override
    public void setCmd(ICommand cmd) {
        this.cmd = cmd;
    }
}

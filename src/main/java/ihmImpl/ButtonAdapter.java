package ihmImpl;

import command.ICommand;
import iIhm.iClavier.IBouton;
import iIhm.iClavier.IClavier;
import iIhm.iHorloge.IHorloge;

/**
 * Created by mds on 06/01/15.
 */
public class ButtonAdapter implements IBouton {

    private final int numButton;
    private IClavier clavier;
    private ICommand cmd;
    private IHorloge horloge;

    private static final int MAX_ACTTIVE_BUTTON_NUMBER = 3;
    private static final int PERIODE_IN_MILLISECOND = 500;
    private boolean keyPressed = true;
    private int countActiveButton = 0;

    /**
     * Constructor
     *
     * @param clavier IClavier
     */
    public ButtonAdapter(IClavier clavier, int numButton) {
        this.clavier = clavier;
        this.numButton = numButton;
        horloge = new Horloge();
        horloge.activatePeriodically(() -> {
            click();
        }, PERIODE_IN_MILLISECOND);
    }

    private void poll() {
        keyPressed = this.clavier.keyPressed(numButton);
        click();
    }

    /**
     * Click method implementation
     */
    @Override
    public void click() {
        boolean isPressed = this.clavier.keyPressed(numButton);
        if (!keyPressed && isPressed) {
            this.cmd.execute();
            // this.horloge.deActivate(cmd);
        }
        keyPressed = isPressed;
        System.out.println("Key ==== " + numButton + " === is " + keyPressed);
    }

    /**
     * Command setter
     *
     * @param cmd ICommand
     */
    @Override
    public void setClickedCmd(ICommand cmd) {
        this.cmd = cmd;
    }

    public static void main(String[] args) {
        new ButtonAdapter(null, 1);
    }
}

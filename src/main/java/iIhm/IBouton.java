package iIhm;

import command.ICommand;

/**
 * Button interface.
 * Created by mds on 01/10/14.
 */
public interface IBouton {

    /**
     *
     */
    void click();

    /**
     * Command setter
     * @param cmd ICommand
     */
    void setCmd(ICommand cmd);

    /**
     * Return true if this is pressed
     * @return boolean
     */
    boolean isPressed();
}

package iIhm;

import command.ICommand;

/**
 * Created by mds on 01/10/14.
 */
public interface IBouton {

    void click();

    void setCmd(ICommand cmd);
}

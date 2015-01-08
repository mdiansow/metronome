package view.iIhm.iMolette;

import command.ICommand;

/**
 * Spanner interface.
 * This interface is a component of Controller.
 * It change the beet value by executing his command.
 *
 * Created by mds on 01/10/14.
 */
public interface ISpanner {

    public Integer getValue();

    void setMoletteCmd(ICommand cmd);
}

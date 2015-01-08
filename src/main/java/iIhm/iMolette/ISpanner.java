package iIhm.iMolette;

import command.ICommand;

/**
 * Created by mds on 01/10/14.
 */
public interface ISpanner {

    public Integer getValue();

    void setChangeValue(ICommand cmd);
}

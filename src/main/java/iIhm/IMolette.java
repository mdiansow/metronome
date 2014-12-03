package iIhm;

import command.ICommand;

/**
 * Created by mds on 01/10/14.
 */
public interface IMolette {

    public Integer getValue();

    void setChangeValue(ICommand cmd);
}

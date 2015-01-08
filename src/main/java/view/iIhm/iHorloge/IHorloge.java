package view.iIhm.iHorloge;

import command.ICommand;

/**
 * Manage Button status
 *
 * @author MDian
 * @since 04/01/2015
 */
public interface IHorloge {
    /**
     * Periodic call the execute () operation cmd, all periods of periodInSecond in millisecond
     *
     * @param cmd            ICommand
     * @param periodInSecond float
     */
    void activatePeriodically(ICommand cmd, int periodInSecond);

    /**
     * Call execute() operation of cmd after a period of periodInSecond in millisecond
     *
     * @param cmd            ICommand
     * @param periodInSecond int
     */
    void activateAfterTimeout(ICommand cmd, int periodInSecond);

    /**
     * Deactivate execute() operation of cmd
     *
     * @param cmd ICommand
     */
    void deActivate(ICommand cmd);
}

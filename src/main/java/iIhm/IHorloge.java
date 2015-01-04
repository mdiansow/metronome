package iIhm;

import command.ICommand;

/**
 * Manage Button status
 *
 * @author MDian
 * @since 04/01/2015
 */
public interface IHorloge {
    /**
     * Periodic call the execute () operation cmd, all periods of periodInSecond
     *
     * @param cmd            ICommand
     * @param periodInSecond float
     */
    void activatePeriodically(ICommand cmd, float periodInSecond);

    /**
     * Call execute() operation of cmd after a period of periodInSecond
     *
     * @param cmd            ICommand
     * @param periodInSecond float
     */
    void activateAfterTimeout(ICommand cmd, float periodInSecond);

    /**
     * Deactivate execute() operation of cmd
     *
     * @param cmd ICommand
     */
    void deactivate(ICommand cmd);
}

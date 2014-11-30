package command;

import controller.IController;

/**
 * Created by mds on 01/10/14.
 */
public class BeetEvnt implements ICommand {

    private IController controller;

    public BeetEvnt(IController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.handleBeatEvent();
	}

}

package command;

import controller.IController;

/**
 * Created by mds on 01/10/14.
 */
public class BarEvnt implements ICommand {

    private IController controller;

    public BarEvnt(IController controller) {
        this.controller = controller;
    }

    public void execute() {
		controller.handleBarEvent();
	}
}

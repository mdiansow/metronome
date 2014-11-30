package command;

import controller.IController;

/**
 * Cette classe implémente la commande concrète BarEvnt qui
 * est executée par le moteur pour notifier le controlleur de
 * la longueur d'une mesure.
 *
 * Created by mds on 01/10/14.
 */
public class BarEvnt implements ICommand {

    /**
     * Instance du controlleur qui joue le role de receiver
     */
    private IController controller;

    /**
     * Constructeur
     * @param controller IController
     */
    public BarEvnt(IController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
		controller.handleBarEvent();
	}
}

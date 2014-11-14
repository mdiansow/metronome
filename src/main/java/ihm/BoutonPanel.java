package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;


/**
 * Created by jerem on 14/11/14.
 */
public class BoutonPanel implements  IBoutonPanel {
    Button monBouton ;

    public BoutonPanel( Button b1){
        b1 = monBouton;

    }

    @Override
    public void enabled() {
        System.out.println("coucou");
        //monBouton.setStyle("-fx-background: #BBBBBB;");
    }
}

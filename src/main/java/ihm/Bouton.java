package ihm;

import javafx.scene.control.Button;


/**
 * Created by jerem on 14/11/14.
 */
public class Bouton implements IBouton {
    Button monBouton ;

    public Bouton(Button b1){
        b1 = monBouton;

    }

    @Override
    public void enabled() {
        System.out.println("coucou");
        //monBouton.setStyle("-fx-background: #BBBBBB;");
    }
}

package ihm;

import javafx.scene.shape.Ellipse;

/**
 * Created by jerem on 14/11/14.
 */
public class Led implements  ILed {

    Boolean etat;
    Ellipse monEllipse;

    public Led(Ellipse aEllipse){
        monEllipse = aEllipse;
        etat = false;


    }
    @Override
    public void flash() {
        if (etat){
            monEllipse.setStyle("-fx-fill : blue");
            etat= false;
        }
        else{
            monEllipse.setStyle("-fx-fill : green");
            etat = true;

        }
    }
}

package view.ihmImpl.v1;

import view.iIhm.iAffichage.IDisplay;
import javafx.application.Platform;
import javafx.scene.control.TextField;


/**
 * Created by jerem on 14/11/14.
 */
public class Display implements IDisplay {
    private Integer number;
    private TextField lazone;
    private TextField mesureZone;

    public Display(TextField mazone, TextField mesureFXML) {
        lazone = mazone;
        this.mesureZone = mesureFXML;
    }

    @Override
    public void display(Integer tempo, Integer barLength) {
        Platform.runLater(() -> {
            lazone.setText(tempo.toString());
            mesureZone.setText(barLength.toString());
        });
    }
}

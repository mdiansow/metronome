package view.ihmImpl.affichageImpl;

import javafx.animation.FillTransition;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;
import view.iIhm.iAffichage.IViewerAdapter;

/**
 * View class implement
 * Created by mds on 09/01/15.
 */
public class ViewerAdapterImpl implements IViewerAdapter {

    private Ellipse[] tabLed;

    //    private Ellipse beatLEDFXML;
//    private Ellipse barLEDFXML;
    private TextField tempoValueFXML;
    private TextField mesureValueFXML;

    public ViewerAdapterImpl(Ellipse[] tabLed, TextField tempoValueFXML, TextField mesureValueFXML) {
        this.tabLed = tabLed;
        this.tempoValueFXML = tempoValueFXML;
        this.mesureValueFXML = mesureValueFXML;
    }

    @Override
    public void turnOnLED(int numLED, int tempo) {
        Platform.runLater(() -> {
            Transition transition = new FillTransition(Duration.millis(60000 / tempo), tabLed[numLED], Color.BLACK, Color.RED);
            //transition.setAutoReverse(false);
            transition.play();
        });
    }

    @Override
    public void turnOffLED(int numLED, int tempo) {
        Platform.runLater(() -> {
            Transition transition = new FillTransition(Duration.millis(60000 / tempo), tabLed[numLED], Color.RED, Color.BLACK);
            // transition.setAutoReverse(false);
            transition.play();
        });
    }

    @Override
    public void displayTempo(Integer tempoValue, Integer mesureValue) {
        Platform.runLater(() -> {
            this.tempoValueFXML.setText(tempoValue.toString());
            mesureValueFXML.setText(mesureValue.toString());
        });
    }
}

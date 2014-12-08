package ihmImpl;

import iIhm.ILed;
import javafx.animation.FillTransition;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;


/**
 * Created by jerem on 14/11/14.
 */
public class Led implements ILed {

    private static final String BEAT_PARAM = "beat";
    Boolean etat;
    Ellipse monEllipse;
    private int tempo = 120;

    public Led(Ellipse aEllipse) {
        monEllipse = aEllipse;
        etat = false;
    }

    @Override
    public void flash() {
        Platform.runLater(() -> {
        });
        Transition transition = new FillTransition(Duration.millis(this.tempo), monEllipse, Color.BLACK, Color.RED);
        transition.setAutoReverse(true);
        transition.play();
    }


    @Override
    public void setTempo(int s) {
        this.tempo = s;
    }
}

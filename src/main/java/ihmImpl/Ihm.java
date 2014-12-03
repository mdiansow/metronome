package ihmImpl;

import controller.MainController;
import iIhm.IBouton;
import iIhm.ILed;
import iIhm.ISound;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.shape.Ellipse;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jerem on 20/10/14.
 */
public class Ihm implements Initializable {
    private static final int INDEX_NUMBER_OF_CHANGE = 10;
    @FXML
    private Button startFXML;
    @FXML
    private Button stopFXML;
    @FXML
    private Button incrFXML;
    @FXML
    private Button decrFXML;

    private IBouton starButton;
    private IBouton stopButton;
    private IBouton incrButton;
    private IBouton decrButton;

    @FXML
    private Ellipse ledBeetFXML;
    @FXML
    private Ellipse ledBarFXML;

    private ILed led1;
    private ILed led2;

    @FXML
    private TextArea textAreaAffichage;

    @FXML
    private TextField tempoField;

    private Display display;

    @FXML
    private Slider sliderFXML;

    @FXML
    private ProgressBar pb;

    private Molette mol;

    private MainController meController;
    private ISound sound;

    private int startIndex;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        meController = new MainController();
        starButton = new Bouton(startFXML);
        stopButton = new Bouton(stopFXML);
        incrButton = new Bouton(incrFXML);
        decrButton = new Bouton(decrFXML);

        led1 = new Led(ledBeetFXML);
        led2 = new Led(ledBarFXML);

        tempoField.setEditable(false);
        display = new Display(tempoField);
        mol = new Molette(sliderFXML);

        // Sound
        sound = new Sound();
        meController.setSound(sound);


        // Slider
        sliderFXML.setShowTickLabels(true);
        sliderFXML.setShowTickMarks(true);
        meController.setMolette(mol);
        sliderFXML.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                startIndex++;
                if ((startIndex % INDEX_NUMBER_OF_CHANGE) == 0) {
                    System.out.println("la valeur " + newValue.intValue());
                    mol.setSliderValue(newValue.intValue());
                }
            }
        });

        // Set Controller
        meController.setDisplay(display);

        meController.setStartButton(starButton);
        meController.setStopButton(stopButton);
        meController.setIncrButton(incrButton);
        meController.setDecrButton(decrButton);

        meController.setLedBeet(led1);
        meController.setLedBar(led2);
    }

    public void actionButtonStart(ActionEvent actionEvent) {
        starButton.click();
    }

    public void actionButtonStop(ActionEvent actionEvent) {
        stopButton.click();
    }

    public void actionButtonInc(ActionEvent actionEvent) {
        incrButton.click();
    }

    public void actionButtonDecrement(ActionEvent actionEvent) {
        decrButton.click();
    }
}

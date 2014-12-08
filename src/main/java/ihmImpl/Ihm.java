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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

import java.awt.*;
import java.awt.Color;
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

    private IBouton startButton;
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
    private TextField tempoField;

    private Display display;

    @FXML
    private Slider sliderFXML;

    private Molette mol;

    private MainController meController;
    private ISound sound;

    private int startIndex;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        meController = new MainController();
        startButton = new Bouton(startFXML);
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

                mol.setSliderValue(newValue.intValue());

            }
        });

        // Set Controller
        meController.setDisplay(display);

        meController.setStartButton(startButton);
        meController.setStopButton(stopButton);
        meController.setIncrButton(incrButton);
        meController.setDecrButton(decrButton);

        meController.setLedBeet(led1);
        meController.setLedBar(led2);
    }

    public void actionButtonStart(ActionEvent actionEvent) {
        sliderFXML.setDisable(false);
        incrFXML.setDisable(false);
        decrFXML.setDisable(false);
        startFXML.setDisable(true);
        stopFXML.setDisable(false);
        startButton.click();
    }

    public void actionButtonStop(ActionEvent actionEvent) {

        stopButton.click();

        stopFXML.setDisable(true);
        startFXML.setDisable(false);
        sliderFXML.setDisable(true);
        incrFXML.setDisable(true);
        decrFXML.setDisable(true);

        ledBarFXML.setFill(javafx.scene.paint.Color.BLACK);
        ledBeetFXML.setFill(javafx.scene.paint.Color.BLACK);
        startFXML.requestFocus();

    }

    public void actionButtonInc(ActionEvent actionEvent) {
        incrButton.click();
    }

    public void actionButtonDecrement(ActionEvent actionEvent) {
        decrButton.click();
    }
}

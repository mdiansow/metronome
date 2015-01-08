package ihmImpl;

import controller.MainController;
import iIhm.IIhm;
import iIhm.iAffichage.ILed;
import iIhm.iClavier.IBouton;
import iIhm.iClavier.IClavier;
import iIhm.iSound.ISound;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Ellipse;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jerem on 20/10/14.
 */
public class Ihm implements Initializable, IIhm {
    //private static final int INDEX_NUMBER_OF_CHANGE = 10;
    private static final int START_BUTTON_NUMBER = 0;
    private static final int STOP_BUTTON_NUMBER = 1;
    private static final int INCR_BUTTON_NUMBER = 2;
    private static final int DECRE_BUTTON_NUMBER = 3;

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
    private IClavier clavier = new Clavier();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        meController = new MainController();
        startButton = new ButtonAdapter(clavier, START_BUTTON_NUMBER);//new Bouton(startFXML);
        stopButton = new ButtonAdapter(clavier, STOP_BUTTON_NUMBER);//*/Bouton(stopFXML);
        incrButton = new ButtonAdapter(clavier, INCR_BUTTON_NUMBER);//new Bouton(incrFXML);
        decrButton = new ButtonAdapter(clavier, DECRE_BUTTON_NUMBER);//new Bouton(decrFXML);

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
        // startButton.click();
        clavier.pressKey(START_BUTTON_NUMBER);
    }

    public void actionButtonStop(ActionEvent actionEvent) {

        // stopButton.click();
        clavier.pressKey(STOP_BUTTON_NUMBER);
        //clavier.pressKey(1);

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
        clavier.pressKey(INCR_BUTTON_NUMBER);
        //incrButton.click();
    }

    public void actionButtonDecrement(ActionEvent actionEvent) {
        clavier.pressKey(DECRE_BUTTON_NUMBER);
        //decrButton.click();
    }
}

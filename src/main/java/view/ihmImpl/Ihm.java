package view.ihmImpl;

import controller.IController;
import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import view.iIhm.IIhm;
import view.iIhm.iAffichage.IDisplay;
import view.iIhm.iAffichage.ILed;
import view.iIhm.iAffichage.IViewerAdapter;
import view.iIhm.iClavier.IBouton;
import view.iIhm.iClavier.IClavier;
import view.iIhm.iMolette.ISpanner;
import view.iIhm.iMolette.ISpannerAdapter;
import view.iIhm.iSound.ISoundIHM;
import view.iIhm.iSound.ISound;
import view.ihmImpl.affichageImpl.DisplayAdapterImpl;
import view.ihmImpl.affichageImpl.LedAdapterImpl;
import view.ihmImpl.affichageImpl.ViewerAdapterImpl;
import view.ihmImpl.clavierImpl.ButtonAdapter;
import view.ihmImpl.clavierImpl.Clavier;
import view.ihmImpl.moletteImpl.SpannerAdapterImpl;
import view.ihmImpl.moletteImpl.SpannerImpl;
import view.ihmImpl.soundImpl.SoundAdapterImpl;
import view.ihmImpl.soundImpl.SoundImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Metronome IHM.
 * Created by jerem on 20/10/14.
 */
public class Ihm extends Application implements Initializable, IIhm {
    //private static final int INDEX_NUMBER_OF_CHANGE = 10;
    private static final int START_BUTTON_NUMBER = 0;
    private static final int STOP_BUTTON_NUMBER = 1;
    private static final int INCR_BUTTON_NUMBER = 2;
    private static final int DECRE_BUTTON_NUMBER = 3;
    private static final int NUM_LED_1 = 0;
    private static final int NUM_LED_2 = 1;

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
    private TextField tempoFieldFXML;

    private IDisplay display;

    @FXML
    private Slider sliderFXML;

    @FXML
    private TextField mesureFXML;

    private ISpanner mol;

    private IController meController;
    private ISound sound;

    private IClavier clavier = new Clavier();
    private ISpannerAdapter spanner = new SpannerAdapterImpl();
    private IViewerAdapter viewer;
    private ISoundIHM sonor = new SoundImpl();


    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/metronome.fxml"));
            primaryStage.setTitle("Notre Super Métronome");
            primaryStage.setScene(new Scene(root, 550, 250));
            primaryStage.show();
            primaryStage.setOnCloseRequest(t -> {
                Platform.exit();
                System.exit(0);
                primaryStage.close();
            });


        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startButton = new ButtonAdapter(clavier, START_BUTTON_NUMBER, new Horloge());//new Bouton(startFXML);
        stopButton = new ButtonAdapter(clavier, STOP_BUTTON_NUMBER, new Horloge());//*/Bouton(stopFXML);
        incrButton = new ButtonAdapter(clavier, INCR_BUTTON_NUMBER, new Horloge());//new Bouton(incrFXML);
        decrButton = new ButtonAdapter(clavier, DECRE_BUTTON_NUMBER, new Horloge());//new Bouton(decrFXML);

        Ellipse[] ledTab = {ledBeetFXML, ledBarFXML};
        viewer = new ViewerAdapterImpl(ledTab, tempoFieldFXML, mesureFXML);

        led1 = new LedAdapterImpl(viewer, NUM_LED_1);//Led(ledBeetFXML);
        led2 = new LedAdapterImpl(viewer, NUM_LED_2);//Led(ledBarFXML);

        tempoFieldFXML.setEditable(false);
        display = new DisplayAdapterImpl(viewer);//Display(tempoFieldFXML, mesureFXML);
        mol = new SpannerImpl(spanner, new Horloge());//Molette(sliderFXML);

        // Sound
        sound = new SoundAdapterImpl(sonor);//Sound();

        initController();

        // Slider
        sliderFXML.setShowTickLabels(true);
        sliderFXML.setShowTickMarks(true);
        sliderFXML.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                spanner.setSpannerValue(newValue.intValue());
            }
        });

    }

    /**
     * Controller initialisation.
     * This method set the controller component like buttons, led, ...
     */
    public void initController() {
        meController = Controller.getInstance();
        // Set Display
        meController.setDisplay(display);
        // Set spanner
        meController.setMolette(mol);
        // Set buttons
        meController.setStartButton(startButton);
        meController.setStopButton(stopButton);
        meController.setIncrButton(incrButton);
        meController.setDecrButton(decrButton);
        // Set leds
        meController.setLedBeet(led1);
        meController.setLedBar(led2);
        // Set sound
        meController.setSound(sound);
    }

    /**
     * Start button.
     * @param actionEvent
     */
    public void actionButtonStart(ActionEvent actionEvent) {
        sliderFXML.setDisable(false);
        incrFXML.setDisable(false);
        decrFXML.setDisable(false);
        startFXML.setDisable(true);
        stopFXML.setDisable(false);
        clavier.pressKey(START_BUTTON_NUMBER);
    }

    /**
     * Stop button.
     * @param actionEvent
     */
    public void actionButtonStop(ActionEvent actionEvent) {

        clavier.pressKey(STOP_BUTTON_NUMBER);

        stopFXML.setDisable(true);
        startFXML.setDisable(false);
        sliderFXML.setDisable(true);
        incrFXML.setDisable(true);
        decrFXML.setDisable(true);

        ledBarFXML.setFill(javafx.scene.paint.Color.BLACK);
        ledBeetFXML.setFill(javafx.scene.paint.Color.BLACK);
        startFXML.requestFocus();
    }

    /**
     * Increment button.
     * @param actionEvent
     */
    public void actionButtonInc(ActionEvent actionEvent) {
        clavier.pressKey(INCR_BUTTON_NUMBER);
    }

    /**
     * Decrement button.
     * @param actionEvent
     */
    public void actionButtonDecrement(ActionEvent actionEvent) {
        clavier.pressKey(DECRE_BUTTON_NUMBER);
    }

}

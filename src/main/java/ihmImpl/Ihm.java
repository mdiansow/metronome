package ihmImpl;

import controller.MainController;
import iIhm.IBouton;
import iIhm.ILed;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Ellipse;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jerem on 20/10/14.
 */
public class Ihm implements Initializable {
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

    private Display display;

    @FXML
    private ProgressBar pb;

    private Molette mol;

    private MainController meController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        meController = new MainController();
        starButton = new Bouton(startFXML);
        stopButton = new Bouton(stopFXML);
        incrButton = new Bouton(incrFXML);
        decrButton = new Bouton(decrFXML);

        led1 = new Led(ledBeetFXML);
        led2 = new Led(ledBarFXML);

        display = new Display(textAreaAffichage);
        mol = new Molette(pb);

        // Set Controller
        meController.setDisplay(display);
        meController.setStartButton(starButton);
        meController.setStopButton(stopButton);
        meController.setIncrButton(incrButton);
//        meController.addButton(incrButton, "incr");
//        meController.addButton(decrButton, "decr");
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
    }
}

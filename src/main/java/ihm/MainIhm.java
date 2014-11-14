package ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jerem on 20/10/14.
 */
public class MainIhm implements Initializable {
    @FXML private Button b1;
    @FXML private Button b2;
    @FXML private Button b3;
    @FXML private Button b4;

    private BoutonPanel bp1;
    private BoutonPanel bp2;
    private BoutonPanel bp3;
    private BoutonPanel bp4;



    @FXML
    public void plop(ActionEvent actionEvent) {
        System.out.println("You clicked me!");
        bp1.enabled();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bp1 = new BoutonPanel(b1);
        bp2 = new BoutonPanel(b2);
        bp3 = new BoutonPanel(b3);
        bp4 = new BoutonPanel(b4);

    }
}

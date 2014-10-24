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

import java.io.IOException;

/**
 * Created by jerem on 20/10/14.
 */
public class MainIhm extends  Application {
    @FXML private Button b1;
    @FXML private Button b2;
    @FXML private Button b3;
    @FXML private Button b4;


    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/metronome.fxml"));
            primaryStage.setTitle("Notre Super Métronome");
            primaryStage.setScene(new Scene(root, 550, 250));
            primaryStage.show();
        }catch (IOException exception) {
            throw new RuntimeException(exception);
        }


    }
    public static void main(String[] args) {
        launch(args);
    }

    public void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
}

package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by mds on 17/11/14.
 */
public class ControllerFXML extends Application {

    public static void main(String[] args) {

//        MainController controller = new MainController();
//        controller.getMe().setRunning(true);
//
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/metronome.fxml"));
            primaryStage.setTitle("Notre Super Métronome");
            primaryStage.setScene(new Scene(root, 550, 250));
            primaryStage.show();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}

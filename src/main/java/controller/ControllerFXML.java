package controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by mds on 17/11/14.
 */
public class ControllerFXML extends Application {

    public static void main(String[] args) {
        //controller.getMe().setRunning(false);
        launch(args);

    }

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

}

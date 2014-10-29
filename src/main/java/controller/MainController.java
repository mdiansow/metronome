package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by jerem on 24/10/14.
 */
public class MainController extends Application{


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
}

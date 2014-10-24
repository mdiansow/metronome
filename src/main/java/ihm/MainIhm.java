package ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by jerem on 20/10/14.
 */
public class MainIhm extends  Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/metronome.fxml"));
        primaryStage.setTitle("Notre Super Métronome");
        primaryStage.setScene(new Scene(root, 550, 250));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

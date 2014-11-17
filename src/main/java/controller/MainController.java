package controller;

import command.BarEvnt;
import command.BeetEvnt;
import command.ICommand;
import ihm.ISound;
import ihm.Sound;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import moteur.IMetronomeEngine;
import moteur.MetronomeEngineImpl;

import java.io.IOException;

/**
 * Created by jerem on 24/10/14.
 */
public class MainController extends Application implements  IController{

    @Override
    public void start(Stage primaryStage) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("/metronome.fxml"));
        primaryStage.setTitle("Notre Métronome");
        primaryStage.setScene(new Scene(root, 550, 250));
        primaryStage.show();
    }catch (IOException exception) {
        throw new RuntimeException(exception);
    }
}

        private static IMetronomeEngine me;

        @Override
        public void handleBeatEvent() {
            System.out.println("###### BEAT #####");
        }

        @Override
        public void handleBarEvent() {
            System.out.println("======= BAR =======");
            //Sound son = new Sound();
            //son.start();
        }

    public static void main (String [] args){
        IController controller = new MainController();
        me = new MetronomeEngineImpl(1,1000000000);
        ICommand barCmd = new BarEvnt(controller);
        ICommand beetCmd = new BeetEvnt(controller);
        me.setCmd(barCmd,"bar");
        me.setCmd(beetCmd,"beet");
        //me.setRunning(true);

        launch(args);
    }


}

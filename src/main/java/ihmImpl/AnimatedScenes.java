package ihmImpl;

/**
 * Created by mds on 25/11/14.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.TextBuilder;
import javafx.util.*;

public class AnimatedScenes extends Application {

    VBox page1 = null;
    VBox page2 = null;
    Timeline timeline1 = null;
    Timeline timeline2 = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {


        primaryStage.setTitle("Hello World");

        final Group root = new Group();
        final Scene scene = new Scene(root, 300, 250);
        page1 = VBoxBuilder.create()
                .spacing(10)
                .children(TextBuilder.create()
                                .text("Home page").build(),
                        ButtonBuilder.create()
                                .text("Login")
                                .onAction(new EventHandler<ActionEvent>() {

                                    @Override
                                    public void handle(ActionEvent e) {
                                        root.getChildren().remove(page1);
                                        timeline1.play();
                                        root.getChildren().add(page2);
                                    }
                                }).build())
                .build();



        page2 = VBoxBuilder.create()
                .spacing(10)
                .children(TextFieldBuilder.create()
                                .text("")
                                .build(),
                        ButtonBuilder.create()
                                .text("Go to home page")
                                .onAction(new EventHandler<ActionEvent>() {

                                    @Override
                                    public void handle(ActionEvent e) {
                                        root.getChildren().remove(page2);
                                        timeline2.play();
                                        root.getChildren().add(page1);
                                    }
                                }).build()).build();


        root.getChildren().add(page1);

        timeline1 = new Timeline(
                new KeyFrame(Duration.seconds(0), new KeyValue(page2.opacityProperty(), 0.0)),
                new KeyFrame(Duration.seconds(3), new KeyValue(page2.opacityProperty(), 1.0)));



        timeline2 = new Timeline(
                new KeyFrame(Duration.seconds(0), new KeyValue(page1.opacityProperty(), 0.0)),
                new KeyFrame(Duration.seconds(3), new KeyValue(page1.opacityProperty(), 1.0)));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
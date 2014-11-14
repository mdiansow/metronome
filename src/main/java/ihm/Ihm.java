package ihm;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Ellipse;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jerem on 20/10/14.
 */
public class Ihm implements Initializable {
    @FXML private Button b1;
    @FXML private Button b2;
    @FXML private Button b3;
    @FXML private Button b4;

    private Bouton bp1;
    private Bouton bp2;
    private Bouton bp3;
    private Bouton bp4;

    @FXML private Ellipse e1;
    @FXML private Ellipse e2;

    private Led le1;
    private Led le2;

    @FXML private TextArea ta;

    private Display zoneDaffichage;

    @FXML private ProgressBar pb;

    private Molette mol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bp1 = new Bouton(b1);
        bp2 = new Bouton(b2);
        bp3 = new Bouton(b3);
        bp4 = new Bouton(b4);

        le1 = new Led(e1);
        le2 = new Led(e2);

        zoneDaffichage = new Display(ta);
        mol = new Molette(pb);
    }

   public void actionButtStart(ActionEvent actionEvent) {
       System.out.println("You clicked me!");
       bp1.enabled();
       le1.flash();
       le2.flash();
       zoneDaffichage.display();
    }

    public void actionButtStop(ActionEvent actionEvent) {
    }

    public void actionButtInc(ActionEvent actionEvent) {
    }

    public void actionButtDecrement(ActionEvent actionEvent) {
    }
}

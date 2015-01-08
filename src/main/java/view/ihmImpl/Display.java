package view.ihmImpl;

import view.iIhm.iAffichage.IDisplay;
import javafx.application.Platform;
import javafx.scene.control.TextField;


/**
 * Created by jerem on 14/11/14.
 */
public class Display implements IDisplay {
    Integer number;
    TextField lazone;

    public Display(TextField mazone) {
        lazone = mazone;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public TextField getLazone() {
        return lazone;
    }

    public void setLazone(TextField lazone) {
        this.lazone = lazone;
    }

    @Override
    public void display(Integer tempo) {
        Platform.runLater(() -> {
            lazone.setText(tempo.toString());
        });
    }
}

package ihmImpl;

import iIhm.IDisplay;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 * Created by jerem on 14/11/14.
 */
public class Display implements IDisplay {
    Integer number;
    TextArea lazone;

    public Display(TextArea mazone) {
        lazone = mazone;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public TextArea getLazone() {
        return lazone;
    }

    public void setLazone(TextArea lazone) {
        this.lazone = lazone;
    }

    @Override
    public void display(Integer tempo) {
        Platform.runLater(() -> {
        });
        lazone.setText(tempo.toString());
    }
}

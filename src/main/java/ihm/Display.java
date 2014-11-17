package ihm;

import javafx.scene.control.TextArea;

/**
 * Created by jerem on 14/11/14.
 */
public class Display implements  IDisplay{
    Integer number ;
    TextArea lazone;

    public  Display(TextArea mazone){
        lazone = mazone;
        number = 25;

    }
    @Override
    public void display() {
        lazone.setText(number.toString());
    }
}

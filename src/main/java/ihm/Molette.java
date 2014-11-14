package ihm;

import javafx.scene.control.ProgressBar;

/**
 * Created by jerem on 14/11/14.
 */
public class Molette implements IMolette {

    private ProgressBar pgb;

    @Override
    public Integer getValue() {
        return null;
    }

    public Molette(ProgressBar apgb){

        pgb=apgb;
    }


}

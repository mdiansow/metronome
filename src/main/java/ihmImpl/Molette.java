package ihmImpl;

import iIhm.IMolette;
import javafx.scene.control.ProgressBar;

/**
 * Created by jerem on 14/11/14.
 */
public class Molette implements IMolette {

    private ProgressBar pgb;

    public Molette(ProgressBar apgb){

        pgb=apgb;
    }

    @Override
    public Integer getValue() {
        return null;
    }


}

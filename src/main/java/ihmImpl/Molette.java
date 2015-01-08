package ihmImpl;

import command.ICommand;
import iIhm.iMolette.IMolette;
import javafx.scene.control.Slider;

/**
 * Created by jerem on 14/11/14.
 */
public class Molette implements IMolette {

    private Slider pgb;

    private int sliderValue;
    private ICommand cmd;

    public Molette(Slider apgb) {
        pgb = apgb;
    }

    public void setSliderValue(int sliderValue) {
        this.sliderValue = sliderValue;
        this.cmd.execute();
    }

    @Override
    public Integer getValue() {
        return sliderValue;
    }

    @Override
    public void setChangeValue(ICommand cmd) {
        this.cmd = cmd;
    }

}

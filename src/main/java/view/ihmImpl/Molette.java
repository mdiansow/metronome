package view.ihmImpl;

import command.ICommand;
import view.iIhm.iMolette.ISpanner;
import javafx.scene.control.Slider;

/**
 * Implement the ISpanner interface.
 *
 * Created by jerem on 14/11/14.
 */
public class Molette implements ISpanner {

    private Slider pgb;

    private int sliderValue;
    private ICommand cmd;

    public Molette(Slider apgb) {
        pgb = apgb;
    }

    /**
     *
     * @param sliderValue
     */
    public void setSliderValue(int sliderValue) {
        this.sliderValue = sliderValue;
        this.cmd.execute();
    }

    @Override
    public Integer getValue() {
        return sliderValue;
    }

    @Override
    public void setMoletteCmd(ICommand cmd) {
        this.cmd = cmd;
    }

}

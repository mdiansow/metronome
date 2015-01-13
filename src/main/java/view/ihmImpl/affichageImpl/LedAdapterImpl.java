package view.ihmImpl.affichageImpl;

import view.iIhm.iAffichage.ILed;
import view.iIhm.iAffichage.IViewerAdapter;


/**
 * Created by jerem on 14/11/14.
 */
public class LedAdapterImpl implements ILed {

    private IViewerAdapter viewer;
    private int numLED;

    public LedAdapterImpl(IViewerAdapter viewer, int numLED) {
        this.viewer = viewer;
        this.numLED = numLED;
    }

    @Override
    public void flash(int time) {
        viewer.turnOnLED(this.numLED, time);
        viewer.turnOffLED(this.numLED, time);
    }
}

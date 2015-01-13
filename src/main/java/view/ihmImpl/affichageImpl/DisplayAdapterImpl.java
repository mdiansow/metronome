package view.ihmImpl.affichageImpl;

import view.iIhm.iAffichage.IDisplay;
import view.iIhm.iAffichage.IViewerAdapter;

/**
 * Created by mds on 10/01/15.
 */
public class DisplayAdapterImpl implements IDisplay {
    private IViewerAdapter viewer;

    public DisplayAdapterImpl(IViewerAdapter viewer) {
        this.viewer = viewer;
    }

    @Override
    public void display(Integer tempo, Integer barLength) {
        viewer.displayTempo(tempo, barLength);
    }
}

package view.ihmImpl;

import view.iIhm.iClavier.IClavier;
import view.iIhm.iAffichage.IViewer;
import view.iIhm.iHorloge.IHorloge;
import view.iIhm.iMolette.ISpannerAdapter;
import view.iIhm.iSound.ISound;

/**
 * Material class
 * Provides access to the hardware control interfaces
 * Created by MDian on 04/01/2015.
 */
public class Material {

    private static IHorloge horloge = new Horloge();
    private static IClavier clavier = new Clavier();
    private static ISpannerAdapter spanner = new SpannerAdapterImpl();
    private static ISound sound = new Sound();
    private static IViewer viewer;

    /**
     * Horloge getter
     * @return
     */
    static IHorloge getHorloge() {
        return Material.horloge;
    }

    /**
     * Clavier getter
     * @return IClavier
     */
    static IClavier getClavier() {
        return Material.clavier;
    }

    /**
     * Spanner getter
     * @return ISpanner
     */
    static ISpannerAdapter getSpanner() {
        return Material.spanner;
    }

    /**
     * Sound getter
     * @return ISound
     */
    static ISound getSound() {
        return Material.sound;
    }

    /**
     * Viewer getter
     * @return IViewer
     */
    static IViewer getViewer() {
        return Material.viewer;
    }
}

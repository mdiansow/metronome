package ihmImpl;

import iIhm.iClavier.IClavier;
import iIhm.iAffichage.IViewer;
import iIhm.iHorloge.IHorloge;
import iIhm.iMolette.ISpanner;
import iIhm.iSound.ISound;

/**
 * Material class
 * Provides access to the hardware control interfaces
 * Created by MDian on 04/01/2015.
 */
public class Material {

    private static IHorloge horloge;
    private static IClavier clavier;
    private static ISpanner spanner;
    private static ISound sound;
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
    static ISpanner getSpanner() {
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

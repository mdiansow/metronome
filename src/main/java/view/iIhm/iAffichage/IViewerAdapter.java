package view.iIhm.iAffichage;

/**
 * Display interface
 * Created by mds on 17/11/14.
 */
public interface IViewerAdapter {
    /**
     * Light the led numLED
     *
     * @param numLED int
     */
    void turnOnLED(int numLED, int tempo);

    /**
     * Turn off the led numLED
     *
     * @param numLED int
     */
    void turnOffLED(int numLED, int tempo);

    /**
     * Display the tempo value in the screen
     *
     * @param tempoValue int
     */
    void displayTempo(Integer tempoValue, Integer mesureValue);
}

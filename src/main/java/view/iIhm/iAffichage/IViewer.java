package view.iIhm.iAffichage;

/**
 * Display interface
 * Created by mds on 17/11/14.
 */
public interface IViewer {
    /**
     * Light the led numLED
     *
     * @param numLED int
     */
    void turnOnLED(int numLED);

    /**
     * Turn off the led numLED
     *
     * @param numLED int
     */
    void turnOffLED(int numLED);

    /**
     * Display the tempo value in the screen
     *
     * @param tempoValue int
     */
    void displayTempo(int tempoValue);
}

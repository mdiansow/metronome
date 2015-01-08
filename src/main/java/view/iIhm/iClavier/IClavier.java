package view.iIhm.iClavier;

/**
 * Keyboard interface
 * Created by mds on 17/11/14.
 */
public interface IClavier {

    void pressKey(int i);

    /**
     * Return true if button i is pressed, false if it is released.
     *
     * @param i int
     * @return boolean
     */
    boolean keyPressed(int i);
}

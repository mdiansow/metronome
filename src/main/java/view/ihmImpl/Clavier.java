package view.ihmImpl;

import view.iIhm.iClavier.IClavier;

/**
 * Clavier class implement
 * Created by mds on 05/01/15.
 */
public class Clavier implements IClavier {
    private static final int MAX_ACTTIVE_BUTTON_NUMBER = 3;

    // La liste des boutons du clavier
    // List<IBouton> listButton = new ArrayList<IBouton>();

    private boolean[] tabButtonIsPressed = {true, true, true, true};

    private int[] tabActiveButton = {0, 0, 0, 0};
    private int countActiveButton = 0;

    /**
     * Change key status.
     *
     * @param i int
     */
    @Override
    public void pressKey(int i) {
        tabButtonIsPressed[i] = !tabButtonIsPressed[i];
    }

    /**
     * keyPressed method implementation
     *
     * @param i int
     * @return boolean
     */
    @Override
    public boolean keyPressed(int i) {
        boolean isPressed = tabButtonIsPressed[i];
        if (isPressed == false) {
            tabActiveButton[i] = tabActiveButton[i] + 1;
        }
        if (tabActiveButton[i] == MAX_ACTTIVE_BUTTON_NUMBER) {
            tabActiveButton[i] = 0;
            tabButtonIsPressed[i] = true;
        }
        return isPressed;
    }
}

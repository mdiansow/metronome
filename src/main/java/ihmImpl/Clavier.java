package ihmImpl;

import iIhm.IBouton;
import iIhm.IClavier;

import java.util.ArrayList;
import java.util.List;

/**
 * Clavier class implement
 * Created by mds on 05/01/15.
 */
public class Clavier implements IClavier {

    // La liste des boutons du clavier
    List<IBouton> listButton = new ArrayList<IBouton>();

    /**
     * keyPressed method implementation
     * @param i int
     * @return boolean
     */
    @Override
    public boolean keyPressed(int i) {
        return listButton.get(i).isPressed();
    }
}

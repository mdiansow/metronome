package moteur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MetronomeEngineImplTest {
    IMetronomeEngine me;

    @org.junit.Before
    public void setUp() throws Exception {
        me = new MetronomeEngineImpl(120, 4);
    }

    @org.junit.Test
    public void testGetTempo() throws Exception {
        int expected = 120;
        int actual = me.getTempo();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testSetTempo() throws Exception {

    }

    @org.junit.Test
    public void testGetBarLength() throws Exception {
        int expected = 4;
        int actual = me.getBarLength();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testSetBarLength() throws Exception {

    }

    @org.junit.Test
    public void testIsRunning() throws Exception {
        boolean isRunning = me.isRunning();
        assertTrue(!isRunning);

        me.setRunning(true);

        assertTrue(me.isRunning());

        me.setRunning(false);

        assertTrue(!me.isRunning());
    }

    @org.junit.Test
    public void testSetRunning() throws Exception {

    }

    @org.junit.Test
    public void testSetBeatCmd() throws Exception {

    }

    @org.junit.Test
    public void testSetBarCmd() throws Exception {

    }
}
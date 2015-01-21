package moteur;

import command.ICommand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        me.setRunning(true);
        me.setTempo(220);
        assertTrue(me.getTempo() == 220);
    }

    @org.junit.Test
    public void testGetBarLength() throws Exception {
        int expected = 4;
        int actual = me.getBarLength();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testSetBarLength() throws Exception {
        me.setRunning(true);
        me.setBarLength(5);
        assertTrue("Bar length  " + me.getBarLength(), me.getBarLength() == 5);
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
        me.setRunning(true);
        assertTrue(me.isRunning());
    }

    @org.junit.Test
    public void testSetBeatCmd() throws Exception {
        ICommand beatCmd = new ICommand() {
            @Override
            public void execute() {
                System.out.println("Beat cmd");
            }
        };
        me.setBeatCmd(beatCmd);

        assertNotNull(beatCmd);

        me.setRunning(true);
    }

    @org.junit.Test
    public void testSetBarCmd() throws Exception {
        ICommand barCmd = new ICommand() {
            @Override
            public void execute() {
                System.out.println("Bar cmd");
            }
        };
        me.setBarCmd(barCmd);
        assertNotNull(barCmd);

        me.setRunning(true);
        assertTrue(me.isRunning());
    }
}
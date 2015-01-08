package view.ihmImpl;

import view.iIhm.iSound.ISound;

import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Created by jerem on 17/11/14.
 */
public class Sound extends Thread implements ISound {
    AudioInputStream audioInputStream = null;
    SourceDataLine line;

    private URL u1;
    private AudioClip s1;

    public Sound() {
        u1 = getClass().getClassLoader().getResource("losticks.wav");
        s1 = Applet.newAudioClip(u1);
    }
    public void sendClick() {
        s1.play();
    }

}

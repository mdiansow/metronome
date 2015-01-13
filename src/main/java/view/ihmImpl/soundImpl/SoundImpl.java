package view.ihmImpl.soundImpl;

import view.iIhm.iSound.ISoundIHM;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Created by jerem on 17/11/14.
 */
public class SoundImpl extends Thread implements ISoundIHM {

    private URL u1;
    private AudioClip s1;

    public SoundImpl() {
        u1 = getClass().getClassLoader().getResource("losticks.wav");
        s1 = Applet.newAudioClip(u1);
    }

    @Override
    public void makeSound() {
        s1.play();
    }
}

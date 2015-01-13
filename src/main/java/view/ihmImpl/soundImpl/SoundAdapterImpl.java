package view.ihmImpl.soundImpl;

import view.iIhm.iSound.ISoundIHM;
import view.iIhm.iSound.ISound;

/**
 * Sound adapter implements
 * Created by mds on 10/01/15.
 */
public class SoundAdapterImpl implements ISound {
    private ISoundIHM sound;

    public SoundAdapterImpl(ISoundIHM sound) {
        this.sound = sound;
    }

    @Override
    public void sendClick() {
        sound.makeSound();
    }
}

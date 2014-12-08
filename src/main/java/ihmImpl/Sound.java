package ihmImpl;

import iIhm.ISound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by jerem on 17/11/14.
 */
public class Sound implements ISound {
    AudioInputStream audioInputStream = null;
    SourceDataLine line;

    public void run() {
        File fichier = new File("beep2.wav");
        try {
            AudioFileFormat format = AudioSystem.getAudioFileFormat(fichier);
            audioInputStream = AudioSystem.getAudioInputStream(fichier);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();
            byte bytes[] = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) {
                line.write(bytes, 0, bytesRead);
            }
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
//        javax.sound.sampled.LineUnavailableException: line with format
//        PCM_SIGNED 44100.0 Hz,
//                24 bit,
//                stereo,
//                6 bytes/frame,
//                little-endian not supported

    }
}

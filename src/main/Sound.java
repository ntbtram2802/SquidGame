package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
public class Sound{
    Clip clip;
    URL soundUrl[]= new URL[30];
    private FloatControl fc;
    private int volumeSlace=3;
    private float volume;

    public Sound(){
        soundUrl[0]=getClass().getResource("/sound/Squid Game Red Light Green Light Sound.wav");
        soundUrl[1]=getClass().getResource("/sound/gameover.wav");
        soundUrl[2]=getClass().getResource("/sound/levelup.wav");
        soundUrl[3]=getClass().getResource("/sound/Squid Game - Way Back Then  Orchestral Cover.wav");


    }
    public void setFile(int i){
        try {
            AudioInputStream ais=AudioSystem.getAudioInputStream(soundUrl[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception e) {
        }

    }
    public void play(){
        clip.start();

    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void stop(){
        clip.stop();
    }
    public void checkVolume(){
    switch (volumeSlace){
        case 0:
            volume = -80f;
            break;
        case 1:
            volume = -12f;
            break;
        case 2:
            volume = 1f;
            break;
        case 3: 
            volume = 6f;
            break;
    }
    fc.setValue(volume);
    }
}
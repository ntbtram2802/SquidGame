package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
public class Sound{
    private Clip clip;
    private URL soundUrl[]= new URL[30];
    private FloatControl fc;
    private static int volumeSlace=3;
    private float volume;

    public Sound(){
        soundUrl[0]=getClass().getResource("/sound/Squid Game Red Light Green Light Sound.wav");
        soundUrl[1]=getClass().getResource("/sound/gameover.wav");
        soundUrl[2]=getClass().getResource("/sound/levelup.wav");
        soundUrl[3]=getClass().getResource("/sound/Squid Game - Way Back Then  Orchestral Cover.wav");
        soundUrl[4]=getClass().getResource("/sound/cursor.wav");
         soundUrl[5]=getClass().getResource("/sound/Winning.wav");
    }
    public int getvolumeSlace() {return volumeSlace;}
    public void setvolumeSlace(int newvolume) { this.volumeSlace = newvolume;}
    public void setFile(int i){
        try {
            AudioInputStream ais=AudioSystem.getAudioInputStream(soundUrl[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();
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
        System.out.println("0");
        break;
    case 1:
        volume = -20f;
        System.out.println("1");
        break;
    case 2:
        volume = -12f;
        System.out.println("2");
        break;
    case 3: 
        volume = -5f;
        System.out.println("3");
        break;
    case 4: 
        volume = 1f;
        System.out.println("4");
        break;
    case 5: 
        volume = 6f;
        System.out.println("5");
        break;
    }
    fc.setValue(volume);
    }
}
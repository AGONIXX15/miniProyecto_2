package models.pokemon.utils;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproduceSound {
    private Clip clip;
    public void  loadSound(String path  ) {
        try{
            File fileSound = new File(path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileSound);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void playSound() {
        if(clip != null) {
            clip.setFramePosition(0);
            clip.start();
            // Espera mientras el sonido se reproduce
            try {
                Thread.sleep(5000); // Espera 5 segundos (ajusta según duración del audio)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ReproduceSound reproduceSound = new ReproduceSound();
        reproduceSound.loadSound("src/models/pokemon/utils/ready-fight-37973.wav");
        reproduceSound.playSound();}
}

        // Espera mientras el sonido se reproduce





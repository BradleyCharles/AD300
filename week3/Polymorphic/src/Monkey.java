import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Monkey extends Animal {
    public Monkey(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        try {
            // Open an audio input stream from the 'sounds' folder.
            File soundFile = new File("sounds/monkey.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Start playing the sound.
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Overloaded makeSound method that takes an integer parameter
    public String makeSound(int times) {
        StringBuilder soundOutput = new StringBuilder();
        for (int i = 0; i < times; i++) {
            soundOutput.append("and whoops ");
        }
        return soundOutput.toString().trim();
    }
}

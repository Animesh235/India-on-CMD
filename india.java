import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class india {

    // Shared variable to signal when to stop audio playback
    private static AtomicBoolean shouldStop = new AtomicBoolean(false);

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String strLine = "";

        // Start audio playback in a separate thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                playAudio("D:/india.wav");
            }
        }).start();

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:/india.txt"));
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine);
                sb.append(System.lineSeparator());
                System.out.println(strLine);

                // Sleep for 300 milliseconds
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.err.println("Sleep interrupted");
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        } finally {
            // Signal to stop audio playback
            shouldStop.set(true);
        }
    }

    private static void playAudio(String filePath) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new java.io.File(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            // Loop the audio
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
            // Keep playing until shouldStop is set to true
            while (!shouldStop.get()) {
                Thread.sleep(100);  // Check every 100 milliseconds
            }
            
            // Stop the clip
            clip.stop();
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Audio playback error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Playback thread interrupted");
        }
    }
}

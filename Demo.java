import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Demo {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);

        File file = new File("MerryChristmasMr_lawrence-originalVersion.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        String response = "";

        while (!response.equals("Q")) {
            System.out.println("S:start; P:pause; R:reset; Q:quit");
            System.out.println("Enter your choice");

            response = scanner.next();
            response = response.toUpperCase();

            switch (response) {
                case "S":
                    clip.start();
                    break;
                case "P":
                    clip.stop();
                    break;
                case "R":
                    clip.setMicrosecondPosition(0);
                    break;
                case "Q":
                    clip.close();
                    break;
                default:
                    System.out.println("Not valid input");
                    break;
            }
        }
        scanner.close();
    }
}
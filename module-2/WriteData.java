// Jacob Achenbach
// 6/8/2025

// Program generates five random integers and five random doubles, then writes or appends them to a file named

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

// WriteData Class
public class WriteData {
    public static void main(String[] args) {
        String filename = "jacobachenbach_datafile.dat";
        Random rand = new Random();

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Integers: ");
            for (int i = 0; i < 5; i++) {
                int randomInt = rand.nextInt(100); // 0-99 limit
                writer.write(randomInt + " ");
            }

            writer.write("\nDoubles: ");
            for (int i = 0; i < 5; i++) {
                double randomDouble = rand.nextDouble() * 100; // 0.0-99.999...
                writer.write(String.format("%.2f ", randomDouble));
            }
            writer.write("\n---\n"); // Separator for the entries
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

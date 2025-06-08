// Jacob Achenbach
// 6/8/2025

// Program reads the contents of jacobachenbach_datafile.dat and displays everything stored in it.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


// ReadData Class
public class ReadData {
    public static void main(String[] args) {
        String filename = "jacobachenbach_datafile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
}

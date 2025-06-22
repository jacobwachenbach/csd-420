// Jacob Achenbach
// 6/22/2025

// Program that sorts words from a txt file

import java.io.*;
import java.util.*;

public class WordSorter {
    public static void main(String[] args) {
        // Read words from file
        List<String> words = readWordsFromFile("set_words.txt");

        // Use TreeSet for automatic sorting and duplicate removal
        Set<String> ascendingSet = new TreeSet<>(words);
        Set<String> descendingSet = new TreeSet<>(Collections.reverseOrder());
        descendingSet.addAll(words);

        // Print results
        System.out.println("Ascending Order:");
        for (String word : ascendingSet) {
            System.out.println(word);
        }

        System.out.println("\nDescending Order:");
        for (String word : descendingSet) {
            System.out.println(word);
        }

        // Simple test to check word presence
        if (ascendingSet.contains("apple")) {
            System.out.println("\nTest Passed: 'apple' found in set.");
        } else {
            System.out.println("\nTest Failed: 'apple' not found.");
        }
    }
    // Reads words from the given file and returns a list of a cleaned and lowercase words
    private static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                // Read next token, remove non-letter characters and convert to lowercase
                String word = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return words;
    }
}

// Jacob Achenbach
// 7/6/2025

// Program starts three threads to display 10,000 random letters, digits, and symbols in a GUI text area.

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JacobAchenbachThreeThreads  extends JFrame {
    private JTextArea textArea;

    public JacobAchenbachThreeThreads () {
        // Set up the JFrame
        setTitle("Three Threads Output");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        setVisible(true);

        // Start threads
        startThreads();
    }

    private void startThreads() {
        Thread lettersThread = new Thread(() -> generateCharacters("letters"));
        Thread digitsThread = new Thread(() -> generateCharacters("digits"));
        Thread symbolsThread = new Thread(() -> generateCharacters("symbols"));

        lettersThread.start();
        digitsThread.start();
        symbolsThread.start();
    }

    private void generateCharacters(String type) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 10_000; i++) {
            char ch;
            if (type.equals("letters")) {
                ch = (char) (random.nextInt(26) + 'a'); // a-z letters
            } else if (type.equals("digits")) {
                ch = (char) (random.nextInt(10) + '0'); // 0-9 numbers
            } else {
                char[] symbols = {'!', '@', '#', '$', '%', '&', '*'}; // symbols
                ch = symbols[random.nextInt(symbols.length)];
            }
            builder.append(ch);
        }

        // Append the output to the JTextArea in the Swing thread
        SwingUtilities.invokeLater(() -> {
            textArea.append(type.toUpperCase() + ": " + builder.toString() + "\n\n");
        });
    }

    public static void main(String[] args) {
        // Start the GUI
        SwingUtilities.invokeLater(JacobAchenbachThreeThreads ::new);
    }
}

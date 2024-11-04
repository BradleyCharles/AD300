
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;



public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        setTitle("School Management System"); // Set the title of the frame
        setSize(750, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // # buttons, # columns, spacing

        // Display Word Count Button
        createButton("Display Word Count", e -> {
            try {
                File myObj = new File("Lucas, George - A New Hope - script.txt");
                try (Scanner myReader = new Scanner(myObj)) {
                    HashMap<String, Integer> wordCount = new HashMap<>();
                    while (myReader.hasNext()) {
                        String data = myReader.next();
                        wordCount.put(data, wordCount.getOrDefault(data, 0) + 1 );
                    }

                    // Sort the map by values
                    Map<String, Integer> sortedMap = sortByValue(wordCount);

                    // Display sorted map in text area
                    sortedMap.forEach((key, value) -> textArea.append(key + ": " + value + "\n"));
                }
            } catch (FileNotFoundException err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.EAST);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createButton(String text, ActionListener listener, JPanel panel) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        panel.add(button);
    }

    // Method to sort the map by value
    private static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

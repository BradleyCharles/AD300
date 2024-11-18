
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        setTitle(""); // Set the title of the frame
        setSize(750, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1, 10, 10)); // # buttons, # columns, spacing

        //Text Input
        JTextField studentIdField = new JTextField();
        JPanel idPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        // Student ID Field
        idPanel.add(new JLabel("Customer Name:"));
        idPanel.add(studentIdField);
        buttonPanel.add(idPanel);

        WaitingListManager waitingList = new WaitingListManager();

        // Display Word Count Button
        createButton("Check list for customer", e -> {
            try {
                waitingList.isPersonInList(studentIdField.getText());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Add customer to waiting list", e -> {
            try {
                waitingList.addPerson(studentIdField.getText());
                textArea.setText("Added");
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Display customer waiting list", e -> {
            try {
                String output = waitingList.displayWaitingList();
                textArea.setText(output);
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Size of customer waiting list", e -> {
            try {
                textArea.setText("Now serving :" + waitingList.waitingListSize());
            } catch (Exception err) {
                System.out.println("Main ServePerson error");
            }
        }, buttonPanel);

        createButton("Serve next customer", e -> {
            try {
                String output = waitingList.servePerson();
                textArea.setText("Now serving :" + output);
            } catch (Exception err) {
                System.out.println("Main ServePerson error");
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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        setTitle("AD 300 Component Software"); // Set the title of the frame
        setSize(750, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 10, 10)); // # buttons, # columns, spacing

        // Box examples
        Box<String> boxString = new Box<>("What is the answer to life, the universe, and everything?");
        Box<Integer> boxInt = new Box<>(42);

        //NumberBox examples
        NumberBox<Integer> numberBoxInt = new NumberBox<>(8675309);
        NumberBox<Double> numberBoxDouble = new NumberBox<>(3.14);
        //NumberBox<String> numberBoxString = new NumberBox<>("String");

        StringProcessor stringProcessor = new StringProcessor();

        String palindrome = "Bob drives a racecar really fast";

        // Display buttons
        createButton("Print String Box", e -> {
            try {
                textArea.setText(boxString.printBox());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Print Integer Box", e -> {
            try {
                textArea.setText(boxInt.printBox());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Print Integer NumBox", e -> {
            try {
                textArea.setText(numberBoxInt.printInt().toString());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Print Double NumBox", e -> {
            try {
                textArea.setText(numberBoxDouble.printDouble().toString());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Print String", e -> {
            try {
                textArea.setText(palindrome);
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Print Reverse String", e -> {
            try {
                textArea.setText(stringProcessor.process(palindrome));
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Print Wildcard Box", e -> {
            try {
                textArea.setText(boxInt.printBox(boxInt));
            } catch (Exception err) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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
        buttonPanel.setLayout(new GridLayout(11, 1, 10, 10)); // # buttons, # columns, spacing

        //Stuff
        DoMath doMath = new DoMath();
        SortingUtils sortingUtils = new SortingUtils();

        // Display buttons
        createButton("Do Addition", e -> {
            try {
                textArea.setText(" "+(doMath.Addition(10,2)));
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Do Subtraction", e -> {
            try {
                textArea.setText(" "+(doMath.Subtraction(10,2)));
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Do Multiplication", e -> {
            try {
                textArea.setText(" "+(doMath.Multiplication(10,2)));
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Do Division", e -> {
            try {
                textArea.setText(" "+(doMath.Division(10,2)));
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Divide by 0!", e -> {
            try {
                textArea.setText(" "+(doMath.Division(10,0)));
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
            }
        }, buttonPanel);

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Charlie");
        names.add("Bob");
        names.add("Eve");

        createButton("Sort List", e -> {
            try {
                textArea.setText(
                        " Unsorted list: "+
                        names+
                        "\n"+
                        " Sorted list: "+
                        sortingUtils.sortList(names)
                );
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        createButton("Filtered List", e -> {
            try {
                textArea.setText(
                        " Unfiltered list: "+
                                numbers+
                                "\n"+
                                " Filtered list: "+
                                sortingUtils.filterList(numbers)
                );
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        Predicate<String> isEmpty = s -> s.isEmpty();
        String testString1 = "This is a test string";
        String testString2 = "";

        createButton("Test if empty ", e -> {
            try {
                textArea.setText(
                        " Is the string \"" +
                        testString1 +
                        "\" empty? " +
                        isEmpty.test(testString1)+
                        "\n"+
                        " the string \"" +
                        testString2 +
                        "\" empty? " +
                        isEmpty.test(testString2)
                );
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        Function<String, String> toUpperCase = s -> s.toUpperCase();

        createButton("UPPERCASE ", e -> {
            try {
                textArea.setText(
                        " Original string: \""+
                        testString1+
                        "\""+
                        "\n"+
                        " Modified string: \""+
                        toUpperCase.apply(testString1)+
                        "\""
                );
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        CustomFunctional customFunctional = new CustomFunctional();
        String testString3 = " that was merged with another test string";

        createButton("Concatenate Strings ", e -> {
            try {
                textArea.setText(" String 1: \""+
                        testString1+
                        "\""+
                        "\n"+
                        " String 2: \""+
                        testString3+
                        "\""+
                        "\n"+
                        " Merged Strings: \""+
                        customFunctional.concatenate(testString1,testString3)+
                        "\""
                );
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Measure length ", e -> {
            try {
                textArea.setText(" String 1: \""+
                        testString1+
                        "\""+
                        "\n"+
                        " String 2: \""+
                        testString3+
                        "\""+
                        "\n"+
                        " Longest string: \""+
                        customFunctional.length(testString1,testString3)+
                        "\""
                );
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
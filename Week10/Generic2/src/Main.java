
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main extends JFrame {
    Integer value = 0;
    String word = "Hello";

    // Constructor for the main frame
    public Main() {
        setTitle("AD 300 Component Software"); // Set the title of the frame
        setSize(500, 500); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(15, 1, 10, 10)); // # buttons, # columns, spacing

        //custom inputs
        ArrayList<Pair<Integer, String>> stringPair = new ArrayList<>();
        // Create and add Pair objects
        stringPair.add(new Pair<>(1, "Bulbasaur"));
        stringPair.add(new Pair<>(2, "Ivysaur"));
        stringPair.add(new Pair<>(3, "Venusaur"));
        stringPair.add(new Pair<>(4, "Charmander"));
        stringPair.add(new Pair<>(5, "Charmeleon"));
        stringPair.add(new Pair<>(6, "Charizard"));
        stringPair.add(new Pair<>(7, "Squirtle"));
        stringPair.add(new Pair<>(8, "Wartortle"));
        stringPair.add(new Pair<>(9, "Blastoise"));

        ArrayList<Pair<Integer, Double>> intDoublePair = new ArrayList<>();
        // Add Pair<Integer, Double> objects
        intDoublePair.add(new Pair<>(1, 10.5));
        intDoublePair.add(new Pair<>(2, 20.75));
        intDoublePair.add(new Pair<>(3, 30.25));
        intDoublePair.add(new Pair<>(4, 40.0));
        intDoublePair.add(new Pair<>(5, 50.5));

        Stack<Integer> stackInteger = new Stack<>(new ArrayList<>());
        Stack<String> stackString = new Stack<>(new ArrayList<>());

        List<String> stringList = List.of("apple", "banana", "cherry");
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);

        Cache<Number> numberCache = new Cache<>();
        numberCache.add("one", 1);
        numberCache.add("two", 2.0);

        Cache<Integer> intCache = new Cache<>();
        intCache.add("three", 3);
        intCache.add("four", 4);

        // Display buttons
        createButton("Print String", e -> {
            try {
                textArea.setText(" "+stringPair);
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Print Double", e -> {
            try {
                textArea.setText(" "+intDoublePair);
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Check INT Stack", e -> {
            try {
                if (stackInteger.isEmpty()){
                    textArea.setText(" Stack is empty");
                } else {
                    textArea.setText(" Stack is not empty");
                }

            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Add INT to Stack", e -> {
            try {
                stackInteger.push(value);
                textArea.setText(" Added "+value+" to stack");
                value += 1;

            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Remove INT from Stack", e -> {
            try {
                stackInteger.pop();
                value -= 1;
                textArea.setText(" Removed "+value+" from stack");

            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Show INT Stack", e -> {
            try {
                textArea.setText(" "+stackInteger.printStack().toString());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Check STR Stack", e -> {
            try {
                if (stackString.isEmpty()){
                    textArea.setText(" Stack is empty");
                } else {
                    textArea.setText(" Stack is not empty");
                }

            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Add STR to Stack", e -> {
            try {
                stackString.push(word);
                textArea.setText(" Added String to stack");
                word = "World";
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Remove STR from Stack", e -> {
            try {
                stackString.pop();
                textArea.setText(" Removed integer to stack");
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Show STR Stack", e -> {
            try {
                textArea.setText(" "+stackString.printStack().toString());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Print CollectionUtils", e -> {
            try {
                textArea.setText(" "+CollectionUtils.printCollection(stringList));
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Show sum of list", e -> {
            try {
                double sum = CollectionUtils.sumOfNumberList(integerList);
                textArea.setText(" "+sum);
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("List number in number cache", e -> {
            try {
                textArea.setText(" "+numberCache.size());
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Merge int and number cache", e -> {
            try {
                numberCache.addAll(intCache);
                textArea.setText(" intCache added to numberCache");
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("clear number cache", e -> {
            try {
                numberCache.clear();
                textArea.setText(" numberCache cleared");
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
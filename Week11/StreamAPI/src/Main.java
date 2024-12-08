
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.stream.Collectors;
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
        buttonPanel.setLayout(new GridLayout(9, 1, 10, 10)); // # buttons, # columns, spacing

        //Variables
        List<Integer> intList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            intList.add(i);
        }

        List<Integer> oddNumbers = intList.stream()
                .filter(number -> number % 2 == 1)
                .toList();

        List<Integer> filterNumbers = intList.stream()
                .map(number -> number * number)
                .toList(); //.collect(Collectors.toList());

        List<Integer> filterOddNumbers = intList.stream()
                .filter(number -> number % 2 == 1)
                .map(number -> number * number)
                .toList(); //.collect(Collectors.toList());

        Integer reduceNumbers = intList.stream()
                .reduce(0, Integer::sum);

        List<Integer> evenNumbers = intList.stream()
                .filter(number -> number % 2 == 0)
                .toList(); //.collect(Collectors.toList());

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream) // Flatten each list into a single stream
                .toList(); //.collect(Collectors.toList());

        Map<String, List<Integer>> groupedByEvenOdd = intList.stream()
                .collect(Collectors.groupingBy(
                        num -> num % 2 == 0 ? "Even" : "Odd"
                ));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Fred", 30));
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 40));
        persons.add(new Person("Carol", 35));
        persons.add(new Person("David", 15));
        persons.add(new Person("Eve", 28));
        persons.add(new Person("Grace", 45));
        persons.add(new Person("Hank", 32));
        persons.add(new Person("Ivy", 22));
        persons.add(new Person("Jack", 27));

        List<String> filterPersons = persons.stream()
                .filter(person -> person.getAge() > 25 )
                .map(person -> person.getName() +":"+  person.getAge())
                .toList(); //.collect(Collectors.toList());

        Optional<Person> oldestPersons = persons.stream()
                .max((person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()));


        // Display buttons
        createButton("Display odd numbers", e -> {
            try {
                textArea.setText(" "+oddNumbers);
            } catch (Exception err) {
                System.out.println("Error: " +err.getMessage());
            }
        }, buttonPanel);

        createButton("Display squared numbers", e -> {
            try {
                textArea.setText(" "+filterNumbers);
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
            }
        }, buttonPanel);

        createButton("Display odd & squared numbers", e -> {
            try {
                textArea.setText(" "+filterOddNumbers);
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
            }
        }, buttonPanel);

        createButton("Display sum of numbers", e -> {
            try {
                textArea.setText(" "+reduceNumbers);
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
            }
        }, buttonPanel);

        createButton("Display even numbers", e -> {
            try {
                textArea.setText(" "+evenNumbers);
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
            }
        }, buttonPanel);

        createButton("Display grouped numbers", e -> {
            try {
                textArea.setText(" "+groupedByEvenOdd);
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
            }
        }, buttonPanel);

        createButton("Display flattened list of numbers", e -> {
            try {
                textArea.setText(" "+flattenedList);
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
            }
        }, buttonPanel);

        createButton("Display >25 persons", e -> {
            try {
                textArea.setText(" "+filterPersons);
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
            }
        }, buttonPanel);

        createButton("Display oldest persons", e -> {
            try {
                oldestPersons.ifPresent( person -> textArea.setText(" "+person.getName()+":"+person.getAge()));
            } catch (Exception err) {
                System.out.println("Error: " + err.getMessage());
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


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {


        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Sophia Adams", 3.2));
        studentList.add(new Student(2, "Liam Mitchell", 2.8));
        studentList.add(new Student(3, "Olivia Carter", 3.9));
        studentList.add(new Student(4, "Ethan Hayes", 3.4));
        studentList.add(new Student(5, "Ava Brooks", 2.7));
        studentList.add(new Student(6, "Mason Clark", 3.5));
        studentList.add(new Student(7, "Isabella King", 2.3));
        studentList.add(new Student(8, "Noah Walker", 3.8));
        studentList.add(new Student(9, "Amelia Scott", 2.5));
        studentList.add(new Student(10, "Lucas Turner", 4.0));
        studentList.add(new Student(11, "Chloe Evans", 2.9));
        studentList.add(new Student(12, "James Lewis", 3.1));
        studentList.add(new Student(13, "Mia Collins", 2.4));
        studentList.add(new Student(14, "Benjamin Morris", 3.7));
        studentList.add(new Student(15, "Harper Wright", 2.6));
        studentList.add(new Student(16, "Alexander Perez", 3.3));
        studentList.add(new Student(17, "Zoe Green", 2.2));
        studentList.add(new Student(18, "Jack Robinson", 3.9));
        studentList.add(new Student(19, "Lily Clark", 3.0));
        studentList.add(new Student(20, "Daniel Young", 3.4));
        studentList.add(new Student(21, "Ella Allen", 3.8));
        studentList.add(new Student(22, "Samuel Harris", 2.7));
        studentList.add(new Student(23, "Emily Baker", 3.5));
        studentList.add(new Student(24, "Henry Moore", 2.3));
        studentList.add(new Student(25, "Charlotte Nelson", 3.6));


        setTitle("AD 300 Component Software"); // Set the title of the frame
        setSize(750, 500); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // # buttons, # columns, spacing

        final boolean[] reverseID = {false};
        final boolean[] reverseName = {false};
        final boolean[] reverseGPA = {false};

        // Display Button
        createButton("Compare ID", e -> {
            try {
                textArea.setText("");
                // Sort by ID
                studentList.sort(new Student.compareID());

                // Reverse the list if reverseGPA is true
                if (reverseGPA[0]) {
                    Collections.reverse(studentList);
                }

                // Toggle the reverseGPA flag for the next click
                reverseGPA[0] = !reverseGPA[0];

                // Display sorted (and possibly reversed) student list
                for (Student student : studentList) {
                    textArea.append("ID #" + student.getID() + "\nName: " + student.getName() + "\nGPA: " + student.getGPA() + "\n-------------------------\n");
                }
            } catch (Exception err) {
                System.out.println("An error occurred: " + err.getMessage());
            }
        }, buttonPanel);

        createButton("Compare Name", e -> {
            try {
                textArea.setText("");
                studentList.sort(new Student.compareName());

                // Reverse the list if reverseGPA is true
                if (reverseName[0]) {
                    Collections.reverse(studentList);
                }

                // Toggle the reverseGPA flag for the next click
                reverseName[0] = !reverseName[0];


                for (Student student : studentList) {
                    textArea.append(" ID #" + student.getID() + "\n Name: " + student.getName() + " GPA: " + student.getGPA() + "\n"+"-------------------------"+"\n");
                }
            } catch (Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        createButton("Compare GPA", e -> {
            try {
                textArea.setText("");
                studentList.sort(new Student.compareGPA());

                // Reverse the list if reverseGPA is true
                if (reverseGPA[0]) {
                    Collections.reverse(studentList);
                }

                // Toggle the reverseGPA flag for the next click
                reverseGPA[0] = !reverseGPA[0];

                for (Student student : studentList) {
                    textArea.append(" ID #" + student.getID() + "\n Name: " + student.getName() + " GPA: " + student.getGPA() + "\n"+"-------------------------"+"\n");
                }
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
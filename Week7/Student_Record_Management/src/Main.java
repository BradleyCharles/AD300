import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    double gpa = 4.0;
    JLabel gpaLabel;

    // Constructor for the main frame
    public Main() {

        setTitle("School Management System");
        setSize(750, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(13, 1, 10, 10)); // # buttons, # columns, spacing
        JPanel idPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel addNamePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel studentRemovePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel greaterGpaPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        JTextField studentIdField = new JTextField();
        JTextField studentNameField = new JTextField();
        JTextField studentRemoveField = new JTextField();
        JTextField greaterGpaField = new JTextField();

        buttonPanel.add(new JLabel("Update Student GPA"));

        // Student ID Field
        idPanel.add(new JLabel("Student ID:"));
        idPanel.add(studentIdField);
        buttonPanel.add(idPanel);

        // GPA Label
        idPanel.add(new JLabel("GPA:"));
        gpaLabel = new JLabel(String.format("%.1f", gpa));
        idPanel.add(gpaLabel);

        Record_Manager manager = new Record_Manager();
        manager.addStudent("Alice", 3.8);
        manager.addStudent("Bob", 3.5);

        // Generate GPA Button
        createButton("Generate GPA", e -> {
            try {
                randomGpa();
                gpaLabel.setText(String.format("%.1f", gpa)); // Update GPA label
            } catch(Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        // Update Student GPA Button
        createButton("Update Student GPA", e -> {
            try {
                if (studentIdField.getText().equals("")){
                    textArea.setText("Student ID cannot be blank");

                } else {
                    manager.replaceGpa(Integer.parseInt(studentIdField.getText()), gpa);
                    textArea.setText("Student ID: #" + studentIdField.getText() + " has been updated");
                }
            } catch(Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        // GPA Label
        buttonPanel.add(new JLabel("Add / Remove Students"));

        // Student ID Field
        addNamePanel.add(new JLabel("Student Name:"));
        addNamePanel.add(studentNameField);
        buttonPanel.add(addNamePanel);

        // Add Student Button
        createButton("Add Student", e -> {
            try {
                if (studentNameField.getText().equals("")){
                    textArea.setText("Student name cannot be blank");
                } else {
                    manager.addStudent(studentNameField.getText(), gpa);
                    textArea.setText(studentNameField.getText() +  " has been added to students.");
                }
            } catch(Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

// Student ID Field
        studentRemovePanel.add(new JLabel("Student ID:"));
        studentRemovePanel.add(studentRemoveField);
        buttonPanel.add(studentRemovePanel);

        // Remove Student Button
        createButton("Remove Student", e -> {
            try {
                if (studentRemoveField.getText().equals("")){
                    textArea.setText("Student ID cannot be blank");
                } else {
                        manager.removeStudent(Integer.parseInt(studentRemoveField.getText()));
                        textArea.setText("Student ID #" + studentRemoveField.getText() +  " has been removed from students.");
                }
            } catch(Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        buttonPanel.add(new JLabel("Display Students"));

        // Display higher GPA
        greaterGpaPanel.add(new JLabel("Display GPA >"));
        greaterGpaPanel.add(greaterGpaField);
        buttonPanel.add(greaterGpaPanel);

        // Remove Student Button
        createButton("Display greater than", e -> {
            try {
                if (greaterGpaField.getText().equals("")){
                    textArea.setText("GPA cannot be blank");
                } else {
                    textArea.setText(manager.getGreaterStudentsAsString(Double.parseDouble(greaterGpaField.getText())));
                }
            } catch(Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        // Display All Students Button
        createButton("Display All Students", e -> {
            try {
                // Set text area content with all students' information
                textArea.setText(manager.getAllStudentsAsString());
            } catch(Exception err) {
                System.out.println("An error occurred.");
            }
        }, buttonPanel);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.EAST);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public void randomGpa() {
        gpa = 4.0 * Math.random();
    }

    private void createButton(String label, ActionListener listener, JPanel panel) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }
}

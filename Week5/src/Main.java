import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    // Constructor for the main frame
    public Main() {
        setTitle("Media Player Tester"); // Set the title of the frame
        setSize(750, 400); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10)); // # buttons, # columns, spacing
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField studentNameField = new JTextField();
        JComboBox<String> departmentComboBox = new JComboBox<>();

        inputPanel.add(new JLabel("Student Name:"));
        inputPanel.add(studentNameField);
        buttonPanel.add(inputPanel);

        createButton("Add Student", e -> {
            String studentName = studentNameField.getText();
            String selectedDepartment = (String) departmentComboBox.getSelectedItem();
            if (!studentName.isEmpty() && selectedDepartment != null) {
                // Add student to the selected department
                textArea.append("Added student " + studentName + " to " + selectedDepartment + "\n");
                studentNameField.setText("");
            }
        }, buttonPanel);



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

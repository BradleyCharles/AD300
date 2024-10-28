import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField studentNameField = new JTextField();
        JComboBox<String> departmentComboBox = new JComboBox<>();

        // Student Name Field
        inputPanel.add(new JLabel("Student Name:"));
        inputPanel.add(studentNameField);
        buttonPanel.add(inputPanel);

        // Create school, departments, teachers, and students
        School school = new School("Great School", new ArrayList<>());
        Department department_Math = new Department("Math", new ArrayList<>(), new ArrayList<>());
        Department department_Science = new Department("Science", new ArrayList<>(), new ArrayList<>());
        Department department_Art = new Department("Art", new ArrayList<>(), new ArrayList<>());
        Teacher teacher_Math = new Teacher("Mr. Smith", "Math");
        Teacher teacher_Science = new Teacher("Mrs. Johnson", "Science");
        Teacher teacher_Art = new Teacher("Ms. Lee", "Art");
        Student student_Math = new Student("John Doe", "A");
        Student student_Science = new Student("Jane Doe", "B");
        Student student_Art = new Student("Jim Beam", "B+");

        // Add teachers and students to departments
        department_Math.addTeacher(teacher_Math);
        department_Math.addStudent(student_Math);
        department_Science.addTeacher(teacher_Science);
        department_Science.addStudent(student_Science);
        department_Art.addTeacher(teacher_Art);
        department_Art.addStudent(student_Art);
        school.addDepartment(department_Math);
        school.addDepartment(department_Science);
        school.addDepartment(department_Art);

        // Department Combo Box
        departmentComboBox.addItem("Math");
        departmentComboBox.addItem("Science"); 
        departmentComboBox.addItem("Art");
        inputPanel.add(new JLabel("Department:"));
        inputPanel.add(departmentComboBox);
        
        // Teacher Combo Box
        JComboBox<String> teacherComboBox = new JComboBox<>();
        inputPanel.add(new JLabel("Teacher:"));
        inputPanel.add(teacherComboBox);

        // Update teacher combo box when department changes
        departmentComboBox.addActionListener(e -> {
            teacherComboBox.removeAllItems();
            String selectedDepartment = (String) departmentComboBox.getSelectedItem();
            for (Department dept : school.listDepartments()) {
                if (selectedDepartment.equals(dept.listTeachers().get(0).getSubject())) {
                    for (Teacher teacher : dept.listTeachers()) {
                        teacherComboBox.addItem(teacher.getName());
                    }
                }
            }
        });

        // Grade Combo Box
        JComboBox<String> gradeComboBox = new JComboBox<>();
        gradeComboBox.addItem("A");
        gradeComboBox.addItem("B");
        gradeComboBox.addItem("C"); 
        gradeComboBox.addItem("D");
        gradeComboBox.addItem("F");
        inputPanel.add(new JLabel("Grade:"));
        inputPanel.add(gradeComboBox);

        // Trigger initial teacher population
        departmentComboBox.setSelectedIndex(0);

        // Add Student Button
        createButton("Add Student", e -> {
            String studentName = studentNameField.getText();
            String selectedDepartment = (String) departmentComboBox.getSelectedItem();
            if (!studentName.isEmpty() && selectedDepartment != null) {
                Student newStudent = new Student(studentName, (String) gradeComboBox.getSelectedItem());
                for (Department dept : school.listDepartments()) {
                    if (selectedDepartment.equals("Math") && dept.listTeachers().get(0).getSubject().equals("Math")) {
                        dept.addStudent(newStudent);
                        textArea.append("Added student " + studentName + " to Math Department under " + dept.listTeachers().get(0).getName() + "\n");
                    } else if (selectedDepartment.equals("Science") && dept.listTeachers().get(0).getSubject().equals("Science")) {
                        dept.addStudent(newStudent);
                        textArea.append("Added student " + studentName + " to Science Department under " + dept.listTeachers().get(0).getName() + "\n");
                    } else if (selectedDepartment.equals("Art") && dept.listTeachers().get(0).getSubject().equals("Art")) {
                        dept.addStudent(newStudent);
                        textArea.append("Added student " + studentName + " to Art Department under " + dept.listTeachers().get(0).getName() + "\n");
                    }
                }
                studentNameField.setText("");
            }
        }, buttonPanel);

        // Display Students Button
        createButton("Display Students", e -> {
            String selectedTeacher = (String) teacherComboBox.getSelectedItem();
            String selectedDepartment = (String) departmentComboBox.getSelectedItem();
            
            if (selectedTeacher != null && selectedDepartment != null) {
                textArea.append("\nStudents assigned to " + selectedTeacher + ":\n");
                for (Department dept : school.listDepartments()) {
                    if (selectedDepartment.equals(dept.listTeachers().get(0).getSubject())) {
                        java.util.List<Student> students = dept.listStudents();
                        if (students.isEmpty()) {
                            textArea.append("No students currently assigned\n");
                        } else {
                            for (Student student : students) {
                                textArea.append("- " + student.getName() + " (Grade: " + student.getGrade() + ")\n");
                            }
                        }
                        break;
                    }
                }
                textArea.append("\n");
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
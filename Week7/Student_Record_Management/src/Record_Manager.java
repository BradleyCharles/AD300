import java.util.TreeMap;

public class Record_Manager {

    private final TreeMap<Integer, Student> records = new TreeMap<>();

    public void addStudent(String name, double gpa) {
        Student student = new Student(name, gpa);
        records.put(student.getId(), student);
    }

    public void removeStudent(int id) {
        records.remove(id);
    }

    public void replaceGpa(int id, double gpa) {
        Student student = records.get(id); // Retrieve the existing student
        if (student != null) {
            // Create a new Student with the updated GPA
            Student updatedStudent = new Student(student.getName(), gpa);
            updatedStudent.setId(id);
            records.put(id, updatedStudent); // Replace the old student with the updated one
        }
    }

    // Method to get all students with gpa greater than given value a formatted string
    public String getGreaterStudentsAsString(double gpa) {
        if (records.isEmpty()) {
            return "No students found.";
        }
        StringBuilder sb = new StringBuilder("Students with GPA greater than " + gpa + ":\n");
        for (Student student : records.values()) {
            if (student.getGpa() > gpa) { // Only include students with GPA greater than the specified value
                sb.append(student).append("\n");
            }
        }
        if (sb.length() == 0) {
            return "No students with GPA greater than " + gpa + ".";
        }
        return sb.toString();
    }

    // Method to get all students as a formatted string
    public String getAllStudentsAsString() {
        if (records.isEmpty()) {
            return "No students found.";
        }
        StringBuilder sb = new StringBuilder("Student Records:\n");
        for (Student student : records.values()) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }
}

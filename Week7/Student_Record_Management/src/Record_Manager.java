import java.util.TreeMap;

public class Record_Manager {

    private final TreeMap<Integer, Student> records = new TreeMap<>();

    public void addStudent(String name, double gpa) {
        Student student = new Student(name, gpa);
        records.put(student.getId(), student);
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

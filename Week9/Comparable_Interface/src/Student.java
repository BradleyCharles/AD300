import java.util.Comparator;

public class Student {
    private int studentID;
    private String studentName;
    private double studentGPA;

    public Student(int studentID, String studentName, double studentGPA) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentGPA = studentGPA;
    }

    public int getID () {
        return studentID;
    }

    public String getName () {
        return studentName;
    }

    public double getGPA () {
        return studentGPA;
    }

    public static class compareID implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.getID() - s2.getID();
        }
    }

    public static class compareName implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }

    public static class compareGPA implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return Double.compare(s1.getGPA(),s2.getGPA());
        }
    }













}
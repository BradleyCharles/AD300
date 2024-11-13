public class Student {
    private static int nextId = 1; // Generates unique IDs
    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(String name, double gpa) {
        this.id = nextId++;
        this.name = name;
        this.gpa = gpa;
    }

    //Setter / Getter for id
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    //Setter / Getter for name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //Setter / Getter for pga
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}
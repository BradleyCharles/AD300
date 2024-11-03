public class Student {
  private String name;
  private String grade;

  // Constructor
  public Student(String name, String grade) {
    this.name = name;
    this.grade = grade;
  }

  // Get student name
  public String getName() {
    return this.name;
  }

  // Get student grade
  public String getGrade() {
    return this.grade;
  }
}
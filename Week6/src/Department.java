import java.util.ArrayList;
import java.util.List;

public class Department {
  private List<Teacher> teacher;
  private List<Student> student;

  // Constructor
  public Department(String name,List<Teacher> teacher, List<Student> student) {
    this.teacher = new ArrayList<>();
    this.student = new ArrayList<>();
  }

  // Add teacher to department
  public void addTeacher(Teacher teacher) {
    this.teacher.add(teacher);
  }

  // Add student to department
  public void addStudent(Student student) {
    this.student.add(student);
  }

  // List teachers in department
  public List<Teacher> listTeachers() {
    return this.teacher;
  }

  // List students in department
  public List<Student> listStudents() {
    return this.student;
  }
}
import java.util.ArrayList;
import java.util.List;

public class Department {
  private List<Teacher> teacher;
  private List<Student> student;

  public Department(List<Teacher> teacher, List<Student> student) {
    this.teacher = new ArrayList<>();
    this.student = new ArrayList<>();
  }

  public void addTeacher(Teacher teacher) {
    this.teacher.add(teacher);
  }

  public void addStudent(Student student) {
    this.student.add(student);
  }

  public List<Teacher> listTeachers() {
    return this.teacher;
  }

  public List<Student> listStudents() {
    return this.student;
  }
}

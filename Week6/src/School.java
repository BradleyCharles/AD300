import java.util.ArrayList;
import java.util.List;

public class School {
  private String name;
  private List<Department> department;

  // Constructor
  public School(String name, List<Department> department) {
    this.name = name;
    this.department = new ArrayList<>(); 
  }

  // Add department to school
  public void addDepartment(Department department) {
    this.department.add(department);
  }

  // List departments in school
  public List<Department> listDepartments() {
    return this.department;
  }

  // Get school name
  public String getName() {
    return this.name;
  }
}
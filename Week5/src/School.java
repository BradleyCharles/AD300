import java.util.ArrayList;
import java.util.List;

public class School {
  private String name;
  private List<Department> department;

  public School(String name) {
    this.name = name;
    this.department = new ArrayList<>(); 
  }

  public void addDepartment(Department department) {
    this.department.add(department);
  }

  public List<Department> listDepartments() {
    return this.department;
  }

  public String getName() {
    return this.name;
  }
}
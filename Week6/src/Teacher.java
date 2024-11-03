public class Teacher {
  private String name;
  private String subject;

  // Constructor
  public Teacher(String name, String subject) {
    this.name = name;
    this.subject = subject;
  }

  // Get teacher name
  public String getName() {
    return this.name;
  }

  // Get teacher subject
  public String getSubject() {
    return this.subject;
  }

}
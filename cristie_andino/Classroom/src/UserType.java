public class UserType {
  private int id;
  private String username;
  private String password;
  private String name;
  private String role;

  public UserType(int id, String name, String username, String role) {
    this.id = id;
    this.username = username;
    this.name = name;
    this.role = role;
  }

  public UserType(String name, String username,String password, String role) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  // getters and setters
  public int getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public String getName() {
    return this.name;
  }

  public String getRole() {
    return role.toLowerCase();
  }

  public boolean isAdmin() {
    return role.equalsIgnoreCase("admin");
  }

  public boolean isStudent() {
    return role.equalsIgnoreCase("student");
  }

  public boolean isTeacher() {
    return role.equalsIgnoreCase("teacher");
  }
  
}

public class Student  extends User {
  public Student(Database db, UserType user){
    super(db, user);
    setTitle("Student Panel");
    frame.pack();
    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

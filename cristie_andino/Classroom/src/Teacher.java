import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Teacher extends User {
  public Teacher(Database db, UserType user){
    super(db, user);
    setTitle("Teacher Panel");

    // add addStudent menu item
    JMenuItem addStudent = new JMenuItem("Add Student");
    addStudent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addStudent(db);
      }
    });
    menu.add(addStudent);


    frame.pack();
    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
  public static void addStudent(Database db){
    // JFrame registration form for new student
    JFrame add = new JFrame("Add Student");
    add.setSize(400, 400);
    add.setLayout(new GridLayout(5, 2));
    add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    add.setLocationRelativeTo(null);
    add.setVisible(true);

    // Labels name, username, password, and confirm password
    JLabel nameLabel = new JLabel("Name: ");
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");

    // Text fields for name, username, password, and confirm password
    JTextField nameField = new JTextField();
    JTextField usernameField = new JTextField();
    
    // password field
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();

    // Buttons for adding student
    JButton addStudentButton = new JButton("Add Student");

    // Add components to frame
    add.add(nameLabel);
    add.add(nameField);
    add.add(usernameLabel);
    add.add(usernameField);
    add.add(passwordLabel);
    add.add(passwordField);
    add.add(confirmPasswordLabel);
    add.add(confirmPasswordField);
    add.add(addStudentButton);

    // Add action listener to add student button
    addStudentButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        // Get text from text fields
        String name = nameField.getText();
        String username = usernameField.getText();
        @SuppressWarnings("deprecation")
        String password = passwordField.getText();
        @SuppressWarnings("deprecation")
        String confirmPassword = confirmPasswordField.getText();

        // check if empty
        if(name.equals("") || username.equals("") || password.equals("") || confirmPassword.equals("")){
          JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else if(password.equals(confirmPassword)){  // Check if passwords match
          // Add student to database
          UserType user = new UserType(name, username, password, "student");
          db.addUser(user);
          // Close frame
          add.dispose();
        }
        else{
          JOptionPane.showMessageDialog(null, "Passwords do not match");
        }
      }
    });

    // revalidate
    add.revalidate();
  }
}

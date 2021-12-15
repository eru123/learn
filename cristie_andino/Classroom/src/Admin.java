import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Admin extends User {
  public Admin(Database db, UserType user){
    super(db, user);
    setTitle("Admin Panel");
    
    // add teacher menu item
    JMenuItem addTeacher = new JMenuItem("Add Teacher");
    addTeacher.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addTeacher(db);
      }
    });

    // add student menu item
    JMenuItem addStudent = new JMenuItem("Add Student");
    addStudent.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Teacher.addStudent(db);
      }
    });

    // Reset database menu item
    JMenuItem resetDatabase = new JMenuItem("Reset Database");
    resetDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        db.reset();
      }
    });

    menu.add(addTeacher);
    menu.add(addStudent);
    menu.add(resetDatabase);
    
    // create tab panel
    JTabbedPane tabbedPane = new JTabbedPane();

    // create teacher list panel
    JPanel teacherListPanel = new JPanel();
    teacherListPanel.setLayout(new BoxLayout(teacherListPanel, BoxLayout.Y_AXIS));

    // create teacher listbox
    ArrayList<UserType> teacherList = db.getAllUser("teacher");
    String[] teacherInfo = new String[teacherList.size()];
    for (int i = 0; i < teacherList.size(); i++){
      teacherInfo[i] = String.format("%25s %s", teacherList.get(i).getName(), teacherList.get(i).getUsername());
    }
    JList teacherListBox = new JList(teacherInfo);
    teacherListBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    teacherListBox.setLayoutOrientation(JList.VERTICAL);
    teacherListBox.setVisibleRowCount(-1);

    // create student list panel
    JPanel studentListPanel = new JPanel();
    studentListPanel.setLayout(new BoxLayout(studentListPanel, BoxLayout.Y_AXIS));

    // add panels to tabbed pane
    tabbedPane.addTab("Teachers", teacherListPanel);
    tabbedPane.addTab("Students", studentListPanel);

    // add tabbed pane to frame
    frame.add(tabbedPane);

    frame.pack();
    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
  }

  static void addTeacher(Database db){

    // JFrame registration form for new teacher
    JFrame add = new JFrame("Add Teacher");
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

          // Add teacher to database
          UserType user = new UserType(name, username, password, "teacher");
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

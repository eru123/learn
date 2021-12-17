import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Admin extends User {
  private UserType selectedTeacher = null;
  private UserType selectedStudent = null;
  private JList<String> teacherList = null;
  private JList<String> studentList = null;
  private Database db;

  public Admin(Database db, UserType user) {
    super(db, user);
    this.db = db;

    setTitle("Admin Panel");

    // add teacher menu item
    JMenuItem addTeacher = new JMenuItem("Add Teacher");
    addTeacher.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addTeacher(db);
        updateTeachersList();
      }
    });

    // add student menu item
    JMenuItem addStudent = new JMenuItem("Add Student");
    addStudent.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Teacher.addStudent(db);
        updateStudentsList();
      }
    });

    // Reset database menu item
    JMenuItem resetDatabase = new JMenuItem("Reset Database");
    resetDatabase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        db.reset();
        updateTeachersList();
        updateStudentsList();
      }
    });

    // Delete selected teacher menu item
    JMenuItem deleteTeacher = new JMenuItem("Delete selected Teacher");
    deleteTeacher.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteSelectedTeacher();
      }
    });

    // Delete selected student menu item
    JMenuItem deleteStudent = new JMenuItem("Delete selected Student");
    deleteStudent.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteSelectedStudent();
      }
    });

    // Refresh menu item
    JMenuItem refresh = new JMenuItem("Refresh");
    refresh.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateTeachersList();
        updateStudentsList();
      }
    });

    menu.add(addTeacher);
    menu.add(addStudent);
    menu.add(deleteTeacher);
    menu.add(deleteStudent);
    menu.add(refresh);
    menu.add(resetDatabase);

    // create tab panel
    JTabbedPane tabbedPane = new JTabbedPane();

    // create teacher list panel
    JPanel teacherListPanel = new JPanel();
    teacherListPanel.setLayout(new BoxLayout(teacherListPanel, BoxLayout.Y_AXIS));

    // create teacher listbox
    updateTeachersList();
    teacherList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    teacherList.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          int index = teacherList.getSelectedIndex();
          if (index != -1) {
            selectedTeacher = selectTeacher(index);
          }
        }
      }
    });
    JScrollPane teacherListScrollPane = new JScrollPane(teacherList);
    teacherListScrollPane.setPreferredSize(new Dimension(200, 200));
    teacherListPanel.add(teacherListScrollPane);
    tabbedPane.addTab("Teachers", teacherListPanel);
    teacherListPanel.revalidate();

    // create students listbox
    updateStudentsList();
    studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    studentList.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          int index = studentList.getSelectedIndex();
          if (index != -1) {
            selectedStudent = selectStudent(index);
          }
        }
      }
    });
    JScrollPane studentListScrollPane = new JScrollPane(studentList);
    studentListScrollPane.setPreferredSize(new Dimension(200, 200));
    JPanel studentListPanel = new JPanel();
    studentListPanel.setLayout(new BoxLayout(studentListPanel, BoxLayout.Y_AXIS));
    studentListPanel.add(studentListScrollPane);
    tabbedPane.addTab("Students", studentListPanel);
    studentListPanel.revalidate();

    // add tabbed pane to frame
    frame.add(tabbedPane);

    frame.pack();
    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }

  static void addTeacher(Database db) {

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
    JButton addTeacherButton = new JButton("Add Teacher");

    // Add components to frame
    add.add(nameLabel);
    add.add(nameField);
    add.add(usernameLabel);
    add.add(usernameField);
    add.add(passwordLabel);
    add.add(passwordField);
    add.add(confirmPasswordLabel);
    add.add(confirmPasswordField);
    add.add(addTeacherButton);

    // Add action listener to add student button
    addTeacherButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        // Get text from text fields
        String name = nameField.getText();
        String username = usernameField.getText();
        @SuppressWarnings("deprecation")
        String password = passwordField.getText();
        @SuppressWarnings("deprecation")
        String confirmPassword = confirmPasswordField.getText();

        // check if empty
        if (name.equals("") || username.equals("") || password.equals("") || confirmPassword.equals("")) {
          JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else if (password.equals(confirmPassword)) { // Check if passwords match

          // Add teacher to database
          UserType user = new UserType(name, username, password, "teacher");
          db.addUser(user);

          // Close frame
          add.dispose();
        } else {
          JOptionPane.showMessageDialog(null, "Passwords do not match");
        }
      }
    });

    // revalidate
    add.revalidate();
  }

  public void deleteSelectedTeacher() {
    if (selectedTeacher != null) {
      // delete selected teacher
      db.deleteUser(selectedTeacher.getId());
      // update teacher list
      updateTeachersList();
      selectedTeacher = null;
    } else {
      JOptionPane.showMessageDialog(null, "Please select a teacher first", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void deleteSelectedStudent() {
    if (selectedStudent != null) {
      // delete selected student
      db.deleteUser(selectedStudent.getId());
      updateStudentsList();
      selectedStudent = null;
    } else {
      JOptionPane.showMessageDialog(null, "Please select a student first", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public UserType selectStudent(int index) {
    ArrayList<UserType> studentsAL = db.getAllUser("student");
    return studentsAL.get(index);
  }

  public UserType selectTeacher(int index) {
    ArrayList<UserType> teachersAL = db.getAllUser("teacher");
    return teachersAL.get(index);
  }

  public void updateTeachersList() {
    ArrayList<UserType> teachersAL = db.getAllUser("teacher");
    String[] teachers = new String[teachersAL.size()];
    for (int i = 0; i < teachersAL.size(); i++) {
      teachers[i] = teachersAL.get(i).getUsername() + " - " + teachersAL.get(i).getName();
    }
    if (teacherList != null) {
      teacherList.setListData(teachers);
    } else {
      teacherList = new JList<String>(teachers);
    }
  }

  public void updateStudentsList() {
    ArrayList<UserType> studentsAL = db.getAllUser("student");
    String[] students = new String[studentsAL.size()];
    for (int i = 0; i < studentsAL.size(); i++) {
      students[i] = studentsAL.get(i).getUsername() + " - " + studentsAL.get(i).getName();
    }
    if (studentList != null) {
      studentList.setListData(students);
    } else {
      studentList = new JList<String>(students);
    }
  }
}

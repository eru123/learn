import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Teacher extends User {
  private Database db;
  private UserType selectedStudent = null;
  private QuizType selectedQuiz = null;
  private JList<String> studentList = null;
  private JList<String> quizList = null;
  public Teacher(Database d, UserType user){
    super(d, user);
    db = d;
    setTitle("Teacher Panel");

    // add addStudent menu item
    JMenuItem addStudent = new JMenuItem("Add Student");
    addStudent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addStudent(db);
      }
    });

    // view scores menu item
    JMenuItem viewScores = new JMenuItem("View Scores");
    viewScores.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (selectedQuiz != null) {
          selectedQuiz.viewScores(db);
        } else {
          JOptionPane.showMessageDialog(null, "Please select a quiz first.");
        }
      }
    });

    // create quiz menu item
    JMenuItem createQuiz = new JMenuItem("Create Quiz");
    createQuiz.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new QuizType(db);
      }
    });

    // Delete selected student menu item
    JMenuItem deleteStudent = new JMenuItem("Delete selected Student");
    deleteStudent.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteSelectedStudent();
      }
    });

    // Delete Selected Quiz menu item
    JMenuItem deleteQuiz = new JMenuItem("Delete Selected Quiz");
    deleteQuiz.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteSelectedQuiz();
      }
    });

    // Refresh menu item
    JMenuItem refresh = new JMenuItem("Refresh");
    refresh.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateQuizList();
        updateStudentsList();
      }
    });
    

    menu.add(viewScores);
    menu.add(addStudent);
    menu.add(createQuiz);
    menu.add(deleteStudent);
    menu.add(deleteQuiz);
    menu.add(refresh);
    
    // create tabbed pane for students list, quizzes
    JTabbedPane tabbedPane = new JTabbedPane();

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

    // create quiz listbox 
    updateQuizList();
    quizList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    quizList.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          int index = quizList.getSelectedIndex();
          if (index != -1) {
            selectedQuiz = selectQuiz(index);
          }
        }
      }
    });
    JScrollPane quizListScrollPane = new JScrollPane(quizList);
    quizListScrollPane.setPreferredSize(new Dimension(200, 200));
    JPanel quizListPanel = new JPanel();
    quizListPanel.setLayout(new BoxLayout(quizListPanel, BoxLayout.Y_AXIS));
    quizListPanel.add(quizListScrollPane);
    tabbedPane.addTab("Quizzes", quizListPanel);
    quizListPanel.revalidate();

    frame.add(tabbedPane);
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

  public void updateStudentsList(){
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

  public void updateQuizList(){
    ArrayList<QuizType> quizzesAL = db.getAllQuiz();
    String[] quizzes = new String[quizzesAL.size()];
    for (int i = 0; i < quizzesAL.size(); i++) {
      quizzes[i] = quizzesAL.get(i).getName() + " - " + quizzesAL.get(i).getDescription();
    }
    if (quizList != null) {
      quizList.setListData(quizzes);
    } else {
      quizList = new JList<String>(quizzes);
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

  public void deleteSelectedQuiz() {
    if (selectedQuiz != null) {
      // delete selected quiz
      db.deleteQuiz(selectedQuiz.getId());
      updateQuizList();
      selectedQuiz = null;
    } else {
      JOptionPane.showMessageDialog(null, "Please select a quiz first", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public UserType selectStudent(int index) {
    ArrayList<UserType> studentsAL = db.getAllUser("student");
    return studentsAL.get(index);
  }

  public QuizType selectQuiz(int index) {
    ArrayList<QuizType> quizzesAL = db.getAllQuiz();
    return quizzesAL.get(index);
  }
}

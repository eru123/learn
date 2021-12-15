import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
  public boolean exited = false;

  public Login(Database db) {
    // create JFrame login form 
    JFrame login = new JFrame("Login");
    login.setSize(300, 200);
    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    login.setLocationRelativeTo(null);
    login.setLayout(new GridLayout(3, 2));
    login.setResizable(false);
    login.setVisible(true);
    // create JLabel username and password
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    // create JTextField username and password
    JTextField usernameText = new JTextField();
    JTextField passwordText = new JTextField();
    // create JButton login and cancel
    JButton loginButton = new JButton("Login");
    JButton cancelButton = new JButton("Cancel");
    // add JLabel username, JTextField username, JLabel password, JTextField password, JButton login, JButton cancel to login form
    login.add(username);
    login.add(usernameText);
    login.add(password);
    login.add(passwordText);
    login.add(loginButton);
    login.add(cancelButton);

    // revalidate 
    login.revalidate();

    // create action listener for login button
    loginButton.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {

        // if username and password is correct, show main form
        UserType user = db.login(usernameText.getText(), passwordText.getText());
        if (user != null) {
          login.dispose();
          if(user.getRole().equals("admin")) {
            new Admin(db, user);
          } else if (user.getRole().equals("teacher")) {
            new Teacher(db, user);
          } else if (user.getRole().equals("student")) {
            new Student(db, user);
          } else {
            JOptionPane.showMessageDialog(null, "Invalid user role");
          }
        }
        // if username or password is incorrect, show error message
        else {
          JOptionPane.showMessageDialog(null, "Username or password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        }
        passwordText.setText("");
      }
    });

    // create action listener for cancel button
    cancelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // if cancel button is clicked, close login form
        login.dispose();
      }
    });

  }
}

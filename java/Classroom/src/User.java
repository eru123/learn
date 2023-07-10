import javax.swing.*;

public abstract class User {
  private Database db;
  private UserType user;
  static JFrame frame;
  JMenu menu;
  JMenuBar menuBar;
  public User(Database db, UserType user){
    this.db = db;
    this.user = user;

    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    // Menu bar
    menuBar = new JMenuBar();
    menu = new JMenu("Menu");
    JMenuItem menuItem = new JMenuItem("Logout");
    menuItem.addActionListener(e -> {
      // db.logout();
      frame.dispose();
      new Login(this.db);
    });

    menu.add(menuItem);
    menuBar.add(menu);
    frame.setJMenuBar(menuBar);
  }
  
  void setTitle(String title){
    frame.setTitle(title + ": " + user.getName());
  }
}

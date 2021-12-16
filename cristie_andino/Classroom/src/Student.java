import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Student extends User {
  private Database db;
  private QuizType selectedQuiz = null;
  private JList quizList = null;

  public Student(Database d, UserType user) {
    super(d, user);
    db = d;
    setTitle("Student Panel");

    // take selected quiz menu item
    JMenuItem takeQuiz = new JMenuItem("Take Selected Quiz");
    takeQuiz.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (selectedQuiz != null) {
          new AnswerType(db, selectedQuiz.getId(), user.getId());
        } else {
          JOptionPane.showMessageDialog(null, "Please select a quiz first.");
        }
      }
    });

    menu.add(takeQuiz);

    frame.pack();
    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void updateQuizList() {
    ArrayList<QuizType> quizzesAL = db.getAllQuiz();
    String[] quizzes = new String[quizzesAL.size()];
    for (int i = 0; i < quizzesAL.size(); i++) {
      quizzes[i] = quizzesAL.get(i).getName();
    }
    if (quizList != null) {
      quizList.setListData(quizzes);
    } else {
      quizList = new JList(quizzes);
    }
  }

  public QuizType selectQuiz(int index) {
    ArrayList<QuizType> quizzesAL = db.getAllQuiz();
    return quizzesAL.get(index);
  }
}

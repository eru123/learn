import javax.swing.*;
import java.awt.event.*;

public class AnswerType {
  public int id;
  public int quiz_id;
  public int student_id;
  public int score;
  static int current;
  static JLabel questionLabel;
  static JRadioButton[] radioButtons;
  static ButtonGroup group;
  static JPanel panel;

  public AnswerType(int id, int quiz_id, int student_id, int score) {
    this.id = id;
    this.quiz_id = quiz_id;
    this.student_id = student_id;
    this.score = score;
  }

  public int getId() {
    return this.id;
  }

  public int getQuizId() {
    return this.quiz_id;
  }

  public int getStudentId() {
    return this.student_id;
  }

  public int getScore() {
    return this.score;
  }

  public String toStr(Database db) {
    UserType user = db.getUser(this.student_id);
    String res = user.getName() + " - " + this.score;


    return res;
  }

  public UserType getStudent(Database db) {
    return db.getUser(this.student_id);
  }

  public QuizType getQuiz(Database db) {
    return db.getQuiz(this.quiz_id);
  }

  public AnswerType(Database db, int quiz_id, int student_id) {
    this.quiz_id = quiz_id;
    this.student_id = student_id;
    UserType student = this.getStudent(db);
    QuizType quiz = this.getQuiz(db);

    if (quiz != null && student != null && student.getRole().equalsIgnoreCase("student")) {

      if (db.isQuizAnswered(student.getId(), quiz.getId())) {
        JOptionPane.showMessageDialog(null, "This student has already answered this quiz", "Error",
            JOptionPane.ERROR_MESSAGE);
      } else {
        AnswerType myAnswer = new AnswerType(0, quiz.getId(), student.getId(), 0);
        myAnswer.score = 0;

        current = 0;
        String question = quiz.questions.get(current).getQuestion();
        String answer = quiz.questions.get(current).getAnswer();
        String[] choices = quiz.questions.get(current).getChoices();

        // ask question
        // JFrame question form
        JFrame qframe = new JFrame("Question");
        qframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        qframe.setSize(400, 400);

        // create panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // create question label
        questionLabel = new JLabel(question);
        panel.add(questionLabel);

        String[] options = new String[choices.length + 1];
        options[0] = answer;
        for (int i = 0; i < choices.length; i++) {
          options[i + 1] = choices[i];
        }

        for (int i = options.length - 1; i > 0; i--) {
          int index = (int) (Math.random() * (i + 1));
          String temp = options[index];
          options[index] = options[i];
          options[i] = temp;
        }

        radioButtons = new JRadioButton[options.length];
        // set radio buttons to select one
        group = new ButtonGroup();
        for (int i = 0; i < options.length; i++) {
          radioButtons[i] = new JRadioButton(options[i]);
          group.add(radioButtons[i]);
          panel.add(radioButtons[i]);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            // get answer
            for (int i = 0; i < radioButtons.length; i++) {
              if (radioButtons[i].isSelected()) {
                if (radioButtons[i].getText().equals(answer)) {
                  JOptionPane.showMessageDialog(qframe, "Correct!");
                  myAnswer.score++;
                } else {
                  JOptionPane.showMessageDialog(qframe, "Incorrect!");
                }
              }
            }
            current++;
            if (current != quiz.questions.size()) {
              // reset panel to next question

              String question = quiz.questions.get(current).getQuestion();
              String answer = quiz.questions.get(current).getAnswer();
              String[] choices = quiz.questions.get(current).getChoices();

              qframe.remove(panel);

              panel = new JPanel();
              panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

              questionLabel = new JLabel(question);
              panel.add(questionLabel);

              String[] options = new String[choices.length + 1];
              options[0] = answer;
              for (int i = 0; i < choices.length; i++) {
                options[i + 1] = choices[i];
              }

              for (int i = options.length - 1; i > 0; i--) {
                int index = (int) (Math.random() * (i + 1));
                String temp = options[index];
                options[index] = options[i];
                options[i] = temp;
              }

              radioButtons = new JRadioButton[options.length];
              // set radio buttons to select one
              group = new ButtonGroup();
              for (int i = 0; i < options.length; i++) {
                radioButtons[i] = new JRadioButton(options[i]);
                group.add(radioButtons[i]);
                panel.add(radioButtons[i]);
              }

              panel.add(submitButton);

              qframe.add(panel);
              panel.revalidate();
            } else {
              submit(db, quiz, myAnswer);
              qframe.dispose();
            }
          }
        });

        panel.add(submitButton);

        qframe.add(panel);
        panel.revalidate();

        qframe.pack();
        qframe.setVisible(true);
        qframe.setLocationRelativeTo(null);
      }
    } else {
      JOptionPane.showMessageDialog(null, "You can't take this quiz", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void submit(Database db, QuizType quiz, AnswerType myAnswer) {
    db.addAnswer(myAnswer);
    JOptionPane.showMessageDialog(null, "Your score is " + myAnswer.score + " out of " + quiz.questions.size(),
        "Score", JOptionPane.INFORMATION_MESSAGE);
  }
}

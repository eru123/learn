import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class QuizType {
  int id;
  String name;
  String description;
  ArrayList<QuestionType> questions;

  public QuizType(int id, String name, String description, ArrayList<QuestionType> questions) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.questions = questions;
  }

  public QuizType(int id, String name, String description, String[][] questions) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.questions = new ArrayList<QuestionType>();
    for (int i = 0; i < questions.length; i++) {
      this.questions.add(new QuestionType(questions[i][0], questions[i][1], questions[i][2]));
    }
  }

  public QuizType(Database db) {
    // create JFRAME form for creating new quiz
    JFrame qframe = new JFrame("Create new Quiz");
    qframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    qframe.setSize(400, 400);
    qframe.setVisible(true);

    // create panel for form
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // create name label
    JLabel nameLabel = new JLabel("Name");
    panel.add(nameLabel);

    // create name text field
    JTextField nameTextField = new JTextField(20);
    panel.add(nameTextField);

    // create description label
    JLabel descriptionLabel = new JLabel("Description");
    panel.add(descriptionLabel);

    // create description text field
    JTextField descriptionTextField = new JTextField(20);
    panel.add(descriptionTextField);

    // create add question button
    JButton addQuestionButton = new JButton("Add Question");
    addQuestionButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (questions == null) {
          questions = new ArrayList<QuestionType>();
        }
    
        QuestionType q = new QuestionType();
        questions.add(q);
      }
    });

    // create submit button
    JButton submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        name = nameTextField.getText();
        description = descriptionTextField.getText();
        if (submit(db)) {
          qframe.dispose();
        } else {
          JOptionPane.showMessageDialog(qframe, "Quiz not created", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    // add components to panel
    panel.add(addQuestionButton);
    panel.add(submitButton);

    panel.revalidate();

    // add panel to qframe
    qframe.add(panel);
    qframe.pack();
    qframe.setVisible(true);
    qframe.setLocationRelativeTo(null);
  }

  public QuizType() {
    // blank constructor
  }
  private boolean submit(Database db) {
    System.out.println("Submitting quiz");
    QuizType quiz = new QuizType();
    quiz.name = name;
    quiz.description = description;
    quiz.questions = questions;
    return db.addQuiz(quiz);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String[][] getQuestions() {
    String[][] res = new String[this.questions.size()][3];
    for (int i = 0; i < this.questions.size(); i++) {
      res[i][0] = this.questions.get(i).getQuestion();
      res[i][1] = this.questions.get(i).getAnswer();
      res[i][2] = this.questions.get(i).getStringChoices();
    }
    return res;
  }

  public int take(){
    int score = 0;
    for (QuestionType q : questions) {
      score += q.ask() ? 1 : 0;
    }
    return score;
  }

  public void viewScores(Database db){
    ArrayList<AnswerType> answers = db.getAllAnswer(this.id);
    String[] answersArray = new String[answers.size()];
    for (int i = 0; i < answers.size(); i++) {
      answersArray[i] = answers.get(i).toString();
    }

    JFrame frame = new JFrame("Quiz Scores");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);

    // create panel for listbox
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // create listbox
    JList<String> listbox = new JList<String>(answersArray);
    listbox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listbox.setLayoutOrientation(JList.VERTICAL);
    listbox.setVisibleRowCount(-1);

    // create scrollpane for listbox
    JScrollPane scrollpane = new JScrollPane(listbox);
    scrollpane.setPreferredSize(new Dimension(400, 400));

    // add scrollpane to panel
    panel.add(scrollpane);

    panel.revalidate();

    // add panel to frame
    frame.add(panel);

    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);

  }
}

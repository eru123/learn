import javax.swing.*;
import java.awt.event.*;

public class QuestionType {
  private String question;
  private String answer;
  private String[] choices;
  public transient boolean result;
  public transient boolean isPressed;

  public QuestionType(String question, String answer, String[] choices) {
    this.question = question;
    this.answer = answer;
    this.choices = choices;
  }

  public QuestionType(String question, String answer, String choices) {
    this.question = question;
    this.answer = answer;
    this.choices = choices.split(",");
    for (int i = 0; i < this.choices.length; i++) {
      this.choices[i] = this.choices[i].trim();
    }
  }

  public QuestionType() {
    // create new question
    // JFrame question form
    JFrame qframe = new JFrame("Question");
    qframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    qframe.setSize(400, 400);

    // create question form
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // create question label
    JLabel questionLabel = new JLabel("Question");
    panel.add(questionLabel);

    // create question text field
    JTextField questionTextField = new JTextField(20);
    panel.add(questionTextField);

    // create answer label
    JLabel answerLabel = new JLabel("Answer");
    panel.add(answerLabel);

    // create answer text field
    JTextField answerTextField = new JTextField(20);
    panel.add(answerTextField);

    // create choices label
    JLabel choicesLabel = new JLabel("Choices (Seperate with commas)");
    panel.add(choicesLabel);

    // create choices text field
    JTextField choicesTextField = new JTextField(20);
    panel.add(choicesTextField);

    // create submit button
    JButton submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // get question
        question = questionTextField.getText();
        // get answer
        answer = answerTextField.getText();
        // get choices, split and trim
        choices = choicesTextField.getText().split(",");
        for (int i = 0; i < choices.length; i++) {
          choices[i] = choices[i].trim();
        }
        // close qframe
        qframe.dispose();
      }
    });

    // add submit button to panel
    panel.add(submitButton);

    panel.revalidate();

    // add panel to qframe
    qframe.add(panel);
    qframe.pack();
    qframe.setVisible(true);
    qframe.setLocationRelativeTo(null);

    // wait for submit button to be pressed
    // while (question == null) {
    // try {
    // Thread.sleep(100);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }

    // // close qframe
    // qframe.dispose();
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public String[] getChoices() {
    return choices;
  }

  public String getStringChoices() {
    String choicesString = "";
    for (int i = 0; i < choices.length; i++) {
      // add comma if not last choice
      if (i != choices.length - 1) {
        choicesString += choices[i] + ",";
      } else {
        choicesString += choices[i];
      }
    }
    return choicesString;
  }

}

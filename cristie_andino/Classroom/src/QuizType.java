import java.util.ArrayList;

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

  public QuizType() {
    // blank constructor
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
}

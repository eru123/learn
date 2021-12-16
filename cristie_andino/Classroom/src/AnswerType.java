import javax.swing.JOptionPane;

public class AnswerType {
  public int id;
  public int quiz_id;
  public int student_id;
  public int score;

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

  public String toString(Database db) {
    return db.getUser(this.student_id).getName() + " - " + this.score;
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
        myAnswer.score = quiz.take();
        db.addAnswer(myAnswer);
        JOptionPane.showMessageDialog(null, "Your score is " + myAnswer.score + " out of " + quiz.questions.size(),
            "Score", JOptionPane.INFORMATION_MESSAGE);
      }

    } else {
      JOptionPane.showMessageDialog(null, "You can't take this quiz", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}

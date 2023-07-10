import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Database {
	private String URL = "jdbc:mysql://localhost:3306/";
	private String USER = "root";
	private String PASSWORD = "root";
	private String DATABASE = "test";
	private Connection connection;

	public Database() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected to database");
			
			setupDatabase();
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void setupDatabase(){
		try {
				// create database if not exists
				Statement statement = connection.createStatement();
				statement.execute("CREATE DATABASE IF NOT EXISTS " + DATABASE);
	
				// create user table if not exists
				statement.execute("CREATE TABLE IF NOT EXISTS " + DATABASE + ".user (" +
						"id INT NOT NULL AUTO_INCREMENT," +
						"name VARCHAR(255) NOT NULL," +
						"username VARCHAR(255) NOT NULL UNIQUE," +
						"password VARCHAR(255) NOT NULL," +
						"role VARCHAR(255) NOT NULL," +
						"PRIMARY KEY (id)" +
						")");
	
				// create quiz table if not exists
				statement.execute("CREATE TABLE IF NOT EXISTS " + DATABASE + ".quiz (" +
						"id INT NOT NULL AUTO_INCREMENT," +
						"name VARCHAR(255) NOT NULL," +
						"description VARCHAR(255) NOT NULL," +
						// questions json array
						"questions JSON NOT NULL," +
						"PRIMARY KEY (id)" +
						")");
	
				// create answer table if not exists
				statement.execute("CREATE TABLE IF NOT EXISTS " + DATABASE + ".answer (" +
						"id INT NOT NULL AUTO_INCREMENT," +
						"question_id INT NOT NULL," +
						"student_id INT NOT NULL," +
						"score INT NOT NULL," +
						"PRIMARY KEY (id)," +
						"FOREIGN KEY (question_id) REFERENCES quiz(id)," +
						"FOREIGN KEY (student_id) REFERENCES user(id)" +
						")");
	
				// count how many user is registered
				ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM " + DATABASE + ".user");
				resultSet.next();
				int count = resultSet.getInt(1);
	
				if (count == 0) {
					// insert admin user
					statement.execute("INSERT INTO " + DATABASE
							+ ".user (name, username, password, role) VALUES ('Admin', 'admin', 'admin', 'admin')");
				}
	
				statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	// delete database
	public void reset() {
		try {
			Statement statement = connection.createStatement();
			statement.execute("DROP DATABASE " + DATABASE);
			setupDatabase();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	// add new user
	public boolean addUser(UserType user) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO " + DATABASE + ".user (name, username, password, role) VALUES (?, ?, ?, ?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRole());
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to create user!\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return false;
	}

	// remove user
	public boolean deleteUser(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM " + DATABASE + ".user WHERE id = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to remove user!\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return false;
	}

	// add new quiz
	public boolean addQuiz(QuizType quiz) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO " + DATABASE + ".quiz (name, description, questions) VALUES (?, ?, ?)");
			statement.setString(1, quiz.getName());
			statement.setString(2, quiz.getDescription());
			statement.setString(3, new Gson().toJson(quiz.getQuestions()));
			statement.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}

	public ArrayList<QuizType> getAllQuiz(){
		ArrayList<QuizType> quizList = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DATABASE + ".quiz");

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");

				String[][] questions = new Gson().fromJson(resultSet.getString("questions"), new TypeToken<String[][]>() {}.getType());
				quizList.add(new QuizType(id, name, description, questions));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

		return quizList;
	}

	public QuizType getQuiz(int id){
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DATABASE + ".quiz WHERE id = " + id);

			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");

				String[][] questions = new Gson().fromJson(resultSet.getString("questions"), new TypeToken<String[][]>() {}.getType());
				return new QuizType(id, name, description, questions);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

		return null;
	}

	public boolean deleteQuiz(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM " + DATABASE + ".quiz WHERE id = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to remove quiz!\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return false;
	}

	// add new quiz score
	public boolean addAnswer(AnswerType answer) {
		int question_id = answer.quiz_id;
		int student_id = answer.student_id;
		int score = answer.score;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO " + DATABASE + ".answer (question_id, student_id, score) VALUES (?, ?, ?)");
			statement.setInt(1, question_id);
			statement.setInt(2, student_id);
			statement.setInt(3, score);
			statement.execute();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}

	public ArrayList<AnswerType> getAllAnswer(int quiz_id){
		ArrayList<AnswerType> answerList = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DATABASE + ".answer WHERE question_id = " + quiz_id);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int question_id = resultSet.getInt("question_id");
				int student_id = resultSet.getInt("student_id");
				int score = resultSet.getInt("score");

				answerList.add(new AnswerType(id, question_id, student_id, score));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

		return answerList;
	}

	// get all user
	public ArrayList<UserType> getAllUser() {
		ArrayList<UserType> userList = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DATABASE + ".user");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String role = resultSet.getString("role");

				userList.add(new UserType(id, name, username, role));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

		return userList;
	}

	public UserType getUser(int id){
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DATABASE + ".user WHERE id = " + id);
			while (resultSet.next()) {
				int id_ = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String role = resultSet.getString("role");

				return new UserType(id_, name, username, role);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

		return null;
	}

	public ArrayList<UserType> getAllUser(String role) {
		ArrayList<UserType> userList = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DATABASE + ".user WHERE role = '" + role + "'");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String role1 = resultSet.getString("role");

				userList.add(new UserType(id, name, username, role1));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

		return userList;
	}

	public boolean isQuizAnswered(int quiz_id, int student_id) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DATABASE + ".answer WHERE question_id = " + quiz_id + " AND student_id = " + student_id);
			if (resultSet.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	// login user
	public UserType login(String username, String password) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM " + DATABASE + ".user WHERE username = ?");
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				if (password.equals(result.getString("password"))) {
					int id = result.getInt("id");
					String name = result.getString("name");
					String role = result.getString("role");
					return new UserType(id, name, username, role);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
}

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db;
        Teacher teacher;
        Student student;
        try {
            db = new DatabaseManager();
            // teacher = new Teacher(db);
            // student = new Student(db);
        } catch (SQLException e) {
            return;
        }

        
    }
}
import java.sql.*;
public class Teacher {
    public DatabaseManager db;

    public Teacher(DatabaseManager db) {
        this.db = db;
        try {
            this.db.createTable("teacher", new String[]{
                
            }, new String[]{
    
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

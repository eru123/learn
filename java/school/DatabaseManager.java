import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class DatabaseManager {
    public Connection conn;
    public DatabaseManager() throws SQLException {
        this.open();
    }
    public void close() throws SQLException {
        conn.close();
    }
    public void open() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sideline", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Database: Failed to connect");
        }
    }
    public void createTable(String tableName, String[] columnNames, String[] columnTypes) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
        for (int i = 0; i < columnNames.length; i++) {
            query += columnNames[i] + " " + columnTypes[i];
            if (i != columnNames.length - 1) {
                query += ", ";
            }
        }
        query += ");";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
    public void insertIntoTable(String tableName, String[] columnNames, String[] columnValues) throws SQLException {
        String query = "INSERT INTO " + tableName + " (";
        for (int i = 0; i < columnNames.length; i++) {
            query += columnNames[i];
            if (i != columnNames.length - 1) {
                query += ", ";
            }
        }
        query += ") VALUES (";
        for (int i = 0; i < columnValues.length; i++) {
            query += columnValues[i];
            if (i != columnValues.length - 1) {
                query += ", ";
            }
        }
        query += ");";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
    public void updateTable(String tableName, String[] columnNames, String[] columnValues, String whereClause) throws SQLException {
        String query = "UPDATE " + tableName + " SET ";
        for (int i = 0; i < columnNames.length; i++) {
            query += columnNames[i] + " = " + columnValues[i];
            if (i != columnNames.length - 1) {
                query += ", ";
            }
        }
        query += " WHERE " + whereClause + ";";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
    public void deleteFromTable(String tableName, String whereClause) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE " + whereClause + ";";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
    public ResultSet selectFromTable(String tableName, String[] columnNames, String whereClause) throws SQLException {
        String query = "SELECT ";
        for (int i = 0; i < columnNames.length; i++) {
            query += columnNames[i];
            if (i != columnNames.length - 1) {
                query += ", ";
            }
        }
        query += " FROM " + tableName + " WHERE " + whereClause + ";";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }
}

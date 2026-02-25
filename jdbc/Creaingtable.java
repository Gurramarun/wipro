package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Creaingtable {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "arun";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String insertSQL = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";
            PreparedStatement insertPs = con.prepareStatement(insertSQL);

            insertPs.setString(1, "Rahul");
            insertPs.setInt(2, 21);
            insertPs.setDouble(3, 76.5);
            insertPs.executeUpdate();

            String updateSQL = "UPDATE students SET marks = ? WHERE name = ?";
            PreparedStatement updatePs = con.prepareStatement(updateSQL);

            updatePs.setDouble(1, 85.0);
            updatePs.setString(2, "Rahul");
            updatePs.executeUpdate();

            String deleteSQL = "DELETE FROM students WHERE name = ?";
            PreparedStatement deletePs = con.prepareStatement(deleteSQL);

            deletePs.setString(1, "Rahul");
            deletePs.executeUpdate();

            System.out.println("Insert, Update, and Delete completed successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

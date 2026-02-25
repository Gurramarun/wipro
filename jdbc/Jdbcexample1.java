package jdbc;

import java.sql.*;

public class Jdbcexample1 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db", "root", "arun");
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO employee VALUES " +
                         "(101, 'Arun', 25000, 10), " +
                         "(102, 'Sita', 30000, 20), " +
                         "(103, 'Ravi', 28000, 10), " +
                         "(104, 'Kiran', 32000, 30)";

            int rows = stmt.executeUpdate(sql);

            System.out.println(rows + " records inserted successfully");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

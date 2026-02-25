package jdbc;

import java.sql.*;

public class Jdbcexample2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","arun" );
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s", rsmd.getColumnName(i));
            }
            System.out.println();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("---------------");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-15s", rs.getString(i));
                }
                System.out.println();
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

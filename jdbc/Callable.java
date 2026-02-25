package jdbc;

import java.sql.*;

public class Callable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db","root","arun");
            CallableStatement cs =
                    con.prepareCall("{CALL Wiprodb.getAllEmployees()}");
            ResultSet rs = cs.executeQuery();
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

            rs.close();
            cs.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

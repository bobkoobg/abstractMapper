package dataSource;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    //connection as SYS should be as SYSDBA or SYSOPER
    private static final String id = "bobkoo"; //Our project DB ACC AND PW
    private static final String pw = "boikoepi4";
    private static java.sql.Connection connection;

    private static void intializeConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:BOBKOODB", id, pw);
        } catch (SQLException eMessage) {
            System.out.println("***Mistake*** dataSource/Connection - SQL Exeption: " + eMessage);
        }
    }

    public static java.sql.Connection getConnection() {
        if (connection == null) {
            intializeConnection();
        }
        return connection;
    }

    public static void releaseConnection(java.sql.Connection con) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

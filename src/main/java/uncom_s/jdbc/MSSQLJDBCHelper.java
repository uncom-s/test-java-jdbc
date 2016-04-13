package uncom_s.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sergey.Misko on 4/13/2016.
 */
public class MSSQLJDBCHelper {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost;databaseName=trace_db", "sa", "Kakadu1977");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        statement.execute("delete from trace_1");

        connection.close();
    }
}

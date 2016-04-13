package uncom_s.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sergey.Misko on 4/13/2016.
 */
public class MSSQLJDBCHelper implements AutoCloseable {
    private Connection connection;

    public MSSQLJDBCHelper(String serverName, String login, String password) throws SQLException {
        String connectionString = String.format("jdbc:jtds:sqlserver://localhost;databaseName=%1", serverName);
        //connection = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://localhost;databaseName=trace_db", "sa", "Kakadu1977");
        connection = DriverManager.getConnection(connectionString, login, password);
    }

    public void deleteRecords(String table, boolean commit) throws SQLException {
        connection.setAutoCommit(commit);
        Statement statement = connection.createStatement();
        statement.execute(String.format("delete from %1", table));
    }

    public void deleteRecords(String table) throws SQLException {
        deleteRecords(table, false);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost;databaseName=trace_db", "sa", "Kakadu1977");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        statement.execute("delete from trace_1");

        connection.close();
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void close() throws Exception {
        connection.close();
    }
}

package utils;

import java.io.Serializable;
import java.sql.*;
import java.util.Arrays;

/**
 * Utility class to handle DB operations such setting up a connection, executing queries,
 * committing transactions for various tables;
 */
public class DBUtils implements Serializable {

    private static final String username = "root";
    private static final String password = "password123";
    private static final String url = "jdbc:mysql://localhost:3306/hrrs";

    private static Connection connection;


    public static void setUp() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = DriverManager.getConnection(url, username, password);
    }

    /**
     * Executes Insert Query to add row in the database
     * @param query
     * @throws SQLException
     */
    public void save(String query) throws SQLException {
        Statement statement = connection.createStatement();

        if( statement.executeUpdate(query) != 1 ){
            throw new SQLException();
        }
    }


    /**
     * Queries table for all results and columns
     * @param tableName
     * @return
     * @throws SQLException
     */
    public static ResultSet findAll(String tableName ) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM " + tableName ;

        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    /**
     * Queries table for specific columns
     * @param tableName
     * @param columns
     * @return
     * @throws SQLException
     */
    public ResultSet findAll(String tableName, String[] columns ) throws SQLException {
        Statement statement = connection.createStatement();

        String query = "SELECT "+ Arrays.stream(columns).toList()  + " FROM " + tableName ;

        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }
}



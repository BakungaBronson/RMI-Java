package utils;

import java.io.Serializable;
import java.sql.*;

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
     * @param query The query to execute
     * @throws SQLException If the query is not successful
     */
    public static void save(String query) throws SQLException {
        Statement statement = connection.createStatement();

        if( statement.executeUpdate(query) != 1 ){
            throw new SQLException();
        }
    }


    /**
     * Queries table for all results and columns
     * @param tableName The name of the table int the database
     * @return This is a result set of the query if successful
     * @throws SQLException If the query is not successful
     */
    public static ResultSet findAll(String tableName ) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM " + tableName ;

        return statement.executeQuery(query);
    }

    /**
     * Queries table for specific columns
     * @param tableName The name of the table in the Hrrs database
     * @param column The name of the column int the table
     * @return This is a result set of the successful query
     * @throws SQLException If the query is not successful
     */
    public static ResultSet findAll(String tableName, String column ) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT "+ column  + " FROM " + tableName ;

        return statement.executeQuery(query);
    }

    public static int count(int type) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT COUNT(`room_id`) FROM `guest-room` WHERE room_id = "+type+";";

        ResultSet resultSet= statement.executeQuery(query);

        resultSet.next();

        return resultSet.getInt("COUNT(`room_id`)");
    }

    public static int number_of_rooms(int type) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT number FROM rooms WHERE type = "+type+" ;";

        ResultSet resultSet= statement.executeQuery(query);

        resultSet.next();

        return resultSet.getInt("number");
    }

    public static String room_name(int type) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT name from rooms where type = "+type+" ;";

        ResultSet resultSet= statement.executeQuery(query);

        resultSet.next();

        return resultSet.getString("name");
    }

    public static int get_ID(String guest) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT id FROM guest WHERE name = '"+guest+"' ;";

        ResultSet resultSet= statement.executeQuery(query);

        resultSet.next();

        return resultSet.getInt("id");
    }
}



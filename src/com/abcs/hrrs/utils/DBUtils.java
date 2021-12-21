package com.abcs.hrrs.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Utility class to handle DB operations such setting up a connection, executing queries,
 * committing transactions for various tables;
 *
 * @authors Katusiime Conrad, Bakunga Bronson, Opio Andrew, Nakagwe Sharifah
 */
public class DBUtils implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String username = "root";
    private static final String password = "password123";
    private static final String url = "jdbc:mysql://localhost:3306/hrrs";

    private static Connection connection;


    /**
     * Sets up.
     *
     * @throws SQLException the sql exception
     */
    public static void setUp() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * Executes Insert Query to add row in the database
     *
     * @param query The query to execute
     * @throws SQLException If the query is not successful
     */
    public static void save(String query) throws SQLException {
        Statement statement = connection.createStatement();

        if (statement.executeUpdate(query) != 1) {
            throw new SQLException();
        }
    }

    /**
     * Queries table for all results and columns
     *
     * @param tableName The name of the table int the database
     * @return This is a result set of the query if successful
     * @throws SQLException If the query is not successful
     */
    public static ResultSet findAll(String tableName) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM " + tableName;

        //        //Close Connection to DB
//        closeConnection();
        return statement.executeQuery(query);
    }

    /**
     * Queries table for specific columns
     *
     * @param tableName The name of the table in the Hrrs database
     * @param column    The name of the column int the table
     * @return This is a result set of the successful query
     * @throws SQLException If the query is not successful
     */
    public static ResultSet findAll(String tableName, String column) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT " + column + " FROM " + tableName;

        //        //Close Connection to DB
//        closeConnection();
        return statement.executeQuery(query);
    }

    /**
     * Returns the Number of Bookings For a given Room Type
     *
     * @param type the type
     * @return int
     * @throws SQLException the sql exception
     */
    public static int count(int type) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT COUNT(`room_id`) FROM `guest-room` WHERE room_id = " + type + ";";

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

//        //Close Connection to DB
//        closeConnection();

        return resultSet.getInt("COUNT(`room_id`)");
    }

    /**
     * Returns the Total Number of Rooms for a Given Type
     *
     * @param type the type
     * @return int
     * @throws SQLException the sql exception
     */
    public static int numberOfRooms(int type) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT number FROM rooms WHERE type = " + type + " ;";

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

//        //Close Connection to DB
//        closeConnection();

        return resultSet.getInt("number");
    }

    /**
     * Returns The Name of a Room Type
     *
     * @param type the type
     * @return string
     * @throws SQLException the sql exception
     */
    public static String roomName(int type) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT name from rooms where type = " + type + " ;";

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

//        //Close Connection to DB
//        closeConnection();

        return resultSet.getString("name");
    }

    /**
     * Returns the guest ID
     *
     * @param guest the guest
     * @return guest_id id
     * @throws SQLException the sql exception
     */
    public static int getID(String guest) throws SQLException {
        setUp();
        Statement statement = connection.createStatement();

        String query = "SELECT id FROM guest WHERE name = '" + guest + "' ;";

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

//        //Close Connection to DB
//        closeConnection();

        return resultSet.getInt("id");
    }

    /**
     * Function to close the connection to DB after a transaction
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        connection.close();
    }


//    public static int getBookedRooms() throws SQLException {
//        setUp();
//        Statement statement = connection.createStatement();
//        String query = "SELECT room_id as type, COUNT(*) as bookings from `guest-room` GROUP BY room_id";
//
//    }
}



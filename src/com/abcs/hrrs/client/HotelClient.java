/**
 * 
 */
package com.abcs.hrrs.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcs.hrrs.services.RoomManager;

/**
 * Class to handle Client logic
 * 
 * @author katusiimeconrad
 *
 */
public class HotelClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			// Create an instance
			// RoomManager manager = (RoomManager)
			// Naming.lookup("rmi://localhost:1099/rooms");

			// manager.revenue();

			Registry registry = LocateRegistry.getRegistry("localhost", 1099);

			System.out.println("Connected 11 : \n");

			RoomManager manager = (RoomManager) registry.lookup("rmi://localhost:1099/rooms");

			System.out.println("Connected 112 : \n");

			displayRooms(manager.getRooms());

			manager.revenue();

		} catch (Exception e) {
			System.out.println("Recieved Exception : " + e);

		}

	}

	public static void displayRooms(ResultSet rs) throws SQLException {
		System.out.println("ID \t \t Name \t \t Cost \t \t Available Rooms ");
		if(rs.next()) {
			System.out.println(rs.getString("type") + "\t \t" +
					rs.getString("name")  + "\t \t" +
					rs.getString("cost")  + "\t \t" +
					rs.getString("available"));
		}
	}

}

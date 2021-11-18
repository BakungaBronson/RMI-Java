package com.abcs.hrrs.client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abcs.hrrs.data.Data;
import com.abcs.hrrs.services.RoomManager;

/**
 * Class to handle Client logic
 * 
 * @author katusiimeconrad
 *
 */
public class HotelClient {

	/**
	 * Takes a string of arguments
	 */
	public static void main(String[] args) {
		try {

			System.out.println("Connect : OK\n");

			if (args.length > 0) {
				if (args[0].equals("list")) {
					//rm.List();

				} else if (args[0].equals("book")) {
					//rm.Book(arg[1], arg[2]);
					RoomManager manager = (RoomManager) Naming.lookup("rmi://"+args[1]+":1099/roomManager");

					try {
						int val = Integer.parseInt(args[2]);
						System.out.println(manager.book(val, args[3]));
					}
					catch (NumberFormatException e) {

						// This is thrown when the String
						// contains characters other than digits
						System.out.println("Invalid number!");
					}

				} else if (args[0].equals("guests")) {

					RoomManager manager = (RoomManager) Naming.lookup("rmi://"+args[1]+":1099/roomManager");

					ArrayList<Data> res = manager.Guests();

					int i = 0;
					while (i < res.size()) {
						System.out.print("Guest "+(i+1)+" name: " + res.get(i).guest + "\n");
						i++;
					}

				} else if (args[0].equals("revenue")) {
					RoomManager manager = (RoomManager) Naming.lookup("rmi://"+args[1]+":1099/roomManager");

					System.out.println(manager.revenue());
				}

			} else {
				System.out.println("print how to use");
			}

		} catch (Exception e) {
			System.out.println("Received Exception : " + e);

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

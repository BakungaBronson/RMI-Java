package com.abcs.hrrs.client;

import com.abcs.hrrs.data.Data;
import com.abcs.hrrs.models.Room;
import com.abcs.hrrs.services.RoomManager;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class to handle Client logic
 *
 * @authors Katusiime Conrad, Bakunga Bronson, Opio Andrew, Nakagwe Sharifah
 */
public class HotelClient {
    private static RoomManager manager;

    /**
     * Helper method to locate server based on serverAddress.
     * Sets manager Object of type {@link RoomManager}
     *
     * @param serverAddress
     * @throws RemoteException
     * @throws NotBoundException
     */
    public static void getService(String serverAddress) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry(serverAddress, 1099);

        manager = (RoomManager) registry.lookup("rmi://" + serverAddress + ":1099/rooms");

    }

    /**
     * Takes a string of arguments
     */
    public static void main(String[] args) {
        try {

            System.out.println("Connect : OK\n");

            if (args.length > 0) {
                if (args[0].equals("list")) {
                    //LIST
                    getService("localhost");
                    displayRooms(manager.getRooms());

                } else if (args[0].equals("book")) {
                    //rm.Book(arg[1], arg[2]);
                    RoomManager manager = (RoomManager) Naming.lookup("rmi://" + args[1] + ":1099/roomManager");

                    try {
                        int val = Integer.parseInt(args[2]);
                        System.out.println(manager.book(val, args[3]));
                    } catch (NumberFormatException e) {

                        // This is thrown when the String
                        // contains characters other than digits
                        System.out.println("Invalid number!");
                    }

                } else if (args[0].equals("guests")) {

                    RoomManager manager = (RoomManager) Naming.lookup("rmi://" + args[1] + ":1099/roomManager");

                    ArrayList<Data> res = manager.Guests();

                    int i = 0;
                    while (i < res.size()) {
                        System.out.print("Guest " + (i + 1) + " name: " + res.get(i).guest + "\n");
                        i++;
                    }

                } else if (args[0].equals("revenue")) {
                    getService(args[1]);

                    showRevenueBreakdown(manager.getRooms());
                }

            } else {
                //Display how to Use
				System.out.println("How to Use ");
				//Instructions
                System.out.println("java HotelClient list <server address>: " +
						"\n list the available number of rooms in each price range");
				System.out.println("java HotelClient book <server address> <room type> <guest name>: " +
						" \n books a room of the specified type (if available), and registers the name of the guest.");
				System.out.println("java HotelClient guests <server address>: " +
						"\n list the names of all the registered guests");
				System.out.println("java HotelClient revenue <server address>: " +
						"\n prints the revenue breakdown based on\n" +
						"the booked rooms and their types");
            }

        } catch (Exception e) {
            System.out.println("Received Exception : " + e);

        }

    }

    /**
     * Helper function to render Rooms
     *
     * @throws SQLException
     */
    public static void displayRooms(ArrayList<Room> rooms) throws SQLException {
        System.out.println("Room Availability ");

        //v rooms of type 0 are available fo r55,000 UGX pernight
        for (Room room : rooms) {
            System.out.println(room.getAvailable() +
                    " rooms of type " + room.getType() +
                    " are available for " + room.getCost() +
                    " UGX per night");
        }
    }

    public static void showRevenueBreakdown(ArrayList<Room> rooms) throws SQLException {
        int totalRevenue = 0;
        System.out.println("Revenue Breakdown : Per Room Type");

        for (Room room : rooms) {
            System.out.println("Room Type: " + room.getType() + '\n' +
                    "Number of Bookings: " + room.getBookings() + '\t' +
                    "Cost Per Room : " + room.getCost() + '\t' +
                    "Revenue: " + room.getCost() * room.getBookings()
            );
            totalRevenue += room.getCost() * room.getBookings();
        }

        System.out.println("Total Revenue : " + totalRevenue);
    }


}

package com.abcs.hrrs.services;

import com.abcs.hrrs.data.Data;
import com.abcs.hrrs.models.Room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * RoomManager interface contains the methods to use in the System
 * 
 * @authors Katusiime Conrad, Bakunga Bronson, Opio Andrew, Nakagwe Sharifah
 *
 */
public interface RoomManager extends Remote {
	
	/**
	 * Prints the Revenue breakdown based on the booked rooms and their types
	 * @return Returns the revenue generated
	 */
	String revenue() throws RemoteException;

	ArrayList<Data>  Guests() throws RemoteException, SQLException;

	/**
	 *  Method Finds Rooms Data from the DB and returns and Arraylist containing
	 *  {@link Room} objects. The {@link Room} contain row data.
	 * @return
	 * @throws RemoteException
	 * @throws SQLException
	 */
	ArrayList<Room> getRooms() throws RemoteException, SQLException;

	String book(int type, String guest) throws RemoteException, SQLException;
}

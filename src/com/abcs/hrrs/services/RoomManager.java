package com.abcs.hrrs.services;

import com.abcs.hrrs.data.Data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * RoomManager interface contains the methods to use in the System
 * 
 * @author katusiimeconrad
 *
 */
public interface RoomManager extends Remote {
	
	/**
	 * Prints the Revenue breakdown based on the booked rooms and their types
	 * @return Returns the revenue generated
	 */
	String revenue() throws RemoteException;

	ArrayList<Data>  Guests() throws RemoteException, SQLException;

	void getRooms() throws RemoteException, SQLException;

	String book(int type, String guest) throws RemoteException, SQLException;
}

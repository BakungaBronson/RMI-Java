/**
 * 
 */
package com.abcs.hrrs.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RoomManager interface contains the methods to use in the System
 * 
 * @author katusiimeconrad
 *
 */
public interface RoomManager extends Remote {
	
	/**
	 * Prints the Revenue breakdown based on the booked rooms and their types
	 * @return
	 */
	public String revenue() throws RemoteException;

	public ResultSet getRooms() throws RemoteException, SQLException;
}

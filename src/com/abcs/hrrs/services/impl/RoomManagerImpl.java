/**
 * 
 */
package com.abcs.hrrs.services.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcs.hrrs.services.RoomManager;
import utils.DBUtils;

/**
 * Contains the implementation logic of the {@link RoomManager} interface
 * 
 * @author katusiimeconrad
 *
 */
public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {

	private static final long serialVersionUID = 1L;

	public RoomManagerImpl() throws RemoteException {
		super();
	}

	@Override
	public String revenue() throws RemoteException {
		return "Hello Rooms!";
	}

	@Override
	public ResultSet getRooms() throws RemoteException, SQLException {
		return DBUtils.findAll("rooms");
	}


}

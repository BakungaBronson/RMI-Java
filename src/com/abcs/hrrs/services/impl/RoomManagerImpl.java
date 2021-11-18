package com.abcs.hrrs.services.impl;

import com.abcs.hrrs.services.RoomManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Contains the implementation logic of the {@link RoomManager} interface
 * 
 * @author katusiimeconrad
 *
 */
public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {

    public RoomManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public String book(String address, String room_type, String guest_name) {
        // Update the details in the database and return the result
        return room_type+": Reserved for "+guest_name;
    }
	
}

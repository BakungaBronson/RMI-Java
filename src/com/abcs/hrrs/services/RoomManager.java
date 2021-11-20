package com.abcs.hrrs.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abcs.hrrs.data.Data;
import com.abcs.hrrs.models.Room;

/**
 * RoomManager interface contains the methods to use in the System
 *
 * @authors Katusiime Conrad, Bakunga Bronson, Opio Andrew, Nakagwe Sharifah
 */
public interface RoomManager extends Remote {

    /**
     * Prints the Revenue breakdown based on the booked rooms and their types
     *
     * @return Returns the revenue generated
     * @throws RemoteException the remote exception
     */
    String revenue() throws RemoteException;

    /**
     * Guests array list.
     *
     * @return the array list
     * @throws RemoteException the remote exception
     * @throws SQLException    the sql exception
     */
    ArrayList<Data>  Guests() throws RemoteException, SQLException;

    /**
     * Method Finds Rooms Data from the DB and returns and Arraylist containing
     * {@link Room} objects. The {@link Room} contain row data.
     *
     * @return rooms
     * @throws RemoteException the remote exception
     * @throws SQLException    the sql exception
     */
    ArrayList<Room> getRooms() throws RemoteException, SQLException;

    /**
     * Book string.
     *
     * @param type  the type
     * @param guest the guest
     * @return the string
     * @throws RemoteException the remote exception
     * @throws SQLException    the sql exception
     */
    String book(int type, String guest) throws RemoteException, SQLException;
}

package com.abcs.hrrs.services;

import java.rmi.Remote;

/**
 * RoomManager interface contains the methods to use in the System
 * 
 * @author katusiimeconrad
 *
 */
public interface RoomManager extends Remote {
    String book(String address, String room_type, String guest_name) throws Exception;
}

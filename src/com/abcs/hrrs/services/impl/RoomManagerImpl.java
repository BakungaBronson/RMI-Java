package com.abcs.hrrs.services.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abcs.hrrs.data.Data;
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
	public void getRooms() throws RemoteException, SQLException {
		ResultSet rs = DBUtils.findAll("rooms");
		System.out.println("ID \t \t Name \t \t Cost \t \t Available Rooms ");
		if(rs.next()) {
			System.out.println(rs.getString("type") + "\t \t" +
					rs.getString("name")  + "\t \t" +
					rs.getString("cost")  + "\t \t" +
					rs.getString("available"));
		}
	}

	@Override
	public String book(int type, String guest) throws RemoteException, SQLException {
		String room_name = DBUtils.room_name(type);

		if(DBUtils.count(type) < (DBUtils.number_of_rooms(type) + 1) ) {
			DBUtils.save("INSERT INTO guest (name) VALUES ('"+guest+"')");
			int guest_id = DBUtils.get_ID(guest);
			DBUtils.save("INSERT INTO `guest-room` (guest_id, room_id) VALUES ("+guest_id+","+type+")");
			return "Booking made for Guest: "+guest+" for Building type:"+room_name+"";
		}
		else {
			return "Rooms of Type: "+room_name+" are fully booked";
		}
	}

	@Override
	public ArrayList<Data> Guests() throws RemoteException, SQLException {

		ArrayList<Data> data;
		try (ResultSet rs = DBUtils.findAll("guest", "name" )) {

			data = new ArrayList<>();

			try {
				while (rs.next()) {
					Data d = new Data();
					d.guest = rs.getString("name");
					data.add(d);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return data;
	}
}

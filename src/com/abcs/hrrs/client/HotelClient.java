package com.abcs.hrrs.client;

import com.abcs.hrrs.services.RoomManager;

import java.rmi.Naming;

/**
 * Class to handle Client logic
 * @author katusiimeconrad
 *
 */
public class HotelClient {

	/**
	 * @param args
	 * The first argument args[0] takes in the method being called
	 * The second argument args[1] takes in the 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        if(args[0].equals("book")){
            RoomManager obj = (RoomManager)Naming.lookup("book");
            String message = obj.book(args[1], args[2], args[3]);
            System.out.print(message);
        }

	}

}

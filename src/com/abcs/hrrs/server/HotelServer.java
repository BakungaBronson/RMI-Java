package com.abcs.hrrs.server;

import com.abcs.hrrs.services.impl.RoomManagerImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Class to handle Server Logic
 * @author katusiimeconrad
 *
 */
public class HotelServer {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		RoomManagerImpl obj = new RoomManagerImpl();
		Naming.rebind("book", obj);
		System.out.println("Server has started!");
	}

}

package com.abcs.hrrs.server;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.abcs.hrrs.services.RoomManager;
import com.abcs.hrrs.services.impl.RoomManagerImpl;

/**
 * Class to handle Server Logic
 * 
 * @authors Katusiime Conrad, Bakunga Bronson, Opio Andrew, Nakagwe Sharifah
 *
 */
public class HotelServer implements Serializable {



	public static void main(String[] args) throws RemoteException {

		try {
			// Create an instance
			RoomManagerImpl roomManager = new RoomManagerImpl();

//			// binding the server to the rmiregistry
//			Naming.rebind("rmi://localhost:1099/roomManager", roomManager);
//
//			// Naming.rebind("book", roomManager);


			//Create Server Instance Dynamically

			Registry reg = LocateRegistry.createRegistry(1099);

			reg.rebind("rmi://localhost:1099/rooms", roomManager);


	        System.out.println("Server is Ready \n" + reg.toString() );

		} catch (Exception e) {
			System.out.println("An error occurred Error: " + e);

		}

	}

}

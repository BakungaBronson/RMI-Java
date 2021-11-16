/**
 * 
 */
package com.abcs.hrrs.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.abcs.hrrs.services.RoomManager;
import com.abcs.hrrs.services.impl.RoomManagerImpl;

/**
 * Class to handle Server Logic
 * 
 * @author katusiimeconrad
 *
 */
public class HotelServer implements Serializable {



	public static void main(String[] args) throws RemoteException {

		try {
			// Create an instance
			RoomManagerImpl roomManager = new RoomManagerImpl();

			// binding the server to the rmiregistry
			//Naming.rebind("rmi://localhost:1099/rooms", roomManager);
			
			Registry reg = LocateRegistry.createRegistry(1099);

			reg.rebind("rmi://localhost:1099/rooms", roomManager);
	        
	        System.out.println("Server is Ready");

		} catch (Exception e) {
			System.out.println("An error occured Error: " + e);

		}

	}

}

import java.rmi.*;
import java.sql.*;
import java.util.ArrayList;

public interface RoomManager extends Remote {
    public void  List () throws RemoteException;
    public String  Book (int type, String name) throws RemoteException;
    public ArrayList<data>  Guests () throws RemoteException;
    public void  Revenue () throws RemoteException;
}



































































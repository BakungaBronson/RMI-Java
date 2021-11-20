import java.rmi.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * The interface Room manager.
 */
public interface RoomManager extends Remote {
    /**
     * List.
     *
     * @throws RemoteException the remote exception
     */
    public void  List () throws RemoteException;

    /**
     * Book string.
     *
     * @param type the type
     * @param name the name
     * @return the string
     * @throws RemoteException the remote exception
     */
    public String  Book (int type, String name) throws RemoteException;

    /**
     * Guests array list.
     *
     * @return the array list
     * @throws RemoteException the remote exception
     */
    public ArrayList<data>  Guests () throws RemoteException;

    /**
     * Revenue.
     *
     * @throws RemoteException the remote exception
     */
    public void  Revenue () throws RemoteException;
}



































































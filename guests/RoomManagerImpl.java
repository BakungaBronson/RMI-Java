import java.rmi.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * The type Room manager.
 */
public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager {
	private static final long serialVersionUID = 1420672609912364060L;

    /**
     * Instantiates a new Room manager.
     *
     * @throws RemoteException the remote exception
     */
    public RoomManagerImpl() throws RemoteException
    {
       super();
    }

    /**
     * List.
     *
     * @throws RemoteException the remote exception
     */
    public void  List() throws RemoteException
    {

    }

    /**
     * Book string.
     *
     * @param type the type
     * @param name the name
     * @return the string
     * @throws RemoteException the remote exception
     */
    public String  Book(int type, String name) throws RemoteException
    {
       return "string";
    }

    /**
     * Guests array list.
     *
     * @return the array list
     * @throws RemoteException the remote exception
     */
    public ArrayList<data> Guests() throws RemoteException
    {
       dbconn connect = new dbconn();
       ResultSet rs = connect.Execute("select * from bookings");

       ArrayList<data> data = new ArrayList<>();
       
       try{
         while (rs.next()) {
            data d = new data();
            d.type = rs.getInt("type");
            d.guest = rs.getString("guest");
            data.add(d);
         }
      } catch (Exception e) {
         System.out.println(e);
      }  

      return data;
    }

    /**
     * Revenue.
     *
     * @throws RemoteException the remote exception
     */
    public void  Revenue() throws RemoteException
    {

    }
}
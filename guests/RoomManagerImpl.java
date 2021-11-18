import java.rmi.*;
import java.sql.*;
import java.util.ArrayList;

public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager {
	private static final long serialVersionUID = 1420672609912364060L;

    public RoomManagerImpl() throws RemoteException
    {
       super();
    }

    public void  List() throws RemoteException 
    {

    }

    public String  Book(int type, String name) throws RemoteException
    {
       return "string";
    }

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

    public void  Revenue() throws RemoteException
    {

    }
}
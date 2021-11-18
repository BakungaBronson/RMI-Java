import java.rmi.Naming;

public class HotelServer {

    public HotelServer() {
        try {
            RoomManagerImpl rm = new RoomManagerImpl();
            Naming.rebind("rmi://localhost:1099/HotelService", rm);
            
        } catch (Exception e) {
            System.out.println("Trouble: _" + e);
        }
    }

    public static void main (String args [] ) {
        new HotelServer();
    }
}


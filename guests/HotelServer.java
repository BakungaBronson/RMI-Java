import java.rmi.Naming;

/**
 * The type Hotel server.
 */
public class HotelServer {

    /**
     * Instantiates a new Hotel server.
     */
    public HotelServer() {
        try {
            RoomManagerImpl rm = new RoomManagerImpl();
            Naming.rebind("rmi://localhost:1099/HotelService", rm);
            
        } catch (Exception e) {
            System.out.println("Trouble: _" + e);
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main (String args [] ) {
        new HotelServer();
    }
}


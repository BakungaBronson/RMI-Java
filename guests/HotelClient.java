import java.net.MalformedURLException;
import java.rmi.Naming;
import java.sql.*;
import java.util.ArrayList;

public class HotelClient {
    public static void main (String [] args) {        
        try {
            RoomManager rm = (RoomManager)
            Naming.lookup("rmi://localhost:1099/HotelService");

            if (args.length > 0) {
                if (args[0].equals("list")) {
                   //rm.List();

                } else if (args[0].equals("book")) {
                  //rm.Book(arg[1], arg[2]);

                } else if (args[0].equals("guests")) {
                ArrayList<data> res = rm.Guests();

                int i = 0;
                 while (i < res.size()) {
                    System.out.print("Guest's name: " + res.get(i).guest + ",  ");
                    System.out.println("Room type: " + res.get(i).type);
                    i++;
                 }
    
                } else if (args[0].equals("revenue")) {
                   //rm.Revenue();
                }

            } else {
              System.out.println("print how to use");
            }

        } catch (Exception e) {
            System.out.println("Received Exception: ");
            System.out.println(e);
        }
    }
}
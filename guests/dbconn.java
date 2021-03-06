import java.sql.*;

/**
 * The type Dbconn.
 */
public class dbconn {
    /**
     * Execute result set.
     *
     * @param query the query
     * @return the result set
     */
    public ResultSet Execute(String query){
        ResultSet rs = null;
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrrs","root","");

            Statement stmt = con.createStatement();  
            rs = stmt.executeQuery(query);
    
        } catch (Exception e) {
            System.out.println(e);
        }  
        return rs;
    } 
}
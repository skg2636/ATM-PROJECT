
package atm.simulation.system;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    

    public conn(){
         
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bank_admin","bank_admin");
            s=c.createStatement();
            
  
 
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
    
    
}

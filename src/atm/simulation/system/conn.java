
package atm.simulation.system;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    

    public conn(){
         
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","user_name","password");
            s=c.createStatement();
            
  
 
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
    
    
}

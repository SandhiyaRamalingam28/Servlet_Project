import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    public static boolean validate(String username, String password){  
          
        boolean status = false;
        try {
         
                    // loading drivers for mysql
                    Class.forName("com.mysql.jdbc.Driver");
                     
                    //creating connection with the database
                    Connection con = DriverManager.getConnection
                                ("jdbc:mysql://localhost:3306/sandhiya","root","");
         
                    PreparedStatement ps = con.prepareStatement
                                ("Select * from logindetails where username=? and password=?");
                               
                    // ps.setString(1, id);
                    // ps.setString(2, email);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();
                    status=rs.next();
                    
                }
                catch(Exception e){System.out.println(e);
                }  
                return status;  
        }

}

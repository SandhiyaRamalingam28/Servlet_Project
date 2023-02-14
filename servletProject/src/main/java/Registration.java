import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class Registration extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //  Long id = Long.parseLong(req.getParameter("id"));
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
         
            // loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
             
            //creating connection with the database
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/sandhiya","root","");
 
            PreparedStatement ps = con.prepareStatement
                        ("insert into logindetails values(?,?,?,?)");
 
            ps.setString(1, id);
            ps.setString(2,email);
            ps.setString(3, username);
            ps.setString(4, password);
        
            int i = ps.executeUpdate();
             
            if(i > 0) {
                out.println("You are Registered successfully");
            }
         
        }
        catch(Exception se) {
            se.printStackTrace();
        }
    }
    
}

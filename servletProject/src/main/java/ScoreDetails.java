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

@WebServlet("/SkillDetails")
public class ScoreDetails extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //  Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String Techincal_Skill = req.getParameter("TechincalSkill");
        String Assessment_Type = req.getParameter("AssessmentType");
        String Assessment_Description = req.getParameter("AssessmentDescription");
        String Assessment_Date = req.getParameter("AssessmentDate");
        String score = req.getParameter("Score");
        String remarks = req.getParameter("Remarks");
        String url = req.getParameter("URL");
        String AssessmentBy = req.getParameter("AssessmentBy");

        try {
         
            // loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
             
            //creating connection with the database
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/sandhiya","root","");
 
            PreparedStatement ps = con.prepareStatement
                        ("insert into SkillDetails values(?,?,?,?,?,?,?,?,?)");
 
            ps.setString(1, name);
            ps.setString(2, Techincal_Skill);
            ps.setString(3, Assessment_Type);
            ps.setString(4, Assessment_Description);
            ps.setString(5, Assessment_Date);
            ps.setString(6, score);
            ps.setString(7, remarks);
            ps.setString(8, url);
            ps.setString(9, AssessmentBy);
            int i = ps.executeUpdate();
             
            if(i > 0) {
                out.println("You are successfully registered successfully");  
 
            }
         
        }
        catch(Exception se) {
            se.printStackTrace();
        }
    }
    
}

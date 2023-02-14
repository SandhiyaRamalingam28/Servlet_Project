import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
    
            // String id = req.getParameter("id");
            // String email = req.getParameter("email");
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if(LoginDao.validate(username, password)){  
                RequestDispatcher rd=req.getRequestDispatcher("index.html");  
                rd.forward(req,resp);  
            }  
            else{  
                out.print("Sorry username or password error");  
                RequestDispatcher rd=req.getRequestDispatcher("login.jsp");  
                rd.include(req,resp);  
            }  
                  
            out.close();  
    }

    }

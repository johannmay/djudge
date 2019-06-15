package servlet;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Johann Mayos
 */
@WebServlet(urlPatterns = "Login.html")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
        
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            response.setContentType("text/html ; charset = UTF-8");
            PrintWriter out = response.getWriter();
            RequestDispatcher rd = null;
            request.setAttribute(email , "email");
            
            if(email.equals("email") && senha.equals(("senha"))){
                rd = request.getRequestDispatcher("WelcomeServlet");
                rd.forward(request , response);
            }
            
            else{
                out.println("Informacao de Login invalida.");
                rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }
            
            out.close();
	
    }

}
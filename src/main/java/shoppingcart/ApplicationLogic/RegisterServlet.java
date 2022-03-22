package shoppingcart.ApplicationLogic;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import shoppingcart.DatabaseConnection.*;

import shoppingcart.DatabaseModel.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User userModel = new User(name, email, password);
		try {
			RegisterDatabaseAccess registerDatabaseAccess = new RegisterDatabaseAccess(DatabaseConnection.getConnetion());
			if (registerDatabaseAccess.saveUser(userModel)) {
				
				//request.getRequestDispatcher("/WEB-INF/User_interface/login.jsp").forward(request, response);
			   response.sendRedirect("login.jsp");
			} else {
			    String errorMessage = "User Available";
			    HttpSession regSession = request.getSession();
			    regSession.setAttribute("RegError", errorMessage);
			    
			   // request.getRequestDispatcher("/WEB-INF/User_interface/registration.jsp").forward(request, response);
			    response.sendRedirect("registration.jsp");
			    }
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

}
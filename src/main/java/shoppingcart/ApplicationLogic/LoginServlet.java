package shoppingcart.ApplicationLogic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shoppingcart.DatabaseConnection.DatabaseConnection;
import shoppingcart.DatabaseConnection.UserDataAccess;
import shoppingcart.DatabaseModel.User;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/User_interface/login.jsp").forward(request, response);
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			try {
				UserDataAccess userDataaccess = new UserDataAccess(DatabaseConnection.getConnetion());
				User user = userDataaccess.userLogin(email, password);
				if(user != null && (email.equals("admin@gmail.com") && password.equals("admin@123"))) {
					request.getSession().setAttribute("authentication", user);
					
					//request.getRequestDispatcher("/WEB-INF/User_interface/admin.jsp").forward(request, response);
					response.sendRedirect("admin.jsp");
				}else if(user != null && email != ("admin@gmail.com") ) {
					request.getSession().setAttribute("authentication", user);
					
					//request.getRequestDispatcher("/WEB-INF/User_interface/index.jsp").forward(request, response);
					response.sendRedirect("index.jsp");
				}else {
					out.print("user login failed");
				}
				
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			
		}
	}

}

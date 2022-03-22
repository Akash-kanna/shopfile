package shoppingcart.ApplicationLogic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			if(request.getSession().getAttribute("authentication")!=null) {
				request.getSession().removeAttribute("authentication");
				
				//request.getRequestDispatcher("/WEB-INF/User_interface/login.jsp").forward(request, response);
				response.sendRedirect("login.jsp");
			}else {
				
				//request.getRequestDispatcher("/WEB-INF/User_interface/index.jsp").forward(request, response);
				response.sendRedirect("index.jsp");
			}
		}
	}

}

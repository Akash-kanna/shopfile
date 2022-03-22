package shoppingcart.ApplicationLogic;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import shoppingcart.DatabaseConnection.DatabaseConnection;
import shoppingcart.DatabaseConnection.OrderDataAccess;
/**
 * Servlet implementation class CancelOrderServlet
 */
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			String id= request.getParameter("id");
			if(id!=null) {
				OrderDataAccess orderDataaccess =new OrderDataAccess(DatabaseConnection.getConnetion());
				orderDataaccess.cancelOrder(Integer.parseInt(id));
			}
			
			//request.getRequestDispatcher("/WEB-INF/User_interface/orders.jsp").forward(request, response);
			
			response.sendRedirect("orders.jsp");
		} catch (Exception exception) {
			
			exception.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}

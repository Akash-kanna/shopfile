package shoppingcart.ApplicationLogic;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import shoppingcart.DatabaseConnection.AdminProductDao;
import shoppingcart.DatabaseConnection.DatabaseConnection;
/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int pid= Integer.parseInt(request.getParameter("id"));
			
			AdminProductDao adminProductDao = new AdminProductDao(DatabaseConnection.getConnetion());
			adminProductDao.deleteProduct(pid);
			
			//request.getRequestDispatcher("/WEB-INF/User_interface/admin_product.jsp").forward(request, response);
			
			response.sendRedirect("admin_product.jsp");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

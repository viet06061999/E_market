package servlet.admin;

import dao.UserDAOImpl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UserDeleteServlet extends HttpServlet {
	UserDAOImpl userService = new UserDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		userService.deleteUser(Integer.parseInt(id));
		
		resp.sendRedirect(req.getContextPath() + "/UserListServlet");
	}
}

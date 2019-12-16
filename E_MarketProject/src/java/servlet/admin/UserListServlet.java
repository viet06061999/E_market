package servlet.admin;

import dao.UserDAOImpl;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class UserListServlet extends HttpServlet {
	UserDAOImpl userService = new UserDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
              resp.setCharacterEncoding("utf-8");
            List<User> userList = userService.getList();
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/list-user.jsp");
		dispatcher.forward(req, resp);
	}
	
}

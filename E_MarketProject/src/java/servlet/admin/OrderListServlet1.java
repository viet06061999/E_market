package servlet.admin;

import dao.OrderDAOImpl;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Order;
public class OrderListServlet1 extends HttpServlet {
	OrderDAOImpl orderDAO=new OrderDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Order> list =orderDAO.getAll();
	req.setAttribute("list", list);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/list-order.jsp");
	dispatcher.forward(req, resp);
	}
	
}

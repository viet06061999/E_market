package servlet.admin;


import dao.ProductDAOImpl;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;


public class ProductListServlet extends HttpServlet {
	ProductDAOImpl productService = new ProductDAOImpl();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> proList = productService.getList();
		req.setAttribute("proList", proList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/list-product.jsp");
		dispatcher.forward(req, resp);
	}

}

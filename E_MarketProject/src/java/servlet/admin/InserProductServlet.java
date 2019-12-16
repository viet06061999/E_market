package servlet.admin;

import dao.ProductDAOImpl;
import dao.CategoryDAOImpl;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

public class InserProductServlet extends HttpServlet {
	ProductDAOImpl productService = new ProductDAOImpl();
        CategoryDAOImpl categoryService = new CategoryDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> categories = categoryService.getList();

		req.setAttribute("categories", categories);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/add-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Product product = new Product();
	req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
       
        product.setTen_san_pham(req.getParameter("name"));
        product.setHang_san_xuat(req.getParameter("hangsx"));
        product.setThong_tin(req.getParameter("des"));
        product.setGia_ban(Double.parseDouble(req.getParameter("price")));
        product.setMa_the_loai(Integer.parseInt(req.getParameter("cate")));
        productService.addProduct(product);
        Product p= productService.getProduct(req.getParameter("name")); 
        
        req.setAttribute("id",p.getMa_san_pham());
        req.getRequestDispatcher("/admin/view/insert-image.jsp").forward(req, resp);

	}
}

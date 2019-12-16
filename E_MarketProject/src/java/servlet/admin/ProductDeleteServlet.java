package servlet.admin;

import dao.ProductDAOImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDeleteServlet extends HttpServlet {

    ProductDAOImpl productService = new ProductDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        productService.delete(Integer.parseInt(id));

        resp.sendRedirect(req.getContextPath() + "/ProductListServlet");
    }

}

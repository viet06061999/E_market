package servlet.admin;

import dao.CategoryDAOImpl;
import dao.ProductDAOImpl;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@MultipartConfig()
public class ProductEditServlet extends HttpServlet {

    ProductDAOImpl productService = new ProductDAOImpl();
    CategoryDAOImpl categoryService = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productService.getProduct(Integer.parseInt(id));
        List<Category> categories = categoryService.getList();

        req.setAttribute("categories", categories);

        req.setAttribute("product", product);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/edit-product.jsp");
        dispatcher.forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Product product = new Product();
        String hinh_anh= productService.getProduct(Integer.parseInt(req.getParameter("id"))).getHinh_anh();
        product.setHinh_anh(hinh_anh);
        product.setMa_san_pham(Integer.parseInt(req.getParameter("id")));
        product.setTen_san_pham(req.getParameter("name"));
        product.setHang_san_xuat(req.getParameter("hangsx"));
        product.setThong_tin(req.getParameter("des"));
        product.setGia_ban(Double.parseDouble(req.getParameter("price")));
        product.setMa_the_loai(categoryService.getCategory(req.getParameter("cate")).getMa_the_loai());
        productService.update(product);
        req.setAttribute("id",product.getMa_san_pham());
        req.getRequestDispatcher("/admin/view/insert-image.jsp").forward(req, resp);
    }
}

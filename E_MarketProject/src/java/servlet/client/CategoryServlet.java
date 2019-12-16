/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.client;

import dao.ProductDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author lovelan
 */
public class CategoryServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int ma_the_loai=Integer.parseInt(request.getParameter("ma_the_loai"));
       ProductDAOImpl product = new ProductDAOImpl();
    //   List<Product> list = product.getListByCategory(ma_the_loai);
       request.setAttribute("listProduct", product.getListByCategory(ma_the_loai));
       RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
       rd.forward(request, response);
    }


}

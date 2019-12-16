/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.client;
import dao.ProductDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomePageServlet",
        loadOnStartup = 1,
        urlPatterns = {"/HomePageServlet"})
public class HomePageServlet extends HttpServlet {

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ProductDAOImpl productBLL = new ProductDAOImpl();
        getServletContext().setAttribute("newProducts", productBLL.getNewProduct());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}

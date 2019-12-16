/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.admin;

import dao.OrderDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderConfirmServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int order_id = Integer.parseInt(request.getParameter("order_id"));
         int p_id=Integer.parseInt(request.getParameter("p_id"));
         OrderDAOImpl orderDAO = new OrderDAOImpl();
         orderDAO.confirmOrder(order_id, p_id);
         response.sendRedirect(request.getContextPath() + "/OrderListServlet1");
    }

}

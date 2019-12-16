/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.client;

import dao.HistoryDAOImpl;
import dao.OrderDAOImpl;
import dao.ProductDAOImpl;
import dao.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.History;
import model.Order;

/**
 *
 * @author lovelan
 */
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        OrderDAOImpl orderdao = new OrderDAOImpl();
        UserDAOImpl userdao = new UserDAOImpl();
        HistoryDAOImpl historyDAO = new HistoryDAOImpl();
        ProductDAOImpl productDAO = new ProductDAOImpl();
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("diachi");
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
            }
        }
        ArrayList<Cart> cart = (ArrayList<Cart>) request.getSession().getAttribute("cart");
        int order_id = orderdao.countOrder() + 1;
        int user_id = userdao.getUser(username).getUser_id();
          Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp create_time = new java.sql.Timestamp(calendar.getTime().getTime());
          Order order = new Order();
        order.setCreate_time(create_time);
        order.setDiachi(diachi);
        order.setEmail(email);
        order.setFullname(fullname);
        order.setOrder_id(order_id);
        order.setSdt(sdt);
        order.setUser_id(user_id);
        orderdao.addOrder_Customer(order);
        for (Cart c : cart) {
            int product_id=c.getP().getMa_san_pham();
            int quantity=c.getQuantity();
            orderdao.addOrder_Product(order_id,product_id,quantity);
            History h = new History( user_id, c.getP().getMa_san_pham(), create_time, c.getQuantity(), (c.getQuantity() * productDAO.getProduct(c.getP().getMa_san_pham()).getGia_ban()));
                historyDAO.addHistory(h);
        }
      
          for(int i=0;i<=cart.size();i++){
          cart.remove(cart.get(0));
          }
        String notice ="Gửi yêu cầu thanh toán thành công";
        request.setAttribute("notice", notice);
        RequestDispatcher rd = request.getRequestDispatcher("order_pending.jsp");
        rd.forward(request, response);
    }

}

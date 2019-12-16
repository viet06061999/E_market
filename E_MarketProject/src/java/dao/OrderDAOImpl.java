/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import model.Product;
import model.User;

/**
 *
 * @author lovelan
 */

public class OrderDAOImpl implements OrderDAO {
        UserDAOImpl userDAO=new UserDAOImpl();
        ProductDAOImpl productDAO= new ProductDAOImpl();
    @Override
    public void addOrder_Product(int order_id, int product_id, int quantity) {
        Connection con = DBConnect.getConnecttion();   
        String sql = "insert into order_product values (" + order_id + "," + product_id + "," + quantity + ",1)";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrder_Customer(Order order) {
        Connection con = DBConnect.getConnecttion();
        String sql = "insert into order_customer values (" + order.getOrder_id() + "," + order.getUser_id() +  ",N'" + order.getFullname() + "','" + order.getEmail() + "','" + order.getSdt() + "',N'" + order.getDiachi() +"','" + order.getCreate_time() + "')";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int countOrder() {
        int count = 0;

        Connection con = DBConnect.getConnecttion();
        String sql = "select * from order_customer";
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              count++;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public List<Order> getAll() {
         Connection con = DBConnect.getConnecttion();
       String sql = "select order_customer.order_id,user_id,ma_san_pham,\n" +
"fullname,email,create_time,sdt,diachi,quantity,id_tinh_trang from order_customer\n" +
"INNER JOIN order_product \n" +
" ON order_customer.order_id=  order_product.order_id ";
//String sql ="select * from order_customer";
        List<Order> list = new ArrayList<Order>();
       
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
               int user_id = rs.getInt("user_id");
                int p_id=rs.getInt("ma_san_pham");
                String  fullname = rs.getString("fullname");
                String email = rs.getString("email");
                Timestamp create_time = rs.getTimestamp("create_time");
               String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");
                int quantity=rs.getInt("quantity");
                int id_tinh_trang=rs.getInt("id_tinh_trang");
                User u= userDAO.getUser(user_id);
                Product p=productDAO.getProduct(p_id);
                Order o = new Order();
                o.setCreate_time(create_time);
                o.setDiachi(diachi);
                o.setEmail(email);
                o.setFullname(fullname);
                o.setOrder_id(order_id);
                o.setSdt(sdt);
                o.setQuantity(quantity);
                o.setP(p);
                o.setU(u);
                if(id_tinh_trang==1){
                o.setTinh_trang("Chờ xác nhận");
                }
                else o.setTinh_trang("Đang giao hang");
                list.add(o);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteOrder(int order_id, int p_id) {
             String sql = "delete from order_product where ma_san_pham="+p_id+
                 "and order_id="+order_id+
                 
                  "\n delete from order_customer where order_id not in(select order_id from order_product)";
		Connection con = DBConnect.getConnecttion();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void confirmOrder(int order_id, int p_id) {
         String sql = "UPDATE order_product SET id_tinh_trang=2 where ma_san_pham="+p_id +" and order_id="+order_id;
		Connection con = DBConnect.getConnecttion();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public List<Order> getPending(int id) {
              Connection con = DBConnect.getConnecttion();
       String sql = "select order_customer.order_id,user_id,ma_san_pham,\n" +
"fullname,email,create_time,sdt,diachi,quantity,id_tinh_trang from order_customer\n" +
"INNER JOIN order_product \n" +
" ON order_customer.order_id=  order_product.order_id where id_tinh_trang=1 and user_id="+id;
//String sql ="select * from order_customer";
        List<Order> list = new ArrayList<Order>();
       
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
               int user_id = rs.getInt("user_id");
                int p_id=rs.getInt("ma_san_pham");
                String  fullname = rs.getString("fullname");
                String email = rs.getString("email");
                Timestamp create_time = rs.getTimestamp("create_time");
               String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");
                int quantity=rs.getInt("quantity");
                int id_tinh_trang=rs.getInt("id_tinh_trang");
                User u= userDAO.getUser(user_id);
                Product p=productDAO.getProduct(p_id);
                Order o = new Order();
                o.setCreate_time(create_time);
                o.setDiachi(diachi);
                o.setEmail(email);
                o.setFullname(fullname);
                o.setOrder_id(order_id);
                o.setSdt(sdt);
                o.setQuantity(quantity);
                o.setP(p);
                o.setU(u);
               
                o.setTinh_trang("Chờ xác nhận");
              
                list.add(o);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Order> getDelivery(int id) {
               Connection con = DBConnect.getConnecttion();
       String sql = "select order_customer.order_id,user_id,ma_san_pham,\n" +
"fullname,email,create_time,sdt,diachi,quantity,id_tinh_trang from order_customer\n" +
"INNER JOIN order_product \n" +
" ON order_customer.order_id=  order_product.order_id where id_tinh_trang=2 and user_id="+id;
//String sql ="select * from order_customer";
        List<Order> list = new ArrayList<Order>();
       
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
               int user_id = rs.getInt("user_id");
                int p_id=rs.getInt("ma_san_pham");
                String  fullname = rs.getString("fullname");
                String email = rs.getString("email");
                Timestamp create_time = rs.getTimestamp("create_time");
               String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");
                int quantity=rs.getInt("quantity");
                int id_tinh_trang=rs.getInt("id_tinh_trang");
                User u= userDAO.getUser(user_id);
                Product p=productDAO.getProduct(p_id);
                Order o = new Order();
                o.setCreate_time(create_time);
                o.setDiachi(diachi);
                o.setEmail(email);
                o.setFullname(fullname);
                o.setOrder_id(order_id);
                o.setSdt(sdt);
                o.setQuantity(quantity);
                o.setP(p);
                o.setU(u);
               
                o.setTinh_trang("Đang giao hàng");
              
                list.add(o);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

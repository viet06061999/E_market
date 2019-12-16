/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Order;

/**
 *
 * @author lovelan
 */
public interface OrderDAO {
    public void addOrder_Product(int order_id,int product_id,int quantity);
    public void addOrder_Customer(Order order);
    public void deleteOrder(int order_id,int p_id);
    public void confirmOrder(int order_id,int p_id);
     public List<Order> getAll();
     public List<Order> getPending(int user_id);
     public List<Order> getDelivery(int user_id);
    public int countOrder();
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Category;
import model.Product;
import model.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(User u) {
        Connection con = DBConnect.getConnecttion();
        String sql = "insert into customer values (N'" + u.getUsername() + "',N'" + u.getPassword() + "',N'" + u.getNgaysinh() + "',N'" + u.getGioitinh() + "',N'" + u.getEmail() + "',N'" + u.getSdt() + "',N'" + u.getDiachi() + "',N'" + u.getRole() + "')";
        try {
            Statement sttm = con.createStatement();
            sttm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean checkUser(String username) {
        Connection con = DBConnect.getConnecttion();
        String sql = "select * from customer where username=N'" + username + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                con.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        UserDAOImpl dao = new UserDAOImpl();
        // dao.addUser(new User(0, "admin", "12345", "admin", "1"));

        System.out.println(dao.login("Nguyễn Bắc Việt", "123"));
    }

    @Override
    public boolean login(String username, String password) {
        Connection con = DBConnect.getConnecttion();

        String sql = "select * from customer where username=N'" + username
                + "' and password=N'" + password + "'";

        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                con.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateUser(User u) {
        Connection con = DBConnect.getConnecttion();
        String sql = "update customer set  password='"+u.getPassword()+"',email='"+u.getEmail()+
                "',diachi=N'"+u.getDiachi()+"',sdt='"+u.getSdt()+"',role='"+u.getRole()+"'where user_id="+u.getUser_id();
        try {
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement(sql);

            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getUser(int id) {
        Connection con = DBConnect.getConnecttion();
        String sql = "select * from customer where user_id=" + id;
        User u = new User();
        try {
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Date ngaysinh = rs.getDate("ngaysinh");
                String gioitinh = rs.getString("gioitinh");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");
                String role = rs.getString("role");
                u = new User(user_id, username, password, ngaysinh, gioitinh, email, sdt, diachi, role);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public User getUser(String a) {
        Connection con = DBConnect.getConnecttion();
        String sql = "select * from customer where username='" + a + "'";
        User u = new User();
        try {
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Date ngaysinh = rs.getDate("ngaysinh");
                String gioitinh = rs.getString("gioitinh");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");
                String role = rs.getString("role");
                u = new User(user_id, username, password, ngaysinh, gioitinh, email, sdt, diachi, role);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public List<User> getList() {
        Connection con = DBConnect.getConnecttion();
        String sql = "select * from customer ";

        List<User> list = new ArrayList<User>();
        try {
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                java.sql.Date ngaysinh = rs.getDate("ngaysinh");
                String gioitinh = rs.getString("gioitinh");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");
                String role = rs.getString("role");
                list.add(new User(id, username, password, ngaysinh, gioitinh, email, sdt, diachi, role));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from history where user_id="+id+
                "delete from order_customer where user_id="+id+
                "DELETE FROM customer WHERE user_id = "+id;

		Connection con = DBConnect.getConnecttion();

		try {
			 Statement sttm = con.createStatement();
                         sttm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

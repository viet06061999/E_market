package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void addProduct(Product p) {
            Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp update_time = new java.sql.Timestamp(calendar.getTime().getTime());
		Connection con = DBConnect.getConnecttion();
		String sql = "insert into product(ma_the_loai,ten_san_pham,gia_ban,hang_san_xuat,thong_tin,last_update) values("
                        +p.getMa_the_loai()+",N'"+p.getTen_san_pham()
                        +"',"+p.getGia_ban()+",N'"+p.getHang_san_xuat()
                        +"',N'"+p.getThong_tin()+"','"+update_time+"')";
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
	public List<Product> getNewProduct() {
		Connection con = DBConnect.getConnecttion();
		   String sql = "select top 8 * from product "
                + "order by last_update desc ";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
         	@Override
	public List<Product> getList() {
		Connection con = DBConnect.getConnecttion();
		   String sql = "select * from product ";
                
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Product> getListByCategory(int id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from product where ma_the_loai='" + id + "'";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getProduct(int id) {
		Connection con = DBConnect.getConnecttion();
                if(con==null) System.out.println("null");
                else System.out.println("ko");
		String sql = "select * from product where ma_san_pham='" + id + "'";
		Product p = new Product();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				p = new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
 
	public static void main(String[] args) {
		//Product p = new Product(0, 1, "S6", "da", 500000.0 ,"","");
		ProductDAOImpl productDAO = new ProductDAOImpl();
		// productDAO.addProduct(p);
		// System.out.println(productDAO.getList());
		System.out.println(productDAO.getProduct(1));
	}

	@Override
	public List<Product> searchList(String ten_san_pham, String ten_the_loai) {
		Connection con = DBConnect.getConnecttion();
		String sql=null;
		if(!ten_san_pham.equals("") && !ten_the_loai.equals("")){
			sql = "SELECT * FROM product, category WHERE ten_san_pham like N'%"+ ten_san_pham +"%' AND product.ma_the_loai = category.ma_the_loai AND ten_the_loai like N'%"+ten_the_loai+"%'";
		}else{
			if(ten_san_pham.equals("")){
				sql="SELECT * FROM product, category WHERE product.ma_the_loai = category.ma_the_loai AND ten_the_loai like N'%"+ten_the_loai+"%'";
			}else{
				if(ten_the_loai.equals("")){
					sql="SELECT * FROM product, category WHERE ten_san_pham like N'%"+ten_san_pham+"%' AND product.ma_the_loai = category.ma_the_loai";
				}
			}
		}
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	
	}

    @Override
    public void update(Product p) {
           Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp update_time = new java.sql.Timestamp(calendar.getTime().getTime());
        String sql = "UPDATE product SET ma_the_loai="+p.getMa_the_loai()+",ten_san_pham=N'"+p.getTen_san_pham()+
           "',hinh_anh='"+p.getHinh_anh()+"',gia_ban="+p.getGia_ban()+",hang_san_xuat='"+p.getHang_san_xuat()+"',thong_tin=N'"+p.getThong_tin()+"',last_update='"+update_time+"'where ma_san_pham="+p.getMa_san_pham();
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
    public void delete(int id) {
          String sql = "delete from order_product where ma_san_pham="+id+
                  " delete from history where ma_san_pham="+id+
                  " delete from product where ma_san_pham="+id+
                  " delete from order_customer where order_id not in(select order_id from order_product)";
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
    public Product getProduct(String ten_san_pham) {
       Connection con = DBConnect.getConnecttion();
                if(con==null) System.out.println("null");
                else System.out.println("ko");
		String sql = "select * from product where ten_san_pham=N'" + ten_san_pham + "'";
		Product p = new Product();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				p = new Product(ma_san_pham, ma_the_loai, ten_san_pham,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
    }
}

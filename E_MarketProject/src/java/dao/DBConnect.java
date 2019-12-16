package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnect {

	public static Connection getConnecttion() {
            Connection conn = null;
		 try { 
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds=(DataSource) envContext.lookup("jdbc/e_market");
            conn=ds.getConnection();
                         }catch (Exception ex) {
                      System.out.println(ex);
                    }
                 return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnecttion());
	}

}

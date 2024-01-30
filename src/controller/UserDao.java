package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class UserDao implements DaoImp {
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mydb";
	String username = "root";
	String password = "abc123";
	
	Connection getConnect() throws ClassNotFoundException, SQLException
     {
    	 Class.forName(driver);
    	 Connection c = DriverManager.getConnection(url, username, password);
    	 return c ;
     }

	@Override
	public int insert(User u) throws ClassNotFoundException, SQLException {

		int a=0;
		Connection c = getConnect();
		Statement s = c.createStatement();
		a= s.executeUpdate("insert into mydb_table (uname,upass) values ('"+u.getUname()+"','"+u.getUpass()+"') ");
		
		return a;
	}

	@Override
	public int update() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int uid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int show() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

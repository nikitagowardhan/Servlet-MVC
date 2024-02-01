package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

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
	public ArrayList<User> show() throws ClassNotFoundException, SQLException {

    ArrayList<User> ul = new  ArrayList<>();
    
    Connection c = getConnect();
	Statement s = c.createStatement();
    ResultSet rs = s.executeQuery("select * from mydb_table");
    
    while(rs.next())
    {
    	User u = new User();
    	
    	u.setUid(rs.getInt(1));
    	u.setUname(rs.getString(2));
    	u.setUpass(rs.getString(3));
    	
    	ul.add(u);
    	
    	
    }
		
		
		return ul;
	}

	
}

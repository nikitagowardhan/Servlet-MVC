package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.User;



public interface DaoImp {
	
	int insert(User u)throws ClassNotFoundException, SQLException;
	 int update()throws ClassNotFoundException, SQLException;
	 int delete(int uid)throws ClassNotFoundException, SQLException;
	 ArrayList<User> show() throws ClassNotFoundException, SQLException;

}

package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserDao;
import model.User;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	PrintWriter p = response.getWriter();
	
	String uname = request.getParameter("uname");
	String upass = request.getParameter("upass");
	
	
	User u = new User(uname,upass);
	
	UserDao db = new UserDao();
	
	try {
		int a= db.insert(u);
		if(a>0)
		{
			p.print("<br>DATA INSERTED<br>");
		}
		
		else
		{
			p.print("<br>DATA NOT INSERTED<br>");

		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		p.println("<p>Error: " + e.getMessage() + "</p>");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

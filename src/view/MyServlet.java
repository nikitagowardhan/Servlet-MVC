package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	p.print("<table>");
	
	p.print("<tr>  <th>UID</th>   <th>UNAME</th>   <th>UPASS</th>    </tr>");
	
	
	
	try {
		ArrayList<User> ul = db.show();
		for(User x: ul)
		{
			p.print("<tr>  <td>"+x.getUid()+"</td>  <td>"+x.getUname()+"</td>  <td>"+x.getUpass()+"</td>   </tr> ");
			
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	p.print("</table>");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

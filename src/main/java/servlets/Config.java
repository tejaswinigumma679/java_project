package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(
		urlPatterns = { "/Config", "/log", "/reg","/display"}, 
		initParams = { 
				@WebInitParam(name = "username", value = "root", description = "Database Username"), 
				@WebInitParam(name = "password", value = "Teju@143", description = "Database Password")
		})
public class Config extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String user = config.getInitParameter("username");
		String pass = config.getInitParameter("password");
		
		String path = request.getServletPath();
		if(path.equals("/reg")) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets",user,pass);
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String query = "insert into student values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			int row = pst.executeUpdate();
			if(row>=1) {
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		else if(path.equals("/log")) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets",user,pass);
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			PreparedStatement pst1 = con.prepareStatement("select * from student where id=?");
			pst1.setInt(1, id);
			String query = "select * from student where id=? and name=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("Home.html");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		else if(path.equals("/display")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets",user,pass);
				String query = "select * from student;";
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("</tr>");
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>"+rs.getInt(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<tr>");
				}
				out.println("</table>");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}

}

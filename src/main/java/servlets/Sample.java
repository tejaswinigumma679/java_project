//package servlets;
//
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebInitParam;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
///**
// * Servlet implementation class Sample
// */
//@WebServlet(
//		urlPatterns = { 
//				"/Sample", 
//		}, 
//		initParams = { 
//				@WebInitParam(name = "username", value = "root", description = "Database Username"), 
//				@WebInitParam(name = "password", value = "Teju@143", description = "Database Password")
//		})
//public class Sample extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String path = request.getServletPath();
//		if(path.equals("/log"));
//		ServletConfig c = getServletConfig();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String username = c.getInitParameter("username");
//			String password = c.getInitParameter("password");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", username, password);
//			int id = Integer.parseInt(request.getParameter("id"));
//			String name = request.getParameter("name");
//			String query = "insert into student values(?,?)";
//			PreparedStatement pst = con.prepareStatement(query);
//			pst.setInt(1, id);
//			pst.setString(2, name);
//			pst.execute();
//			PrintWriter display = response.getWriter();
//			response.setContentType("text/html");
//			display.println("Row inserted:");
//			
//		}
//		catch(Exception e) {
//			System.out.println("Error");
//		}
//	}
//
//}

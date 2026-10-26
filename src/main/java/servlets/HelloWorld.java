package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet({"/HelloWorld"})
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter display = response.getWriter();
		response.setContentType("text/html");
		display.println("Hello World!");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		String path = request.getServletPath();
//		if(path.equals("/login"));
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets","root","Teju@143");
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
//		doGet(request, response);
	}

}

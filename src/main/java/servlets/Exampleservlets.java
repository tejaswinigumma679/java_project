package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Exampleservlets")
public class Exampleservlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Exampleservlets() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("init done");
	}

	
	public void destroy() {
		
		System.out.println("destroy done");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("service done");
	}

}

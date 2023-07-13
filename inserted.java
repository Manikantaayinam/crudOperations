package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inserted
 */
@WebServlet("/inserted")
public class inserted extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public inserted() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a=Integer.parseInt(request.getParameter("id"));
		String b=request.getParameter("name");
		String c=request.getParameter("ema");
		String d=request.getParameter("des");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			PreparedStatement ps=con.prepareStatement("insert into employDetails values(?,?,?,?)");
			ps.setInt(1,a);
			ps.setString(2,b);
			ps.setString(3,c);
			ps.setString(4,d);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		PrintWriter pw=response.getWriter();
	
		pw.println("<html><body><a href='viewDetails1.jsp'>veiw Employee Data</a></body></html>");
	}
	}



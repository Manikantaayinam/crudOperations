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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int k=Integer.parseInt(request.getParameter("i"));
		String name=request.getParameter("n");
		String email=request.getParameter("e");
		String desgination=request.getParameter("d");
		int id=Integer.parseInt(request.getParameter("id"));
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			
			PreparedStatement ps=con.prepareStatement("update employDetails set id=?,name=?,email=?,desgination=? where id=?");
			ps.setInt(1,k);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4,desgination);
			ps.setInt(5,id);
			
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



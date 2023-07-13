<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
*
{
    background-color:white;
}
table, th, td {
  border:2px solid black;
  border-collapse: collapse;
  text-decoration:none
}

</style>
</head>
<body>
	
	
	<br><br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Designation</th>
				<th>Edit</th>
				<th>Delete</th>
				
			</tr>
		</thead>
		<tbody>
		
			<% 
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection cons  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			
			Statement st=cons.createStatement();
			ResultSet rs=st.executeQuery("select * from employDetails");
			PrintWriter pw=response.getWriter();
			while(rs.next())
			{
				out.print("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"<td>"+"<a href='update.html'>edit</a>"+"</td>"+"<td>"+"<a href='delete?id="+rs.getInt(1)+"'>delete</a></td>");
				
				out.print("</tr>");
				
				
			}
			
			pw.println("<html><body><button><a href='inserted.html'>click Here to add new Employee</a></button></body></html><br>");
			
 %>
		</tbody>
	</table>
	
	

</body>
</html>
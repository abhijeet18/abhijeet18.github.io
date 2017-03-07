<%@page import="com.mvc.util.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Page</title>
</head>
<body>
<% 
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	Statement statement=null;
	connection=DBConnection.createConnection();
	statement=connection.createStatement();
	ResultSet resultSet=statement.executeQuery("select * from User");
%>
<table border="1">
    <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email Address</th>
    <th>Phone Number</th>
    <th>Location</th>
  </tr>
    <% while (resultSet.next()) {%>
      <tr>
        <td>
          <%=resultSet.getString("fname")%>
        </td>
        <td>
          <%=resultSet.getString("lname")%>
        </td>
        <td>
          <%=resultSet.getString("email")%>
        </td>
        <td>
          <%=resultSet.getString("phno")%>
        </td>
        <td>
          <%=resultSet.getString("location")%>
        </td>
      </tr>      
    <%}%>
    
    <%
    response.setIntHeader("Refresh",1);
    %>
</tbody>
</table>
</body>
</html>
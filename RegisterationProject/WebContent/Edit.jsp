<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Records</title>
</head>
<body>
<form name="form1" method="post" action="EditServlet">
Username:<input type="text" name="username"><br><br>
Password:<input type="password" name="password"><br><br>
Confirm Password:<input type="password" name="confirm_password"><br><br>
First Name:<input type="text" name="firstname"><br><br>
Last Name:<input type="text" name="lastname"><br><br>
Email:<input type="text" name="email"><br><br>
Phone Number:<input type="text" name="phnumber"><br><br>
Location:<input type="text" name="location"><br><br>
<input type="submit" value="Save">
</body>
</html>
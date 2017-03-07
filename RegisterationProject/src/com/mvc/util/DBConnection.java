package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	public static Connection createConnection()
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/mydatabase";
		String user="root";
		String password="root";
		
		try
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");	
			}
			catch(ClassNotFoundException nfe)
			{
				nfe.printStackTrace();
			}
			con=DriverManager.getConnection(url, user, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}

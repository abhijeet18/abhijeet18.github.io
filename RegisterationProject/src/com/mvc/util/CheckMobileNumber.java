package com.mvc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckMobileNumber 
{
	public static String checkMobileNumber(long number)
	{
		String message="";
		
		try
		{
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			Statement statement=null;
			connection=DBConnection.createConnection();
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select phno from User");
			long phno=Long.parseLong(resultSet.getString("phno"));
			
			if(number==phno)
				message="valid";
			else
				message="invalid";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return message;
	}
}

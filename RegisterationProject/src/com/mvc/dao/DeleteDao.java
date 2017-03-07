package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.util.DBConnection;

public class DeleteDao 
{
	public static void deleteRecord(long phno)
	{
		Connection connection=null;
		try
		{
			PreparedStatement ps=null;
			String sql="delete from User where phno="+phno;
			connection=DBConnection.createConnection();
			ps=connection.prepareStatement(sql);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}

package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;

public class EditDao {
	
	public static String editUser(RegisterBean registerBean)
	{
		String status="";
		
		String username=registerBean.getUsername();
		String password=registerBean.getPassword();
		String confirm_password=registerBean.getConfirm_password();
		String fname=registerBean.getFirstname();
		String lname=registerBean.getLastname();
		String email=registerBean.getEmail();
		long phno=registerBean.getPhno();
		String location=registerBean.getLocation();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try
		{
			connection=DBConnection.createConnection();
			String query="insert into User values(?,?,?,?,?,?,?) where phno=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,confirm_password);
			preparedStatement.setString(4,fname);
			preparedStatement.setString(5,lname);
			preparedStatement.setString(6,email);
			preparedStatement.setString(7,location);
			preparedStatement.setLong(8,phno);
			
			int i=preparedStatement.executeUpdate();
			
			if(i>0)
				status="success";
			else
				status="fail";
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
		
		return status;
	}
}

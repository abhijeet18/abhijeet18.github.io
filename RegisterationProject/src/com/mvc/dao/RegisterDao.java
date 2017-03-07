package com.mvc.dao;

import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao 
{
	public String registerUser(RegisterBean registerBean){
		
		String username=registerBean.getUsername();
		String password=registerBean.getPassword();
		String confirm_password=registerBean.getConfirm_password();
		String fname=registerBean.getFirstname();
		String lname=registerBean.getLastname();
		String email=registerBean.getEmail();
		long phno=registerBean.getPhno();
		String location=registerBean.getLocation();
		String message="";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try
		{
			connection=DBConnection.createConnection();
			String query="insert into User values(?,?,?,?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,confirm_password);
			preparedStatement.setString(4,fname);
			preparedStatement.setString(5,lname);
			preparedStatement.setString(6,email);
			preparedStatement.setLong(7,phno);
			preparedStatement.setString(8,location);
			
			int i=preparedStatement.executeUpdate();
			
			if(i>0)
				message="success";
			else
				message="fail";
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
		return message;
	}
}

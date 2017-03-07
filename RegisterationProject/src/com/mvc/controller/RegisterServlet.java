package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmed_password=request.getParameter("confirm_password");
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String email=request.getParameter("email");
		long phno=0;
		try
		{
			phno=Long.parseLong(request.getParameter("phnumber"));
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		String location=request.getParameter("location");
		
		RegisterBean bean=new RegisterBean();
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setConfirm_password(confirmed_password);
		bean.setFirstname(firstName);
		bean.setLastname(lastName);
		bean.setEmail(email);
		bean.setPhno(phno);
		bean.setLocation(location); */
		
		String act=request.getParameter("act");
		if(act.equals("Save")){
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String confirmed_password=request.getParameter("confirm_password");
			String firstName=request.getParameter("firstname");
			String lastName=request.getParameter("lastname");
			String email=request.getParameter("email");
			long phno=0;
			try
			{
				phno=Long.parseLong(request.getParameter("phnumber"));
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
			
			String location=request.getParameter("location");
			
			RegisterBean bean=new RegisterBean();
			bean.setUsername(username);
			bean.setPassword(password);
			bean.setConfirm_password(confirmed_password);
			bean.setFirstname(firstName);
			bean.setLastname(lastName);
			bean.setEmail(email);
			bean.setPhno(phno);
			bean.setLocation(location);
			
			
			
			RegisterDao dao=new RegisterDao();
			String userRegistered = dao.registerUser(bean);
			if(userRegistered.equals("success")){
				RequestDispatcher dispatcher=request.getRequestDispatcher("/View.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(act.equals("Edit")){
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Edit.jsp");
			dispatcher.forward(request,response);
		}
		else{
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Delete.jsp");
			dispatcher.forward(request,response);
		}
	}
}

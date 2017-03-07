package com.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.RegisterBean;
import com.mvc.dao.EditDao;
import com.mvc.dao.RegisterDao;
import com.mvc.util.CheckMobileNumber;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
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
		
		String message=CheckMobileNumber.checkMobileNumber(phno);
		
		if(message.equals("valid")){
			String status=EditDao.editUser(bean);
			if(status.equals("success")){
				RequestDispatcher dispatcher=request.getRequestDispatcher("/View.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}
}

package com.pathan.auth;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDAO userDAO=new UserDAO();
		
		if(userDAO.validate(username, password)) {
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect(request.getContextPath() +"/welcome.jsp");
			System.out.println("✅ Login success");

		}else {
			request.setAttribute("error","Invalid username or password!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}
}



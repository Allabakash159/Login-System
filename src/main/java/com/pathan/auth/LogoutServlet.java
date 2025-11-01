package com.pathan.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession LogoutSess=request.getSession(false);
		if(LogoutSess!=null) {
			LogoutSess.invalidate();
		}
		response.sendRedirect("login.jsp");
	}
}

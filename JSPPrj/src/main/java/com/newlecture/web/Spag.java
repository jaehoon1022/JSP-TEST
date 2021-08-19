package com.newlecture.web;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;


@WebServlet("/spag")
public class Spag extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String num_ = request.getParameter("n");
		int num = 0;
		
		if(num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		
		String result;
		
		if(num%2 != 0)
			result = "홀수";
		else
			result = "짝수";
		
		request.setAttribute("result",result );
		RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp"); 
		//Spag.java 에서 spag.jsp로 전달하려는 목적
		// 경로 ("/") 를 넣지 않은이유는 url 상 같은 경로에 있기때문에 지정하지 않음																		
		dispatcher.forward(request,response);	// spag.java에 있던 내용이 계속 이어지는 것이기 때문에 forward를 사용
												// 일을 이어가는것이 아니라 새로요청하는 것이라면 forward 대신 redirect
		//forward 에서는 A.jsp -> Servlet -> B.jsp로 넘어감에 따라 A.jsp가 가지고 있는 
		
		
	}
	

}

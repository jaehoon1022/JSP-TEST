package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletContext application = request.getServletContext(); // application 객체 (저장할수 있는 저장소)
		HttpSession session = request.getSession(); // Session 객체 (전역이 아닌 웹브라우저? 서버마다?)
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) 
			v = Integer.parseInt(v_);
		
		// 값을 계산
		if(op.equals("=")) {
			
//			int x = (Integer)application.getAttribute("value"); // 저장되어있는 값을 가져온다.
			int x = (Integer) session.getAttribute("value");
			int y = v; // 새로입력한 v값을 y에 대입
//			String operator = (String) application.getAttribute("op");
			String operator = (String) session.getAttribute("op");
			
			int result = 0;
			
				if(operator.equals("+"))
					result = x + y;
				else
					result = x - y;
				
			out.printf("result is %d", result);
		}
		
		// 값을 저장 + -
		else {
//		application.setAttribute("value", v); // 첫번째 값만 저장이 되는것이다?
//		application.setAttribute("op", op); // 연산자 저장
		session.setAttribute("value", v);
		session.setAttribute("op", op);
		}

	}

}

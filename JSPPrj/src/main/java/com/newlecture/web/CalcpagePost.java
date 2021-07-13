package com.newlecture.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcpagepost")
public class CalcpagePost extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies(); // 쿠키를 읽기위한 변수 선언 여러개의 쿠키를 들이기 때문에 getCookies와 배열로서 작성
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		 
		String exp = "";
		if(cookies != null)
			for(Cookie c : cookies)
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operator != null && operator.equals("C")) {
			exp = "";	// 값을 비우는 작업 쿠키를 지우기위한 사전작업?
		}
		
		else{
		exp += (value == null)?"":value;
		exp += (operator == null)?"":operator;
		exp += (dot == null)?"":dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C"))
			expCookie.setMaxAge(0); // 쿠키가 남지 않고 바로 없어지게 한다. 쿠키를 지우는 방법
		expCookie.setPath("/");
		response.addCookie(expCookie);
		response.sendRedirect("calcpage"); // 서버에서 페이지를 전환해주는 키워드 sendRedirect, redirection 기능

		

	}

}

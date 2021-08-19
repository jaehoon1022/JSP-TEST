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
		
		Cookie[] cookies = request.getCookies(); // ��Ű�� �б����� ���� ���� �������� ��Ű�� ���̱� ������ getCookies�� �迭�μ� �ۼ�
		
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
			exp = "";	// ���� ���� �۾� ��Ű�� ��������� �����۾�?
		}
		
		else{
		exp += (value == null)?"":value;
		exp += (operator == null)?"":operator;
		exp += (dot == null)?"":dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C"))
			expCookie.setMaxAge(0); // ��Ű�� ���� �ʰ� �ٷ� �������� �Ѵ�. ��Ű�� ����� ���
		expCookie.setPath("/");
		response.addCookie(expCookie);
		response.sendRedirect("calcpage"); // �������� �������� ��ȯ���ִ� Ű���� sendRedirect, redirection ���

		

	}

}

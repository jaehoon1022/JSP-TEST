package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8"); 
		// ���������� Ŭ���̾�Ʈ���� UTF-8 �� �����ڴ�!!,����ڿ��� ������ �ڵ����
		response.setContentType("text/html; charset=UTF-8"); 
		// ���������� ���������� �ؼ��Ҽ��� �ֱ⶧���� UTF-8�� �о��!!,���� ���� ��� �ؼ��� ���ΰ�.
		// ���� text/html �̶� �Ͽ��⶧���� ũ�ҿ����� �ν��� �ȵǾ��� <br > �±׸� �ν��ϰ� �ȴ�.
		PrintWriter out = response.getWriter();
//		out.println("Hello JSP~!!");
		
//		for(int i=0; i<100; i++)
//			out.println((i+1)+": �ȳ� Servlet! <br >");
		
		String cnt_ = request.getParameter("cnt");
		
		int cnt = 100;
		
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(request.getParameter("cnt"));
		
		for(int i=0; i<cnt; i++)
			out.println((i+1)+" �ȳ� Servlet!! <br > ");
	
	}

}

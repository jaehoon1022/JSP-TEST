package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8"); 
		// ���������� Ŭ���̾�Ʈ���� UTF-8 �� �����ڴ�!!,����ڿ��� ������ �ڵ����
		response.setContentType("text/html; charset=UTF-8"); 
		// ���������� ���������� �ؼ��Ҽ��� �ֱ⶧���� UTF-8�� �о��!!,���� ���� ��� �ؼ��� ���ΰ�.
		// ���� text/html �̶� �Ͽ��⶧���� ũ�ҿ����� �ν��� �ȵǾ��� <br > �±׸� �ν��ϰ� �ȴ�.
//		request.setCharacterEncoding("UTF-8");
		// �������� ��û�� �Ҷ� UTF-8�� ������ ������Ѵ�. ������������ �ǵ帱���� ������ �ǵ帮���ʰ�, ��ó�� �����ϰų� ���͸� �̿�
		PrintWriter out = response.getWriter();
//		out.println("Hello JSP~!!");
		
//		for(int i=0; i<100; i++)
//			out.println((i+1)+": �ȳ� Servlet! <br >");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
	
	}

}

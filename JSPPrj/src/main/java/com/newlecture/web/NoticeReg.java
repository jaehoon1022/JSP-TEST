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
		// 웹서버에서 클라이언트에게 UTF-8 로 보내겠다!!,사용자에게 보내는 코딩방식
		response.setContentType("text/html; charset=UTF-8"); 
		// 브라우저에서 자의적으로 해석할수도 있기때문에 UTF-8로 읽어라!!,받은 것을 어떻게 해석할 것인가.
		// 또한 text/html 이라 하였기때문에 크롬에서는 인식이 안되었던 <br > 태그를 인식하게 된다.
//		request.setCharacterEncoding("UTF-8");
		// 웹서버로 요청을 할때 UTF-8로 설정을 해줘야한다. 서버설정에서 건드릴수도 있지만 건드리지않고, 위처럼 설정하거나 필터를 이용
		PrintWriter out = response.getWriter();
//		out.println("Hello JSP~!!");
		
//		for(int i=0; i<100; i++)
//			out.println((i+1)+": 안녕 Servlet! <br >");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
	
	}

}

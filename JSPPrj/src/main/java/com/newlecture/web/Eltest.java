package com.newlecture.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

@WebServlet("/eltest")
public class Eltest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result = "EL 표기법 테스트중입니다.";
		
		List<String> list = new ArrayList<>();
		
		list.add("LIST 테스트1");
		list.add("LIST 테스트2");
		list.add(result);
		
											// 저장되는 순서 page(Context)->request->session->application(내장객체)
		request.setAttribute("list",list);	// request뿐 아니라 pageContext,session,application도 가능
		
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("t1", "EL TEST1");
		map.put("t2", "EL TEST2");
		map.put("t3", "EL TEST3");
		
		request.setAttribute("m", map);
		
		String[] str = {"배열 테스트1","배열 테스트2","배열 테스트3"};
		
		request.setAttribute("str", str);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("eltest.jsp"); // 여기서의 request는 다른 의미의 request?
		dispatcher.forward(request, response);
		
		
		
		
		
	}
}

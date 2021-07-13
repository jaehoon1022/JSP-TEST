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

@WebServlet("/eltest")
public class Eltest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result = "EL ǥ��� �׽�Ʈ���Դϴ�.";
		
		List<String> list = new ArrayList<>();
		
		list.add("LIST �׽�Ʈ1");
		list.add("LIST �׽�Ʈ2");
		list.add(result);
		
		
		request.setAttribute("list",list);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("t1", "EL TEST1");
		map.put("t2", "EL TEST2");
		map.put("t3", "EL TEST3");
		
		request.setAttribute("m", map);
		
		String[] str = {"�迭 �׽�Ʈ1","�迭 �׽�Ʈ2","�迭 �׽�Ʈ3"};
		
		request.setAttribute("str", str);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("eltest.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
}

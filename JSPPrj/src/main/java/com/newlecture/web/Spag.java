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
			result = "Ȧ��";
		else
			result = "¦��";
		
		request.setAttribute("result",result );
		RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp"); 
		//Spag.java ���� spag.jsp�� �����Ϸ��� ����
		// ��� ("/") �� ���� ���������� url �� ���� ��ο� �ֱ⶧���� �������� ����																		
		dispatcher.forward(request,response);	// spag.java�� �ִ� ������ ��� �̾����� ���̱� ������ forward�� ���
												// ���� �̾�°��� �ƴ϶� ���ο�û�ϴ� ���̶�� forward ��� redirect
		//forward ������ A.jsp -> Servlet -> B.jsp�� �Ѿ�� ���� A.jsp�� ������ �ִ� 
		
		
	}
	

}

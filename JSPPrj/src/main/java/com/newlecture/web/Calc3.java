package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies(); // 쿠키를 읽기위한 변수 선언 여러개의 쿠키를 들이기 때문에 getCookies와 배열로서 작성
		
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
			
			int x = 0;
			for(Cookie c : cookies) // 원하는 cookie값을 찾을때까지 반복
				if(c.getName().equals("value")) { // 내가심은 value가 있나?, key값을 가지고 검색(쿠키들의 이름을 찾기위해 getName.equals() 사용) 
					x = Integer.parseInt(c.getValue()); // 내가 원하는 value를 찾았을때 x라는 값을 그 value 값으로 바꿔야한다.
					break;								// getValue의 반환값이 String이기 때문에 정수형으로 변환.
					
				}
			
			int y = v; // 새로입력한 v값을 y에 대입
			
			String operator = ""; 
			for(Cookie c : cookies)
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			int result = 0;
			
				if(operator.equals("+"))
					result = x + y;
				else
					result = x - y;
				
			out.printf("result is %d", result);
		}
		
		// 값을 저장 + -
		else {
		Cookie valueCookie = new Cookie("value",String.valueOf(v)); // cookie를 심는 과정, cookie값으로 보낼때는 반드시 문자형으로
		Cookie opCookie = new Cookie("op", op);						// url에 사용할 수 있는 형태, v는 정수형이기때문에 String으로 변환.
		valueCookie.setPath("/calc3");
		
		response.addCookie(valueCookie); // response의 Header에 저장되는 형태로 클라이언트에게 전달.
		response.addCookie(opCookie);
		valueCookie.setPath("/calc3"); // 쿠키가 어느경우에 사용자로부터 전달되어야 하는지에 대한 경로,ex) /notice/ 라 할경우 notice 하위의 모든 url
		valueCookie.setMaxAge(24*60*60); //쿠키의 만료날짜 설정, 기본적으로 초단위
		opCookie.setPath("/calc3");
		response.sendRedirect("calc3.html"); // 서버에서 페이지를 전환해주는 키워드 sendRedirect, redirection 기능
//		application.setAttribute("value", v); // 첫번째 값만 저장이 되는것이다?
//		application.setAttribute("op", op); // 연산자 저장
		}

	}

}

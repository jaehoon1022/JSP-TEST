package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://localhost/test01";	// 데이터베이스 호출할 주소
		String sql = "SELECT * FROM NOTICE ORDER BY ID DESC";		// 쿼리(테이블) 호출

		List<Notice> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","26543434");	// 연결
			Statement st  = con.createStatement();	// 실행도구
			ResultSet rs = st.executeQuery(sql);	// 쿼리를 함수를 통해 설정, 서버쪽에는 결과의 집함이 만들어짐
		
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REGDATE");
				int hit = rs.getInt("HIT");
				
				Notice notice = new Notice(id,title,writerId,regDate,"",hit,"");
				
				list.add(notice);
				
			}
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// 6.0 이후로 cj를 사용
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/notice/list.jsp");
		dispatcher.forward(request, response);
		
	}
	
}

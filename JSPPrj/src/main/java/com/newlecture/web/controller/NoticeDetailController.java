package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);

		String url = "jdbc:mysql://localhost/test01";
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		ArrayList<Notice> list = new ArrayList<>(); // 앞에 랩퍼클래스 작성시 객체생성자?에 생략가능 <>
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","26543434");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			

			rs.next(); // 레코드 한줄만? 출력하면 되기때문에 while 문대신 next() 로 작성
			
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			
//			request.setAttribute("title", title);
//			request.setAttribute("writerId", writerId);
//			request.setAttribute("regDate", regDate);
//			request.setAttribute("content", content);
//			request.setAttribute("hit", hit);
			
			
 			Notice notice = new Notice(id,title,writerId,regDate,content,hit,files);
 			
 			request.setAttribute("n", notice);
 			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp");
		dispatcher.forward(request,response);
	}

}

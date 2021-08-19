package com.hyunsense.web.service;

import com.hyunsense.web.entity.Notice;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {

    private final String url = "jdbc:mysql://localhost/jdbc";	// 데이터베이스 호출할 주소

    public List<Notice> getNoticeList(){

        return getNoticeList("","",1);
    }

    public List<Notice> getNoticeList(int page){

        return getNoticeList("title","",page);
    }

    public List<Notice> getNoticeList(String field,String query,int page){

        String sql = "SELECT * FROM NOTICE WHERE "+ field + " LIKE ? ORDER BY ID" +
                " DESC LIMIT ?,10"; // 쿼리(테이블) 호출

        List<Notice> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");	// 연결
            PreparedStatement st  = con.prepareStatement(sql);	// 실행도구
            st.setString(1,"%" + query + "%");
            st.setInt(2,1+(page-1)*10-1);
            ResultSet rs = st.executeQuery();	// 쿼리를 함수를 통해 설정, 서버쪽에는 결과의 집함이 만들어짐


            while(rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                Date regDate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");

                Notice notice = new Notice(id,title,writerId,regDate,"",hit,"");

                list.add(notice);


            }
        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println("연결 실패");

            e.printStackTrace();
        }

        return list;
    }

    public int getNoticeCount(){

        return getNoticeCount("","");
    }

    public int getNoticeCount(String filed,String query){

        return 0;
    }

    public Notice getNotice(int id){

        String sql = "SELECT * FROM NOTICE WHERE ID=?";

        Notice notice = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            if(rs.next()) {

                int nid = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                Date regDate = rs.getDate("REGDATE");
                String content = rs.getString("CONTENT");
                int hit = rs.getInt("HIT");
                String file = rs.getString("FILES");

                notice = new Notice(nid,title,writerId,regDate,content,hit,file);
            }

            rs.close();
            st.close();
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return notice;
    }

    public Notice getNextNotice(int id) {

        Notice notice = null;

        String sql = "SELECT * FROM NOTICE WHERE ID > (SELECT ID FROM NOTICE WHERE ID=?) LIMIT 0,1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "26543434");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                int id_ = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                String content = rs.getString("CONTENT");
                Date regDate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");

                notice = new Notice(id_, title, writerId, regDate, content, hit, files);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return notice;
    }

    public Notice getPrevNotice(int id){

        Notice notice = null;

        String sql = "SELECT * FROM NOTICE WHERE ID < (SELECT ID FROM NOTICE WHERE ID = ?)" +
                "ORDER BY ID DESC LIMIT 0,1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            if(rs.next()) {

                int id_ = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                String content = rs.getString("CONTENT");
                Date regDate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");

                notice = new Notice(id_, title, writerId, regDate, content, hit, files);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return notice;
    }
}

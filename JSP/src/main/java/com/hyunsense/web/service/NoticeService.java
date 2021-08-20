package com.hyunsense.web.service;

import com.hyunsense.web.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {

    String url = "jdbc:mysql://localhost/jdbc";

    public List<Notice> getNoticeList() throws SQLException {

        return getNoticeList("","",1);
    }

    public List<Notice> getNoticeList(int page){

        return getNoticeList("title","",page);
    }

    public List<Notice> getNoticeList(String field, String query, int page){

        String sql = "SELECT * FROM NOTICE WHERE " + field + " LIKE ? " +
                "ORDER BY ID DESC LIMIT ?,10;";


        List<Notice> list = new ArrayList<Notice>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,"%" + query + "%");
            st.setInt(2,1+(page-1)*10-1);
            ResultSet rs = st.executeQuery();

            while(rs.next()){

            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            String content = rs.getString("CONTENT");
            Date regDate = rs.getDate("REGDATE");
            int hit = rs.getInt("HIT");
            String files = rs.getString("FILES");

            Notice notice = new Notice(id,title,writerId,content,regDate,hit,files);

            list.add(notice);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int getNoticeCount(){

        return getNoticeCount("","");
    }

    public int getNoticeCount(String field,String query){

        return 0;
    }

    public Notice getNotice(int id){

        Notice notice = null;
        String sql = "SELECT * FROM NOTICE WHERE ID = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            if(rs.next()){

                int nid = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                String content = rs.getString("CONTENT");
                Date regDate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");

                notice = new Notice(nid,title,writerId,content,regDate,hit,files);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return notice;
    }

    public Notice getNextNotice(int id){

        Notice notice = null;

        String sql = "SELECT * FROM NOTICE WHERE ID > ? LIMIT 0,1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            if(rs.next()){

                int nid = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                String content = rs.getString("CONTENT");
                Date regDate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");

                notice = new Notice(nid,title,writerId,content,regDate,hit,files);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return notice;
    }

    public Notice getPrevNotice(int id){

        Notice notice = null;

        String sql = "SELECT * FROM NOTICE WHERE ID < ? ORDER BY ID DESC LIMIT 0,1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            if(rs.next()){

                int nid = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                String content = rs.getString("CONTENT");
                Date regDate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");

                notice = new Notice(nid,title,writerId,content,regDate,hit,files);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return notice;
    }
}

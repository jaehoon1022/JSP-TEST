package com.hyunsense.web.service;

import com.hyunsense.web.entity.Notice;

import java.sql.*;
import java.util.List;

public class NoticeService {

    String url = "jdbc:mysql://localhost:3306/jdbc";

    public List<Notice> getNoticeList(){

        return getNoticeList("","",1);
    }

    public List<Notice> getNoticeList(int page){

        return getNoticeList("title","",page);
    }

    public List<Notice> getNoticeList(String field, String query, int page) throws SQLException {

        String sql = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }

    public int getNoticeCount(){

        return getNoticeCount("","");
    }

    public int getNoticeCount(String field,String query){

        return 0;
    }

    public Notice getNotice(int id){

        return null;
    }

    public Notice getNextNotice(int id){

        return null;
    }

    public Notice getPrevNotice(int id){

        return null;
    }
}

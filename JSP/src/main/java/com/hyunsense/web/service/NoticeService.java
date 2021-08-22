package com.hyunsense.web.service;

import com.hyunsense.web.entity.Notice;
import com.hyunsense.web.entity.Notice_View;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {

    String url = "jdbc:mysql://localhost/jdbc";

    public int removeNoticeAll(int[] ids){

        return 0;
    }
    public int pubNoticeAll(int[] ids){

        return 0;
    }
    public int insertNotice(Notice notice){
        int result = 0;

        String sql = "INSERT INTO NOTICE(TITLE,WRITER_ID,CONTENT,FILES,PUB) " +
                "VALUES()";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            PreparedStatement st = con.prepareStatement(sql);
//            st.setString(1,);
            st.setString(2,"hyunsense");

            ResultSet rs = st.executeQuery();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return result;
    }
    public int deleteNotice(int id){

        return 0;
    }
    public int updateNotice(Notice notice){

        return 0;
    }
    public List<Notice_View> getNoticeNewestList(){

        return null;
    }

    public List<Notice_View> getNoticeList() throws SQLException {

        return getNoticeList("","",1);
    }

    public List<Notice_View> getNoticeList(int page){

        return getNoticeList("title","",page);
    }

    public List<Notice_View> getNoticeList(String field, String query, int page){

        String sql = "SELECT * FROM NOTICE_VIEW WHERE " + field + " LIKE ? " +
                "ORDER BY ID DESC LIMIT ?,10;";


        List<Notice_View> list = new ArrayList<Notice_View>();

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
//            String content = rs.getString("CONTENT");
            Date regDate = rs.getDate("REGDATE");
            int hit = rs.getInt("HIT");
            String files = rs.getString("FILES");
            int cnt = rs.getInt("CNT");

            Notice_View notice = new Notice_View(id,title,writerId,regDate,hit,files,cnt);

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

        String sql = "SELECT COUNT(ID) as CNT FROM NOTICE WHERE " + field + " LIKE ? ";
        int cnt = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,"%" + query + "%");
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                cnt = rs.getInt("CNT");

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return cnt;
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

    public int deleteNoticeAll(int[] ids) {

        int result = 0;

        String params = "";

        for(int i=0; i<ids.length; i++) {
            params += ids[i];
            if(i < ids.length-1)
                params += ",";
        }
        String sql = "DELETE NOTICE WHERE ID IN ("+params+")";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","26543434");
            Statement st = con.createStatement();
            result = st.executeUpdate(sql); // update문은 INSERT,UPDATE,DELETE 의 쿼리문을 실행할때사용
                                                // 반환값은 정수


            st.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
package com.hyunsense.web.controller;

import com.hyunsense.web.entity.Notice;
import com.hyunsense.web.service.NoticeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String field_ = request.getParameter("f");
        String query_ = request.getParameter("q");
        String page_ = request.getParameter("p");

        String field = "TITLE";
        if(field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if(query_ != null && !query_.equals(""))
            query = query_;

        int page = 1;
        if(page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);


        NoticeService noticeService = new NoticeService();
        List<Notice> list = noticeService.getNoticeList(field,query,page);

        request.setAttribute("list", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp");
        dispatcher.forward(request,response);

//        System.out.println("현재 page : " + page);


    }
}
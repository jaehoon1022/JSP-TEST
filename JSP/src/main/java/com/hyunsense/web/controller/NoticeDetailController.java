package com.hyunsense.web.controller;

import com.hyunsense.web.entity.Notice;
import com.hyunsense.web.service.NoticeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id_ = request.getParameter("id");
        int id = Integer.parseInt(id_);

        NoticeService service = new NoticeService();
        Notice notice = service.getNotice(id);

        request.setAttribute("n",notice);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp");
        dispatcher.forward(request,response);

    }
}

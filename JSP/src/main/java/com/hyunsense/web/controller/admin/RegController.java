package com.hyunsense.web.controller.admin;

import com.hyunsense.web.entity.Notice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/notice/reg")
public class RegController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String isopen = request.getParameter("open");
        boolean pub = false;
        if(isopen != null)
            pub = true;

        Notice notice = new Notice();

        notice.setTitle(title);
        notice.setContent(content);
        notice.setPub(pub);

        response.sendRedirect("list");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp");
        dispatcher.forward(request,response);
    }
}

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
import java.util.List;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page_ = request.getParameter("p");
        String field_ = request.getParameter("f");
        String query_ = request.getParameter("q");


        String field = "title";
        if(!field_.equals("") && field_ != null)
            field = field_;

        String query = "";
        if(!query_.equals("") && query_ != null)
            query = query_;

        int page = 1;
        if(!page_.equals("") && page_ != null)
            page = Integer.parseInt(page_);

        NoticeService service = new NoticeService();
        List<Notice> list = service.getNoticeList(field,query,page);

        request.setAttribute("list",list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp");
        dispatcher.forward(request,response);

    }
}

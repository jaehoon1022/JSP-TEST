package com.hyunsense.web.controller;

import com.hyunsense.web.entity.Notice;
import com.hyunsense.web.entity.Notice_View;
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

        String field_ = request.getParameter("f");
        String query_ = request.getParameter("q");
        String page_ = request.getParameter("p");


        String field = "title";
        if(field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if(query_ != null && !query_.equals(""))
            query = query_;

        int page = 1;
        if(page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);

        NoticeService service = new NoticeService();
        List<Notice_View> list = service.getNoticeList(field,query,page);
        int cnt = service.getNoticeCount(field,query);

        request.setAttribute("list",list);
        request.setAttribute("cnt",cnt);
        System.out.println(cnt);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp");
        dispatcher.forward(request,response);

    }
}

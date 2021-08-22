package com.hyunsense.web.controller.admin;

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

@WebServlet("/admin/notice/list")
public class ListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] openIds = request.getParameterValues("open-id"); // 배열을 받는것이기 때문에 Values
        String[] delIds = request.getParameterValues("del-id");
        String cmd = request.getParameter("cmd");

        switch(cmd) {
            case "일괄공개":
                for(String openId : openIds)
                    System.out.printf("open Id : %s\n",openId);
                    break;

            case "일괄삭제":
                    NoticeService service = new NoticeService();
                    int[] ids = new int[delIds.length];
                    for(int i=0; i<delIds.length; i++)
                        ids[i] = Integer.parseInt(delIds[i]);

                    int result = service.deleteNoticeAll(ids);
                    break;
        }

        response.sendRedirect("list");



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* list.jsp 의 from 태그 (post)가오면 doGet은 당연히 처리할수가 없다.
        404 : URL이 존재하지 않을경우의 에러
        405 : URL은 있는데 그것을 받을 메소드가 없을 경우의 에러
        403 : URL도 있고 메소드도 있지만 권한이 없을경우의 에러
        */
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp");
        dispatcher.forward(request,response);

    }
}


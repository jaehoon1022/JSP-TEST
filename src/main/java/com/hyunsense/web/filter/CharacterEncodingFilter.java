package com.hyunsense.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter INIT");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("Before Filter");
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
//        System.out.println("After Filter");

    }

    @Override
    public void destroy() {
        System.out.println("Filter Destroy");
    }
}

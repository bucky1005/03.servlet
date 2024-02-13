package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        /* 설명. tomcat 버전에 따라 해당 작업을 수행
            tomcat 10 버전은 기본 인코딩이 UTF-8버전이므로 해당 작업이 필요하지 않음. */
        /* 설명. 요청이 POST 타입이면 요청을 가로채서 인코딩 방식을 UTF-8로 사전 처리 */
        if("POST".equals(httpRequest.getMethod())) {
            httpRequest.setCharacterEncoding("UTF-8");
        }

        /* 설명. 가로채서 설정을 바꾼 요청을 다시 서블릿에 전달(다른 필터가 있는경우 필터로 전달) */
        filterChain.doFilter(httpRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

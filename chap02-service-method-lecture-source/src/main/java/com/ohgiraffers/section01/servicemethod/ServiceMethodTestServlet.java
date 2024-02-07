package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/* 설명. html 페이지(index.jsp의 request-service)에서 request-service를 눌렀을 때 실행되는 클래스임을 명시 */
@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("req = " + req);
        System.out.println("res = " + res);

        /* 설명. HttpServletRequest or Response(자식 클래스)에만 있는 메소드를 사용하기 위해 다운캐스팅 */
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        String httpMethod = httpRequest.getMethod();
        System.out.println("요청 방식: " + httpMethod);

        /* 설명. 넘어온 요청 방식이 get인지 post인지에 따라 값을 다르게 처리하는 코드 */
        if("GET".equals(httpMethod)) {
            doGet(httpRequest, httpResponse);
        } else if ("POST".equals(httpMethod)) {
            doPost(httpRequest, httpResponse);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출됨");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출됨");
    }
}

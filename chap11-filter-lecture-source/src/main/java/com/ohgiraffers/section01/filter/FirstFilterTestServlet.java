package com.ohgiraffers.section01.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/first/filter")
public class FirstFilterTestServlet extends HttpServlet {

    /* 메모. 필터에서 넘어오는 요청을 받을 때에는 항상 Get 방식으로 받는다 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("서블릿으로 get 요청 확인");
    }
}

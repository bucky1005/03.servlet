package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/* 질문. 얘 입력한 이름이 안넘어옴 실행 시 firstName, lastName 표시 안됨 */
/* 설명. redirect는 Get 방식만 사용 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 설명. 리퀘스트 헤더에 있는 쿠키를 불러오는 방법
        *   1. request header에서 쿠키 목록을 쿠키 배열 형태로 꺼내온다.
        *   2. 쿠키의 getName()과 getValue()를 이용해 쿠키에 담긴 키와 밸류를 사용한다.*/
        Cookie[] cookies = req.getCookies();

        String firstName = "";
        String lastName = "";
        for(Cookie cookie: cookies){
            System.out.println(cookie.getName() + ": " + cookie.getValue());

            if("firstName".equals(cookie.getName())){
                firstName = cookie.getValue();
            } else if ("lastName".equals(cookie.getName())) {
                lastName = cookie.getValue();
            }
        }

        /* 메모. for문 이후 값이 잘 담겼는지 확인 */
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3>당신의 이름은 ")
                .append(firstName)
                .append("<br>그리고 성은 ")
                .append(lastName)
                .append(("</h3>"));

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();
    }
}

package com.ohgiraffers.section01.othersite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/* 메모. 서블릿은 WebServlet에 작성된 이름과 url이 1대1로 매칭되어 메소드가 실행된다
*   index.jsp 파일에 다음과 같이 매칭되어있다.
*   <li><a href="othersite">다른 웹 사이트로 redirect 테스트</a></li>*/
@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {
    public OtherSiteRedirectServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청을 받으면 naver 사이트로 redirect");

        /* 설명. 리다이렉트는 우리 서블릿 객체 뿐 아니라 외부사이트로도 연결이 가능하다. */
        resp.sendRedirect("http://www.naver.com");
    }
}

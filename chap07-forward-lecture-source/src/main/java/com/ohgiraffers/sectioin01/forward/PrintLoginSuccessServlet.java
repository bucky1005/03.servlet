package com.ohgiraffers.sectioin01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")       // 어떤 서블릿과 연결될지 매핑하는 것
public class PrintLoginSuccessServlet extends HttpServlet {

    public PrintLoginSuccessServlet() {
    }

    /* 설명. 이전 서블릿이 doPost로 처리하다가 포워딩되면 doPost로 받아야 한다.(doGet은 doGet으로 처리) */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===== 포워딩 된 서블릿에서 넘겨받은 request 객체에 담긴 값 확인 =====");
        System.out.println("이름: " + req.getAttribute("userName"));
        System.out.println("아이디: " + req.getParameter("userId"));
        System.out.println("비밀번호: " + req.getParameter("password"));

        /* 설명. getAttribute()로 가져온 값은 오브젝트 타입이므로 원하는 타입으로 다운캐스팅 해야한다.
        *   getParameter()로 가져온 값은 기본적으로 String 타입이다. */
        String userName = (String) req.getAttribute("userName");

        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3 align=\"center\">\n")
                .append(userName)
                .append("님 환영합니다.</h3>");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();
    }
}

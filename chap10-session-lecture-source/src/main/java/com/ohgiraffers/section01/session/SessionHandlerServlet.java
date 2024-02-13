package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /* 설명. 요청이 서블릿으로 들어올 때 HttpServletRequest에는 JSESSIONID라는 값이 Header에 같이
            포함되어 넘어온다. 그럼 해당 JSESSIONID에 맞는 HttpSession 객체를 생성해서 해당 사용자를
            위한 전용 저장공간을 제공하게 된다.
            (요청을 보낸 사람 전용 Session 저장 공간을 생성하게 된다.)
         */
        /* 메모. 리퀘스트 헤더에 쿠키에는 JSessionId가 들어있음. */
        HttpSession session = req.getSession();

        /* 설명. 따로 설정하지 않으면 session 공간은 30분의 만료 시간을 가진다. */
        /* 메모. 금융사이트, 인증서 발급 사이트 등 로그인 후 30분 제한이 있는 것은 세션 만료에 관한 것이다. */
        System.out.println("session 객체의 defalut 유지 시간(초)" + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60 * 10);        // (초 단위) 10분

        System.out.println("Session 객체의 default 유지 시간(초)");
        System.out.println("session id " + session.getId());        // JSESSIONID 출력

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        /* 메모. Redirect를 send로 전송 시 Post 방식의 요청이여도 doGet로 받아야한다. */
        resp.sendRedirect("redirect");

    }
}

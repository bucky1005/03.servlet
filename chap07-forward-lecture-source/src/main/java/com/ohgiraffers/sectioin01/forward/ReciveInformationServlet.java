package com.ohgiraffers.sectioin01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReciveInformationServlet extends HttpServlet {
    public ReciveInformationServlet() {
    }

    /* 메모. 클라이언트에서 post 방식으로 데이터를 전송 -> 서블릿에서 doPost로 받음 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        /* 설명. 이 부분에서는 id와 pwd에 해당하는 useer의 정보를 select하고 확인하는 비즈니스 로직(BL)이
            수행되어야 한다.(DB에서 이름을 조회해서 해당 유저의 이름을 알게됨)
            우리는 제대로 조회가 되었다는 가정하에 'XXX님 환영합니다'와 같은 메세지를 출력하는 화면을
            만들어 응답해보자.
         */

        /* 메모. DB에서 알아온 이름 정보를 포함하여 request에 담아 print 서블렛으로 정보를 전달함(전달인자, Attribute) */
        req.setAttribute("userName", "홍길동");

        /* 설명. 화면을 만들어 응답하는(화면 잘 만드는) 서블릿에게 포워딩(Forwading, 위임) */
        RequestDispatcher rd = req.getRequestDispatcher("print");   // '/print' 요청을 받을 수 있는 서블릿 정보를 가지고 객체 생성됨.
        rd.forward(req, resp);      // forward 서블릿에서 전달할 정보를 포함하여 print에 위임


    }
}

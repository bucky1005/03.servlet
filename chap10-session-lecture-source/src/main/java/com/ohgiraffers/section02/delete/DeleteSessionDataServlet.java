package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 설명. 서버에 공간을 생성하여 클라이언트의 세션을 저장 */
        HttpSession session = req.getSession();

        System.out.println("attribute 만료 전 firstName: " + session.getAttribute("firstName"));
        System.out.println("attribute 만료 전 lastName: " + session.getAttribute("lastName"));

        /* 메모. 세션 방식으로 로그인 기능을 구현하면 invalidate()기능을 로그아웃으로 사용하게 됨 */
        /* 메모. "무효화" 시키는 것이므로 서버에 생성된 공간은 그대로 남아있고, 안에 담겨있던 세션 정보만 삭제되는 것으로
            해당 공간에 다시 세션 정보를 저장할 수 있다.
         */
        session.invalidate();       // Httpsession 객체의 Attribute 값들을 "무효화"
        System.out.println("attribute 만료 후 firstName: " + session.getAttribute("firstName"));
        System.out.println("attribute 만료 후 lastName: " + session.getAttribute("lastName"));

        /* 설명. session이 무효화 되어 attribute를 가져올 수 없게 되고 500에러 발생 */
    }
}

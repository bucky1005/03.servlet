package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("이름: " + firstName);
        System.out.println("성: " + lastName);

        /* 설명. 쿠키(클라이언트의 브라우저에 저장)를 생성하고 사용하는 방법
            1. 쿠키 인스턴스 생성
            2. 해당 쿠키의 만료 시간 설정
            3. 응답(Response) 해더에 쿠키를 담음
            4. 응답
         */

        /* 설명 1. 쿠키 인스턴스 생성 */
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        /* 설명 2. 쿠키 만료 시간 설정 */
        firstNameCookie.setMaxAge(60 * 60 * 24);            // 초 단위로 설정. 하루를 만료 시간으로 함
        lastNameCookie.setMaxAge(60 * 60 * 12);             // 만료 시간을 12시간으로 설정

        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        /* 설명. Response Header에 쿠키 담기 */
        resp.sendRedirect("redirect");                   // redirect의 경로를 String으로 작성
    }
}

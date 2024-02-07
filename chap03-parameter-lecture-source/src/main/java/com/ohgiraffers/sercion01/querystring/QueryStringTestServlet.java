package com.ohgiraffers.sercion01.querystring;

/* 설명. Tomcat에서 가져온 import
*   해당 코드에서 에러가 나면 java가 아닌 Tomcat에서 에러가 발생한 것
*   Tomcat은 JavaSE 버전에서 사용할 수 없는 JavaEE(기업버전, 유료)의 기능을 쓸 수 있도록 확장 시켜줌*/
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    public QueryStringTestServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        int age = Integer.valueOf(req.getParameter("age"));
        System.out.println("age = " + age);

        java.sql.Date birthDay = java.sql.Date.valueOf(req.getParameter("birthDay"));
        System.out.println("birthDay = " + birthDay);

        String gender = req.getParameter("gender");
        System.out.println("gender = " + gender);

        String national = req.getParameter("national");
        System.out.println("national = " + national);

        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("Arrays.toString(hobbies): " + Arrays.toString(hobbies));
        System.out.println("hobbies = " + hobbies);
    }
}

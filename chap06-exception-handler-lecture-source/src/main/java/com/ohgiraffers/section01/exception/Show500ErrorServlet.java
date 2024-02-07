package com.ohgiraffers.section01.exception;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet ("/show500error")
public class Show500ErrorServlet extends HttpServlet {
    public Show500ErrorServlet() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(500, "500번 에러는 누구 잘못?? 개발자!! 개발자는 누구?? 여러분!!");
    }
}

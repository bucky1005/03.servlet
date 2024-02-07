package com.ohgiraffers.section01.exception;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet ("/show404error")
public class Show404ErrorServlet extends HttpServlet {
    public Show404ErrorServlet() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(404, "페이지를 못찾겠어요!!@");
    }
}

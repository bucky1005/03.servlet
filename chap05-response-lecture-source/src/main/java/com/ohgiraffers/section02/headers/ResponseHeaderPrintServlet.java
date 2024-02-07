package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/header")
public class ResponseHeaderPrintServlet extends HttpServlet {

    public ResponseHeaderPrintServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 설명. 서버의 현재 시간을 동적인 페이지로 만들어 내보내 보자. */
        /* 설명. response 객체를 생성할 때는 MIME 타입 및 인코딩을 고려할 것 */
        /* 질문. 웹에서 응답 헤더 확인하기 누르면 페이지가 뜨는게 아니라 파일이 다운로드 됨 */
        /* 답변. MIME 타입을 잘못적으면 hyper link 연결이 아니라 파일이 다운로드됨
            resp.setContentType("text/html");를 resp.setContentType("html/text");로 잘못 적었었음.
         */
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        long currentTime = System.currentTimeMillis();

        out.print("<h1>" + currentTime + "</h1>");
        out.print("<h1>" + new java.util.Date(currentTime) + "</h1>");

        /* 설명. close 내부에 flush가 들어있지만, 의도적으로 flush를 명시하는 것이 좋음 */
        out.flush();
        out.close();

        /* 설명. response 객체의 header 값에 대한 키 값과 밸류 값을 한번에 확인해보기 */
        Collection<String> responseHeaders = resp.getHeaderNames();
        Iterator<String> iter = responseHeaders.iterator();
        while(iter.hasNext()){
            String headerName = iter.next();
            System.out.println(headerName + ": " + resp.getHeader(headerName));
        }
    }
}

package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key){

        /* 설명. 'password'라는 키값으로 getParameter 사용 시에 그 반환값은 암호화 해서 반환 */
        /* 메모. parameter 값 중 password를 가져올 때에는 암호화를 하여 반환하도록 설정 */
        String value = "";
        if("password".equals(key)){
            System.out.println("패스워드 꺼낼 시");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter("password"));
        } else {    // 그 외의 키값(password값이 아닌 경우) 기존대로 key값 그대로 출력
            value = super.getParameter(key);
        }

        return value;
    }
}

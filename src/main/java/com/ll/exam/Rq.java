package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

   public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;

        try {
            req.setCharacterEncoding("UTF-8"); // 들어오는 파라미터를 UTF-8로 해석
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");// 서블릿이 HTML 파일을 만들 때 UTF-8 로 쓰기
        resp.setContentType("text/html; charset=utf-8");  // HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.


    }

    public int getIntParam(String paramName, int defaulValue) {

        if(paramName == null){
            return defaulValue;
        }

        return Integer.parseInt(req.getParameter(paramName));
    }

    public void appendBody(String str){
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

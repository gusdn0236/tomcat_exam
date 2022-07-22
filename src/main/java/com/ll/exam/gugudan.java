package com.ll.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
public class gugudan extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);


        int dan = rq.getIntParam("dan", 0);
        int limit = rq.getIntParam("limit", 0);


        for (int i = 1; i <= limit; i++) {
            rq.appendBody("%d * %d = %d\n".formatted(dan, i, dan * i));
        }

    }


}

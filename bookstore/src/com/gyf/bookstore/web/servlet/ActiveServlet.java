package com.gyf.bookstore.web.servlet;

import com.gyf.bookstore.exception.UserException;
import com.gyf.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/active")
public class ActiveServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("content-type", "text/html;charset=utf-8");

        //1.获取参数
        String  activecode = request.getParameter("activeCode");

        //2.激活
        UserService us = new UserService();
        try {
            us.activeUser(activecode);
            response.getWriter().write("激活成功");
        } catch (UserException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }


    }

}

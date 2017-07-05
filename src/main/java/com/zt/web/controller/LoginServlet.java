package com.zt.web.controller;

import com.zt.domain.User;
import com.zt.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zt on 2017/7/5.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理登录逻辑");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        BusinessServiceImpl service = new BusinessServiceImpl();
        User user = service.login(username, password);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
            return;
        }
        request.setAttribute("message","用户名或密码错误");
        request.getRequestDispatcher("/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

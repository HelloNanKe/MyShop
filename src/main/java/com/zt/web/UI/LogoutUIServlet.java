package com.zt.web.UI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户注销
 * Created by zt on 2017/7/5.
 */
public class LogoutUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session= request.getSession(false);
       if(session!=null){
           session.removeAttribute("user");
       }
//        request.getRequestDispatcher(request.getContextPath()+"/index.jsp").forward(request,response);
        //注销成功，页面提示3秒后自动跳转到首页
        request.setAttribute("message","注销成功!!3秒后自动跳转到首页 <meta http-equiv='refresh' content='5;url="+request.getContextPath()+"/index.jsp'>");
        request.getRequestDispatcher(request.getContextPath()+"/message.jsp").forward(request,response);
    }
}

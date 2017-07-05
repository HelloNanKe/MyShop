package com.zt.web.controller;

import com.zt.Exception.UserExistExcetion;
import com.zt.Utils.WebUtils;
import com.zt.domain.User;
import com.zt.service.impl.BusinessServiceImpl;
import com.zt.web.formbean.RegisterForm;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zt on 2017/7/5.
 */
//处理注册请求
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //1.对表单字段进行合法性校验（formbean）
        RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
        boolean b = form.validate();


        //2.校验失败，回到表单页面，显示校验失败信息
        if (!b) {
            request.setAttribute("form", form);
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
            return;
        }
        //3.校验成功,则调用service处理注册请求
        BusinessServiceImpl service=new BusinessServiceImpl();
        User u=new User();
        WebUtils.copyBean(form,u);
        System.out.println(u.getUsername()+u.getBirthday());
        u.setId(WebUtils.generateId());
        try {
            service.register(u);
            //6.service处理成功，跳到注册成功页面
            request.setAttribute("message","恭喜你，注册成功");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        } catch (UserExistExcetion userExistExcetion) {
            //4.如果service处理不成功，回到注册页面，提示用户已经存在
           form.getErrors().put("username","注册的用户名已存在");
           request.setAttribute("form",form);
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
            return;
        }catch (Exception e){
            //5.service处理不成功，且是其他问题，跳转到网站全局消息显示页面，
            e.printStackTrace();
            request.setAttribute("message","服务器出现未知错误");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

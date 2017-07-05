package com.zt.web.formbean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zt on 2017/7/5.
 */
public class RegisterForm {
    private String username;
    private String password;
    private String password2;
    private String email;
    private String birthday;
    private String nickname;

    private Map errors=new HashMap();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Map getErrors() {
        return errors;
    }

    public void setErrors(Map errors) {
        this.errors = errors;
    }

    //用户名必须为3-8位，密码为3-8位
    //确认密码一致
    //邮箱不能为空。并且格式合法
    //生日可以为空，不为空时必须合法
    //昵称不能为空，
    public boolean validate(){

        errors.clear();
        boolean isOK=true;
        //校验用户名
        if(this.username==null||this.username.trim().equals("")){
            isOK=false;
            errors.put("username","用户名不能为空");
        }else {
            if(!this.username.matches("[A-Za-z]{3,8}")){
                isOK=false;
                errors.put("username","用户名必须是3到8位字母");
            }
        }
        //校验密码
        if(this.password==null||this.password.trim().equals("")){
            isOK=false;
            errors.put("password","密码不能为空");
        }else {
            if(!this.password.matches("\\d{3,8}")){
                isOK=false;
                errors.put("password","密码必须是3到8位数字");
            }
        }

        //校验密码2
        if(this.password2==null||this.password2.trim().equals("")){
            isOK=false;
            errors.put("password2","密码2不能为空");
        }else {
            if(!this.password.equals(this.password2)){
                isOK=false;
                errors.put("password2","两次密码不一致");
            }
        }
        //校验邮箱
        if(this.email==null||this.email.trim().equals("")){
            isOK=false;
            errors.put("email","邮箱不能为空");
        }else {
            //
           if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
               isOK=false;
               errors.put("email","邮箱格式不合法");
           }
        }

        //昵称不可以为空，且是汉字
        if(this.nickname==null||this.nickname.trim().equals("")){
            isOK=false;
            errors.put("nickname","昵称不能为空");
        }else {
            if(!this.nickname.matches("[\u4e00-\u9fa5]+")){
                isOK=false;
                errors.put("nickname","昵称必须是汉字");
            }
        }

        return isOK;
    }
}

<%--
  Created by IntelliJ IDEA.
  User: zt
  Date: 2017/7/4
  Time: 下午9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/2.0.4/css/bootstrap.min.css">
    <style>
        .form_center {
            width: 500px;
            height: 400px;
            margin: auto;
        }
    </style>
</head>
<body>
<%--用户注册表单--%>

<div class="form_center">
    <form class="form-horizontal" action="/registerServlet" method="post">
        <fieldset>
            <div id="legend" class="">
                <legend class="">用户注册</legend>
            </div>
            <div class="control-group">

                <!-- Text input-->
                <div class="controls">
                    <input type="text" placeholder="用户名" class="input-xlarge" name="username" value="${form.username}">
                    <p class="help-block">${form.errors.username}</p>
                </div>
            </div>


            <div class="control-group">

                <!-- Text input-->
                <div class="controls">
                    <input type="password" placeholder="密码" class="input-xlarge" name="password" value="${form.password}">
                    <p class="help-block">${form.errors.password}</p>
                </div>
            </div>

            <div class="control-group">

                <!-- Text input-->
                <div class="controls">
                    <input type="password" placeholder="确认密码" class="input-xlarge" name="password2" value="${form.password2}">
                    <p class="help-block">${form.errors.password2}</p>
                </div>
            </div>

            <div class="control-group">

                <!-- Text input-->
                <div class="controls">
                    <input type="text" placeholder="email" class="input-xlarge" name="email" value="${form.email}">
                    <p class="help-block">${form.errors.email}</p>
                </div>
            </div>

            <div class="control-group">

                <!-- Text input-->
                <div class="controls">
                    <input type="text" placeholder="生日" class="input-xlarge" name="birthday" value="${form.birthday}">
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">

                <!-- Text input-->
                <div class="controls">
                    <input type="text" placeholder="昵称" class="input-xlarge" name="nickname" value="${form.nickname}">
                    <p class="help-block">${form.errors.nickname}</p>
                </div>
            </div>


            <div class="control-group">
                <label class="control-label"></label>

                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success">登录</button>
                    <button class="btn btn-success">注册</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

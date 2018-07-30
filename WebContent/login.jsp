<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html >
    <head>
        <meta charset="utf-8">
        <title>酒店管理系统登录</title>
           <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
<body>
<div id="loginModal" class="modal show">
      <div class="modal-header">
        <h1 class="text-center text-primary">系统登录</h1>
      </div>
      <div class="modal-body">
        <form action="login" class="form col-md-12 center-block">
          <div class="form-group">
            <input type="text" name="username" class="form-control input-lg" placeholder="用户名">
          </div>
          <div class="form-group">
            <input type="password" name="password" class="form-control input-lg" placeholder="密码">
          </div>
          <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block">登录</button>
          </div>
        </form>
      </div>
    </div>
</body>
        <script> 
        var errori ='<%=request.getParameter("error")%>';
        if(errori=='yes'){
        alert("登录失败!");
                         }
        </script>


</html>
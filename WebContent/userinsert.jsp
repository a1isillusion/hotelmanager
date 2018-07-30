<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@page import="model.*"%>
    <%@page import="java.util.*"%>
    <%@page import="java.sql.*"%>
    <%@page import="java.sql.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>客人注册表单</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form class="form-horizontal" role="form" action="userinsert">
    <div class="form-group">
        <label class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-10">
            <input type="text" id="name" name="name" class="form-control" placeholder="请输入姓名">
        </div>
    </div>
       <div class="form-group">
        <label class="col-sm-2 control-label">性别</label>
        <div class="col-sm-10">
            <input type="text" id="sex" name="sex" class="form-control" placeholder="请输入性别">
        </div>
    </div>
          <div class="form-group">
        <label class="col-sm-2 control-label">证件类型</label>
        <div class="col-sm-10">
            <input type="text" id="papertype" name="papertype" class="form-control" placeholder="请输入证件类型">
        </div>
    </div>
            <div class="form-group">
        <label class="col-sm-2 control-label">证件号码</label>
        <div class="col-sm-10">
            <input type="text" id="papernumber" name="papernumber" class="form-control" placeholder="请输入证件号码">
        </div>
    </div>
         <div class="form-group">
        <label class="col-sm-2 control-label">电话号码</label>
        <div class="col-sm-10">
            <input type="text" id="phonenumber" name="phonenumber" class="form-control" placeholder="请输入电话号码">
        </div>
    </div>
    <div class="form-group">
          <label class="col-sm-2 control-label">确认</label>
        <div class="col-sm-10">
            <input type="submit" class="form-control" id="button" value="确认">
        </div>
    </div>
</form>
</div>
</body>
</html>
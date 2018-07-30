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
    <title>房间添加表单</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form class="form-horizontal" role="form" action="roominsert">
    <div class="form-group">
        <label class="col-sm-2 control-label">房间号</label>
        <div class="col-sm-10">
            <input type="text" id="id" name="id" class="form-control" placeholder="请输入房间号">
        </div>
    </div>
     <div class="form-group">
        <label class="col-sm-2 control-label">房间类型</label>
        <div class="col-sm-10">
            <input type="text" id="type" name="type" class="form-control" placeholder="请输入房间类型">
        </div>
        </div>
          <div class="form-group">
        <label class="col-sm-2 control-label">价格</label>
        <div class="col-sm-10">
            <input type="text" id="price" name="price" class="form-control" placeholder="请输入价格">
        </div>
    </div>
            <div class="form-group">
        <label class="col-sm-2 control-label">押金</label>
        <div class="col-sm-10">
            <input type="text" id="deposit" name="deposit" class="form-control" placeholder="请输入押金">
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
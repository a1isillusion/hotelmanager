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
    <title>入住表单</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script>
$(document).ready(function(){
    $("#customerid").change(function(){
     var ids = $(this).val(); 
     $.post("nowlistinsert", {
         id:ids
     }, function (data) {
    	     var result=JSON.parse(data);
             $("#name").val(result.name); 
             $("#papernumber").val(result.papernumber);
         });
     })
     $("#leavedate").change(function(){
         var date=$("#arrivedate").val();
         var arrivedate=new Date(date.replace(/-/g,"/"));
         date=$("#leavedate").val();
         var leavedate=new Date(date.replace(/-/g,"/"));
         time=leavedate.getTime()-arrivedate.getTime();
         days=(time / (1000 * 60 * 60 * 24));
         $("#price").val(days*<%=request.getParameter("price")%>);
     })
    });
</script>
<body>
<div class="container">
<form class="form-horizontal" role="form" action="nowlistinsertfinal">
    <div class="form-group">
        <label class="col-sm-2 control-label">客人id</label>
        <div class="col-sm-10">
            <input type="text" id="customerid" name="customerid" class="form-control" placeholder="请输入客人id">
        </div>
    </div>
     <div class="form-group">
        <label class="col-sm-2 control-label">客人姓名</label>
        <div class="col-sm-10">
            <input type="text" id="name" name="name" class="form-control" >
        </div>
    </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">证件号码</label>
        <div class="col-sm-10">
            <input type="text" id="papernumber" name="papernumber" class="form-control" >
        </div>
    </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">房间号</label>
        <div class="col-sm-10">
            <input type="text" id="id" name="id" class="form-control" value=<%=request.getParameter("id")%> >
        </div>
    </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">入住时间</label>
        <div class="col-sm-10">
            <input type="text" id="arrivedate" name="arrivedate" class="form-control" placeholder="请输入入住时间">
        </div>
    </div>
          <div class="form-group">
        <label class="col-sm-2 control-label">离开时间</label>
        <div class="col-sm-10">
             <input type="text" id="leavedate" name="leavedate" class="form-control" placeholder="请输入离开时间">
        </div>
    </div>
          <div class="form-group">
        <label class="col-sm-2 control-label">价格</label>
        <div class="col-sm-10">
            <input type="text" id="price" name="price" class="form-control">
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
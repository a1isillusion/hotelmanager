<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<script>
$(document).ready(function(){
<%
  if(manager.rank==1){
	  %>
	    $("#roominsert").hide(); 
		$("#roomshowchoose").hide();  
		$("#roomshowchoose1").hide();  
		$("#nowlistdelete").hide();  
		$("#reservationdelete").hide();
		$("#userinsert").hide();  
<%
  }
%>
<%
if(manager.rank==2){
	  %>
	$("#userinsert").hide();  
<%
}
%>
    });
</script>
<ul class="nav nav-tabs">
    <li class="active"><a href="login.jsp"> 酒店管理系统</a></li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            前台操作 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="roominsert" href="roominsert.jsp">房间添加</a></li>
            <li><a id="roomshowchoose" href="roomshowchoose.jsp">开房登记</a></li>
            <li><a id="roomshow" href="roomshow.jsp">房状态查看</a></li>
            <li><a id="nowlistdelete" href="nowlistdelete.jsp">退房</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            预订管理<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="roomshowchoose1" href="roomshowchoose.jsp">预订房间</a></li>
            <li><a id="reservationdelete" href="reservationdelete.jsp">解除预订</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            信息查询 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="usershow" href="usershow.jsp">客人信息列表</a></li>
            <li><a id="nowlistshow" href="nowlistshow.jsp">在住客人列表</a></li>
            <li><a id="reservationshow" href="reservationshow.jsp">预订客人列表</a></li>
            <li><a id="historylistshow" href="historylistshow.jsp">历史客人列表</a></li>
        </ul>
    </li>
     <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            注册 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="userinsert" href="userinsert.jsp">客人注册</a></li>
        </ul>
    </li>
</ul>

</body>
</html>
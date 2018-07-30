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
    <title>预订客人列表</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script>
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
 $(".delete").on("click", function () {
	        var ids = $(this).attr("id");
	        $.post("reservationturn", {
	            id:ids
	        }, function (msg) {
	            if (msg == "ok") {
	                alert("入住成功");
	                $("#tr" + ids).remove();
	            }
	        })
	    })
})
</script>
<body>

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
      <div class="modal-header">
        <h1 class="text-center text-primary">预订客人列表</h1>
      </div>
<table class="table">
    <thead>
    <tr>
        <th>客人id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>房间类型</th>
        <th>房间id</th>
        <th>价格</th>
        <th>证件类型</th>
        <th>证件号码</th>
        <th>联系方式</th>
        <th>到达时间</th>
        <th>离开时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <% 
    Getconnection g=new  Getconnection();
	 try{
		 ResultSet rs=g.stmt.executeQuery("select * from reservation");
		  while(rs.next()){
			 int customerid=rs.getInt("customerid");
			 String name=rs.getString("name");  
			 String sex=rs.getString("sex");
			 String type=rs.getString("type");
			 int id=rs.getInt("id");
			 int price=rs.getInt("price");
		     String papertype=rs.getString("papertype");
		     String papernumber=rs.getString("papernumber");
		     String phonenumber=rs.getString("papernumber");
		     Date arrivedate=rs.getDate("arrivedate");
	         Date leavedate=rs.getDate("leavedate");
    %>
    <tr id="tr<%=customerid %>">
        <td><%=customerid %></td>
        <td><%=name %></td>
        <td><%=sex %></td>
        <td><%=type %></td>
        <td><%=id %></td>
        <td><%=price %></td>
        <td><%=papertype%></td>
        <td><%=papernumber %></td>
        <td><%=phonenumber %></td>
        <td><%=arrivedate %></td>
        <td><%=leavedate %></td>
        <td><a id="<%=customerid %>" class="delete">入住</a><td>
    </tr>
    
    <%
 }
 rs.close();
 g.close();
}catch(SQLException se){
   // 处理 JDBC 错误
   se.printStackTrace();
}catch(Exception e){
   // 处理 Class.forName 错误
   e.printStackTrace();  
}
    
    %>
    </tbody>
</table>

</body>
</html>
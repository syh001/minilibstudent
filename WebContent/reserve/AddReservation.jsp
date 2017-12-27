<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="minilib.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="color.jpg" repeat=no_repeat>
<form action="findTitleManageReservationAction.action" method="post">
<style>
.AddReservation{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="AddReservation">
<center>

======输入书名关键字检索图书======

	
  <p>请输入书名关键字
  <p><input type="text" name = "title.title"><br>
  
   <p> <input type="submit" value = "提交查询">
    
   
 
</center>
</div>
</form>
</body>
</html>
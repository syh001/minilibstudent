<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>

<!-- 管理员选择读者名字，加入预定单，如果读者id之前显示有逾期（这个就留给管理员自己判断），则这次不允许他预定 -->

<body background="color.jpg" repeat=no_repeat>
<style>
.queryborrowname{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="queryborrowname">
${message}
<form method="post" action="addReserveManageReservationAction.action" >
<center>
<p><div align="center">==所有预订者id==</div>
<select name="reserve.readerid" >
<c:forEach items="${requestScope.allBorrowid}" var="reserve">
	<option value="${reserve.readerid} ">${reserve.readerid}</option>
</c:forEach> 
</select><br>
<p><div align="center"><input type="submit" name = "sumbit" value = "接收此人的预定">
</center>
</form>
</div>
</body>

</html>
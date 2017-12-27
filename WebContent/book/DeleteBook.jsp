<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8" import="minilib.vo.*" %>
	<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除图书</title>
</head>


<body background="color.jpg" repeat=no_repeat>
<style>
.DeleteBook{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="DeleteBook">
${message}
<form method="post" action="deleteTitleManageTitlesAction.action" >
<center>
请选择要删除的图书类别：
<p><select name="book.typeid" >
<c:forEach items="${requestScope.alltypelist}" var="booktype">
	<option value="${booktype.codeid} ">${booktype.codename}</option>
</c:forEach> 
</select><br>
请输入要删除的书名：
<p><input type="text" name="book.title" >

<p><input type="submit" name = "sumbit" value = "删除图书">
</center>
</form>
</div>
</body>
</html>
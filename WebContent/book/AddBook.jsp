<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8" import="minilib.vo.*" %>
	<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加图书</title>
</head>
<body background="color.jpg" repeat=no_repeat>
<style>
.AddBook{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="AddBook">
${message}
<form method="post" action="addTitleManageTitlesAction.action" >
<center>
<p><div align="center">==图书类别==</div>
<select name="book.typeid" >
<c:forEach items="${requestScope.alltypelist}" var="booktype">
	<option value="${booktype.codeid} ">${booktype.codename}</option>
</c:forEach> 
</select><br>
<p><div align="center">==图书名==</div>
<p><div align="center"><input type="text" name="book.title" >
<p><div align="center"><input type="submit" name = "sumbit" value = "增加图书">
</center>
</form>
</div>
</body>
</html>
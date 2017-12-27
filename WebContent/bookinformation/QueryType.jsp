<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="color.jpg" repeat=no_repeat>
<style>
.QueryType{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="QueryType">
<form method="post" action="findAllTypeManageBookinfoAction.action">

<p><div align="center">======请输入图书类别ID======</div>
<p><div align="center"><input type="text" name="type.codeid">
<p><div align="center"><input type="submit" value="查询">
</form>
</div>
</body>
</html>
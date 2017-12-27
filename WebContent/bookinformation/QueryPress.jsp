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
.QueryPress{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="QueryPress">
<form method="post" action="findAllPressManageBookinfoAction.action">
	<p><div align="center"><input type="text" name="codepress.codeid" id="context" value="">
	<p><input type="submit" name="submit" value="查询现有出版社">
</form> 
</div>
</body>
</html>
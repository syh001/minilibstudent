<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="minilib.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="color.jpg" repeat=no_repeat>
<style>
.AddPress{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="AddPress">
<form action="addPressManageBookinfoAction.action" method="post">
<p><div align="center">======请输入要添加的出版社号======
<p><div align="center"><input type="text" name="codepress.codeid">
<p><div align="center">======请输入要添加的出版社名======
<p><div align="center"><input type="text" name="codepress.codename">
<p><div align="center"><input type="submit" name="addpress" value="增加此出版社">

</form>
</div>
</body>
</html>
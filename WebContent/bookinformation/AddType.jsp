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
.AddType{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="AddType">
<form method="post" action="addTypeManageBookinfoAction.action" >
<p><div align="center">======请输入图书类型号======
<p><div align="center"><input type="text" name="type.codeid"></div>
<p><div align="center">======请输入图书类型名======
<p><div align="center"><input type="text" name="type.codename">
<input type="submit" value="增加"> 
</form>  
</div>
</body>

</html>
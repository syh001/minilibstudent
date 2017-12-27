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
.QueryspecificBook{
	 font-size: 24px; 
   color: #FFFFCC; 
   font-style: italic; 
}</style>

<div class="QueryspecificBook">
<form action="findSpecificTitleManageTitlesAction.action" method="post">
<center>
<h2>======模糊查询======</h2>


       <p> 请输入书名关键字
        <p><input type="text" name = "book.title">

    <input type="submit" value = "提交查询">
    
   
 
</center>
</form>
</div>
</body>
</html>
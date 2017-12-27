<!-- 
/***********************************************************
*													
*														
*	项目名称：				
*	子系统名：			
*	功能名称：	
*	完成人员：					
*	完成时间：					
*								
*									
************************************************************/
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>小型图书资料管理系统登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
	<form method="post" action="login.action" name="frm">
	    小型图书资料管理系统-版本_0.1.0 2017年10月7日<br/><br/>
	    用户账户： <input type="text" size="30" name="username" value="mia"><br/>
	    登录密码： <input type="password" size="30" name="userpass" value="0715"><br/><br/>
	  <input type="submit" value="登录系统" name="login">
	  <input type="reset" value="重新填写" name="reset"><br/><br/>
      Copyright@ 2009-2017 版权所有 辽宁师范大学
	</form>
  </body>
</html>
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body background="color.jpg" repeat=no_repeat>
<h2><div align="center">======Welcome, please choose======</div></h2>
<h2><p><div align="center"><a href="managerLoginAction.action">I'm manager</a></h2>
<h2><p><div align="center"><a href="readerLoginAction.action">I'm already in!(reader)</a></h2>
<h2><p><div align="center"><a href="newreaderLoginAction.action">I'm new here!(reader)</a></h2>
<!-- <form name="form1" action="LoginAction.minilib.action" method="post"> 
<h2>管理员登录入口</h2>
<p>用户名:<input type="text" name="user.username">
<p>密码:<input type="text" name="user.userpass">
<p><input type="reset" value="重置">
<p><input type="submit" value="提交">
-->

</body>
</html>
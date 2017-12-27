<%@ page language="java" contentType="text/html; charset=UTF-8"
	import = "java.util.*" pageEncoding="UTF-8" import="minilib.vo.*"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
</head>
<body background="color.jpg" repeat=no_repeat>
<p>已成功添加！</p>

 <table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
			                      <tr bgcolor="#fba661" height="25">
				                        <td width="10%" bgcolor= "#a88462">
											<div align="center">
												出版社id
											</div>
										</td>
										<td width="13%" bgcolor="#a88462">
											<div align="center">
												出版社名
											</div>
										</td>
									</tr>
									<%
									CodePress code = (CodePress)request.getAttribute("codepress");
									System.out.println(code.getCodeid());
									System.out.println(code.getCodename());
										%>
										<tr bgcolor="#f3f3f3" height="25">
											<td width="10%">
												<div align="center">
												
													<%=code.getCodeid() %>
												</div>
											</td> 
											
											<td width="13%">
												<div align="center">
													<%=code.getCodename() %>
												</div>
											</td> 
	</table>
</body>
</html>
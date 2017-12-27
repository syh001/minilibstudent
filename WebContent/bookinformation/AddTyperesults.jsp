<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="minilib.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="color.jpg" repeat=no_repeat>
<p>已成功添加！
 <table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
			                      <tr bgcolor="#fba661" height="25">
				                        <td width="10%" bgcolor= "#a88462">
											<div align="center">
												图书类型号
											</div>
										</td>
										<td width="13%" bgcolor="#a88462">
											<div align="center">
												图书类型名
											</div>
										</td>
									</tr>
									<%
									CodeBookType type = (CodeBookType)request.getAttribute("type");
										%>
										<tr bgcolor="#f3f3f3" height="25">
											<td width="10%">
												<div align="center">
												
													<%=type.getCodeid() %>
												</div>
											</td> 
											
											<td width="13%">
												<div align="center">
													<%=type.getCodename() %>
												</div>
											</td> 
	</table>
</body>
</html>
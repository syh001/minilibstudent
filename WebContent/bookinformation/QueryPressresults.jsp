<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="color.jpg" repeat=no_repeat>
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
										<c:forEach items = "${requestScope.allpress}" var="codepress" varStatus="status">
										<tr bgcolor="#f3f3f3" height="25">
											<td width="10%">
												<div align="center">
													${codepress.codeid}
												</div>
											</td> 
											
											<td width="13%">
												<div align="center">
													${codepress.codename}
												</div>
											</td> 
										</c:forEach>
	</table>
</body>
</html>
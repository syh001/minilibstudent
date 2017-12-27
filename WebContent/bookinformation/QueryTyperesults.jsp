<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "minilib.vo.*" import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="color.jpg" repeat=no_repeat>
<%
ArrayList<CodeBookType> list = (ArrayList<CodeBookType>)request.getAttribute("alltypelist");
%>
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
			                      <tr bgcolor="#fba661" height="25">
				                        <td width="16%" bgcolor= "#a88462">
											<div align="center">
												图书类别ID
											</div>
										</td>
										<td width="20%" bgcolor="#a88462">
											<div align="center">
												图书类别名称
											</div>
										</td>
										<%
											Iterator<CodeBookType> its = list.iterator();
											while (its.hasNext()) {
												CodeBookType t = new CodeBookType(); 
												t = (CodeBookType) its.next();		
												
									%>
												<tr bgcolor="#f3f3f3" height="25">
													<td width="10%">
														<div align="center">
															<%=t.getCodeid()%>
														</div>
													</td>
													<td width="13%">
														<div align="center">
															<%=t.getCodename()%>
														</div>
													</td>
												</tr>
									<%
										}
									%> 											
	</table>
</body>
</html>
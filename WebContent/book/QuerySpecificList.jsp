<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="minilib.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="color.jpg" repeat=no_repeat>
<% 
List<Title> list = (ArrayList<Title>)session.getAttribute("findSpecificTitle");

%>
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
			                      <tr bgcolor="#fba661" height="25">
				                        <td width="10%" bgcolor= "#a88462">
											<div align="center">
												ISBN
											</div>
										</td>
										<td width="13%" bgcolor="#a88462">
											<div align="center">
												书名
											</div>
										</td>
										<td width="12%" bgcolor="#a88462">
											<div align="center">
												作者
											</div>
										</td>
										<td width="13%" bgcolor="#a88462">
											<div align="center">
												出版社
											</div>
									
										</td>
									
									</tr>	
									
									<%
							for(int i = 0; i<list.size(); i++)
							{
								Title t = list.get(i);
									%>			
									 
												<tr bgcolor="#f3f3f3" height="25">
													<td width="10%">
														<div align="center">
															<%=t.getIsbn()%>
														</div>
													</td>
													<td width="13%">
														<div align="center">
															<%=t.getTitle()%>
														</div>
													</td>
													<td width="12%">
														<div align="center">
															<%=t.getAuthors()%>
														</div>
													</td>
													<td width="12%">
														<div align="center">
															<%=t.getPressid()%>
														</div>
													</td>
													
												</tr>
											
									<%
										}
									%>
																										
	</table>

</body>
</html>
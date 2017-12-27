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
 <table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
			                      <tr bgcolor="#a88462" height="25">
				                        <td width="10%" bgcolor= "#a88462">
											<div align="center">
												读者id
											</div>
										</td>
										 
										<td width="13%" bgcolor="#a88462">
											<div align="center">
												读者名
											</div>
										</td>
										<td width="12%" bgcolor="#a88462">
											<div align="center">
												图书类型
											</div>
										</td>
										<td width="13%" bgcolor="#a88462">
											<div align="center">
												书名
											</div>
										</td>
										<td width="13%" bgcolor="#a88462">
											<div align="center">
												出版社
											</div>
										</td>
									</tr>
									<%
									/* List list = (List)request.getAttribute("alltitleslist");
									Iterator its = list.iterator();
									while(its.hasNext()){
										Title t = new Title();
										title.
										t=(Title)its.next(); */
										
										%>
										<c:forEach items = "${requestScope.allreservelist}" var="reserve" varStatus="status">
										<tr bgcolor="#f3f3f3" height="25">
											<td width="10%">
												<div align="center">
													${reserve.readerid}
												</div>
											</td> 
											
											
											
											<td width="13%">
												<div align="center">
													${reserve.readername}
												</div>
											</td> 
											
											<td width="12%">
												<div align="center">
													${reserve.typeid}
												</div>
											</td> 
											
											<td width="13%">
												<div align="center">
													${reserve.title}
												</div>
											</td> 
											<td width="13%">
												<div align="center">
													${reserve.pressid}
												</div>
											</td> 
										</c:forEach>
	</table>

</body>
</html>
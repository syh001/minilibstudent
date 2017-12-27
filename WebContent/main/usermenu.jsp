<!-- 
/***********************************************************
*                         
*                           
* 项目名称：         
* 子系统名：     
* 功能名称： 
* 完成人员：         
* 完成时间：         
*               
*                 
************************************************************/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html><head><title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script language="JavaScript" type="text/JavaScript">
  	function showMenu(id){
  		var menu = "menu_" + id;
  		var item=document.getElementById(menu);
  		for(i=1;i<=6;i++){
  			document.getElementById("menu_0" + i).style.display="none";
  		}
  		item.style.display = "block";
  	}
  </script>

</head>

<body background="color.jpg" repeat=no_repeat>
  <!--  -->
  <table border="1" bgcolor="#a88462" width="100%"><tr>
  <td onClick="showMenu('01');" align="center">用户功能</td>
  </tr></table>
  <table border="1" id="menu_01" style="display:block;" bgcolor="#f2ecde" width="100%">
    <tr><td align="center"><a href="http://localhost:8080/minilibstudent/reserve/AddReservation.jsp" target="main" title="增加图书">预定图书</a></td></tr>
    <tr><td align="center"><a href="http://localhost:8080/minilibstudent/reserve/CancelReservation.jsp" target="main" title="删除图书">取消预订</a></td></tr>
    <tr><td align="center"><a href="http://localhost:8080/minilibstudent/book/QueryBook.jsp" target="main" title="查询图书">查询图书</a></td></tr>
     <tr><td align="center"><a href="http://localhost:8080/minilibstudent/book/QueryspecificBook.jsp" target="main" title="模糊查询图书">模糊查询图书</a></td></tr>
  </table>
</body>

</html>

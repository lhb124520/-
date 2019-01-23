<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>人力资源管理系统--部门管理</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">



</script>
  <%
  String fmt="yyyy-MM-dd HH:mm:ss"; 
  java.util.Date date=new java.util.Date();
  java.text.SimpleDateFormat simpleDateFormat=new java.text.SimpleDateFormat(fmt);
  String str = simpleDateFormat.format(date);
  session.setAttribute("date", str);
  %>
</head>
<body>
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="center">
				<table width="801" height="48" border="0" cellpadding="0"
					cellspacing="0" background="images/center1.jpg">
					<tr>
						<td valign="top">
							<table width="494">
								<tr>
									<td width="45" height="25">&nbsp;</td>
									<td width="437" valign="bottom"><font color="#66583D"><b>部门管理&nbsp;</b></font>&gt;
										<font color="#FF0000"> 部门添加</font></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table width="801" height="436" border="0" cellpadding="0"
					cellspacing="0" background="images/center2.jpg">
					<tr>
						<td height="436" valign="top" align="center">
						<form action="/person_manager/abook" method="post">
								<table width="355" border="1" cellpadding="1" cellspacing="1"
									bordercolor="#FFFFFF" bgcolor="66583D">
									<tr>
										<th width="79" height="30"><span class="word_white" >部门名称：</span></th>
										<td width="263" bgcolor="#FFFFFF"><input type="text" placeholder="请输入部门名称" name="department.dt_name" id="name"/></td>
									</tr>
									<tr>
										<th height="30"><span class="word_white">创建时间：</span></th>
										<td bgcolor="#FFFFFF"><input type="text" value=${date} name="department.dt_createTime" /></td>
									</tr>
									<tr>
										<th height="30"><span class="word_white">备注信息：</span></th>
										<td bgcolor="#FFFFFF"><input type="text" placeholder="请输入部门备注信息" name="department.dt_bz" id="bz"/></td>
									</tr>
								</table>
								<br>
								<input type="submit" value="保存"/>
                              &nbsp;&nbsp;
                      <input type="reset" value="重置">
            
							</form></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>
</body>
</html>

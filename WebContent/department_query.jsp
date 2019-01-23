<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>人力资源管理系统--部门管理</title>
<style type="text/css">
.navLi {
	float: right;
	list-style-type: none;
}

 ul{
	margin-right: 200px;
}
</style>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").focus(function() {

			$("#query").val("");
		});
	});
	function doQuery() {
		document.forms[0].action = "/person_manager/qbook";
		document.forms[0].submit();
	}
	function doUpdate(id) {
		document.getElementById('hidId').value = id;

		document.forms[0].action = "/person_manager/gbook";

		document.forms[0].submit();
	}
	function doDelete(id) {
		if (confirm("你确定删除该部门以及该部门下的员工吗？")) {
			document.getElementById('hidId').value = id;
			document.forms[0].action = "/person_manager/dbook";
			document.forms[0].submit();
		}

	}
</script>

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
										<font color="#FF0000"> 部门查询</font></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
	
				<table width="801" height="436" border="0" cellpadding="0"
					cellspacing="0" background="images/center2.jpg">
					<tr>
						<td height="436" valign="top" align="center">


							<table width="650" border="1" cellpadding="1" cellspacing="1"
								bordercolor="#FFFFFF" bgcolor="66583D">

								<tr>

									<th width="200px" height="50" colspan="2">部门名称</th>
									<th width="200" height="50" colspan="2">
										<form action="/person_manager/qbook" method="post">
											<input type="text" value="请输入您要查询的部门"
												style="height: 80%; width: 80%" id="query" name="dep"
												value="${param.dep}" /> <input id="hidId" type="hidden"
												name="id" />
										</form>
									</th>

									<th width="150" height="50"><input type="button"
										value="查询" style="height: 20px; width: 40px"
										onclick="doQuery()" /></th>


								</tr>

								<tr align="center">

									<th width="46" height="20"><span class="word_white">序号</span></th>
									<th width="109"><span class="word_white">部门名称</span></th>
									<th width="138"><span class="word_white">创建时间</span></th>
									<th width="203"><span class="word_white">备注</span></th>
									<th width="88"><span class="word_white">操作</span></th>
								</tr>
								<c:forEach items="${result}" var="department">
									<tr align="center" bgcolor="#FFFFFF">
										<td style="height: 50px">${department.id}</td>
										<td>${department.dt_name}</td>
										<td>${department.dt_createTime}</td>
										<td>${department.dt_bz}</td>
										<td><input type="button" value="修改"
											onclick="doUpdate('${department.id}')"> <input
											type="button" value="删除"
											onclick="doDelete('${department.id}')"></td>
									</tr>
								</c:forEach>
							</table>

							<table width="650">
								<tr>
									<td>
										<div align="right"></div>
									</td>
								</tr>
							</table>



							<table width="650">
								<tr align="right">
									<td><a href="edit.jsp">添加部门</a></td>
								</tr>
							</table>
							
						</td>
					</tr>
					<tr>
					<td>
					
								<ul>
									<li class="navLi"><input type="button"
										onclick="javascript:location.href='${request.contextPath}\paging?cp=${data.last}'"
										value="末页" /></li>
										<li class="navLi">
										
									<input type="button"
										onclick="javascript:location.href='${request.contextPath}\paging?cp=${data.next}'"
										value="下一页" /></li>
									
									<li class="navLi"><input type="text"
										onblur="javascript:location.href=${request.contextPath}'\paging?cp='+this.value;" /></li>
									
									<li class="navLi"><input type="button"
										onclick="javascript:location.href='${request.contextPath}\paging?cp=${data.previous}'"
										value="上一页" /></li>
										<li class="navLi"><input type="button"
										onclick="javascript:location.href='${request.contextPath}\paging?cp=${data.first}'"
										value="首页" /></li>
								</ul>
								
					</td>
					</tr>
				</table>
	
			</td>
		</tr>
		
	</table>
	
</body>
</html>

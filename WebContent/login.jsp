<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>企业人力资源管理系统--登录</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/JavaScript">
	
	$(function() {
		$("#user").blur(function() {
			if($("#user").val()==""){
				window.alert("请输入账号");
				
			}
			
		});
		$("#pwd").blur(function() {
			if($("#pwd").val()==""){
				window.alert("请输入密码");
				
			}
			
		});
		
		
	});
</script>

<body>

	<table width="100%" height="100%" border="0" align="center"
		cellpadding="0" cellspacing="0">
		<tr>
			<td><form action="/person_manager/login" method="post">
					<table width="550" height="371" border="0" align="center"
						cellpadding="0" cellspacing="0"
						background="images/managerLand.jpg">
						<tr>
							<td valign="bottom">
								<table height="100" align="center">
								        <tr>
                                    <td colspan="2" id="tip">${tip}</td>
                                          </tr>
									<tr>
										<td width="50" height="63">账号：</td>
										<td width="149"><input type="text" name="username" id="user"></td>
										<td width="50">密码：</td>
										<td width="150"><input type="password" name="password" id="pwd"></td>
										<td width="70"><input type=image src="images/land.gif" ></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</form>
				</td>
		</tr>
	</table>

</body>
</html>

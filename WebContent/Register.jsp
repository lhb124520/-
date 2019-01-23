<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业人力资源管理系统--注册</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/JavaScript">
$(function (){
$("#sub").click(function(){
	
			var num=0;
		
			if($("#user").val()==""){
				window.alert("请输入账号");				
				num++;
			}	
			if($("#pwd").val()==""){
				window.alert("请输入密码");				
				num++;
			}
		if(num<=0){
			alert("success")
			return true;
		}else{
			return false;
		}
		
      });

     });	
</script>


<body>

<table width="100%" height="100%" border="0" align="center"
		cellpadding="0" cellspacing="0">
		<tr>
			<td>
					<table width="550" height="371" border="0" align="center"
						cellpadding="0" cellspacing="0"
						background="images/managerLand.jpg">
						<tr>
							<td valign="bottom">
							<form action="/person_manager/reg" method="post">
								<table height="100" align="center">
									<tr>
										<td width="50" height="63">账号：</td>
										<td width="149"><input type="text" name="account" placeholder="请输入账号" id="user"></td>
										<td width="50">密码：</td>
										<td width="150"><input type="password" name="password" placeholder="请输入密码" id="pwd"></td>
										<td width="70"><input  type="submit" value="注册" id="sub"/> </td>
									</tr>
								</table>
								</form>
							</td>
						</tr>
					</table>
				</td>
		</tr>
	</table>

</body>
</html>
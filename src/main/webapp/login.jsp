<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>



	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码

				$("#captchaImage").prop("src","${pageContext.request.contextPath}/admin/getCode?time="+new Date());
			});


			$("#Username").textbox({
				required: true
			});
			$("#Password").textbox({
				required:true,
				type:"password"
			});
			



			$("#LoginButton").linkbutton({

				onClick:function(){
                    $("#loginForm").form("submit", {
                        url: "${pageContext.request.contextPath}/admin/queryOne",
                        onSubmit:function(){
                            $("#loginForm").form("validate");
                        },
                        success:function(data){

                            if(data=='"ok"'){

                           		 location.href="${pageContext.request.contextPath}/main/main.jsp";
							}else{

                                $("#span").text(data);
							}
                        }
                    })
				}
			});
		});

	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm"  method="post" >

				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input  name="name"  id="Username" />
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input  name="password" id="Password" />
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/admin/getCode" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<a id="LoginButton">登录</a>
						</td>
					</tr>
				</tbody></table>
				<p id="span" align="center" style="color: red"></p>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>
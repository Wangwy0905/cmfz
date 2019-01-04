<%--<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head >
	
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" >
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css"/>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script>

	</script>
</head>
<body>


    <h1>添加商品</h1>

&lt;%&ndash;    <form action="${pageContext.request.contextPath}/lucene/lucene" method="post" enctype="multipart/form-data" >
		商品名称:<input id="textName" name="name"><br/>
		商品价格:<input id="textPrice" name="price"><br/>
		商品描述:<input id="textDesc" name="desc"><br/>
		商品图片:<input id="file" name="file"><br/>
		商品状态:<input id="textStatus" name="status"><br/>
		商品上产日期:<input type="Date" name="pubDate"><br/>
		商品产地:<input type="textAddress" name="address"><br/>
		<input type="submit" value="提交"><br/>
    </form>&ndash;%&gt;
	<form action="${pageContext.request.contextPath}/lucene/lucene" method="post" enctype="multipart/form-data" >
		商品名称:<input type="text" name="name"><br/>
		商品价格:<input type="text" name="price"><br/>
		商品描述:<input type="text" name="desc"><br/>
		商品图片:<input type="file" name="file"><br/>
		商品状态:<input type="text" name="status"><br/>
		商品上产日期:<input type="Date" name="pubDate"><br/>
		商品产地:<input type="text" name="address"><br/>
		<input type="submit" value="提交"><br/>
	</form>


</body>
</html>--%>

<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head >
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css"/>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
        $(function(){
            $("#name").textbox({
                required:true
            });
            $("#price").textbox({
                required:true
            });
            $("#url").filebox({
                required:true,
                editable:false
            });
            $("#date").datebox({
                required:true,
                editable:false
            });
            $("#place").textbox({
                required:true
            });


            $("#submitBtn").linkbutton({
                text:"提交",
                plain:true,
                iconCls:"icon-save",
                onClick:function(){
                    /*提交表单*/
                    $("#productForm").form("submit",{
                        url:"${pageContext.request.contextPath}/lucene/lucene",
                        onSubmit:function(){
                            return $("#productForm").form("validate");
                        },
                        success:function(){
                            $.messager.show({
                                title:"系统提示",
                                msg:"添加成功",
                                showType:"show",
                                width:300,
                                height:200
                            });
                            $("#productForm").form("reset");
                        }
                    });
                }
            });


            $("#toMainBtn").linkbutton({
                text:"首页",
                plain:true,
                iconCls:"icon-back",
                onClick:function(){
                    location.href="${pageContext.request.contextPath}/main.jsp";
                }
            });
        });
	</script>


</head>
<body>


<h1>添加商品</h1>
<form id="productForm" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>商品名称:</td><td><input id="name" name="name"/></td>
		</tr>
		<tr>
			<td>商品价格:</td><td><input id="price" name="price"/></td>
		</tr>
		<tr>
			<td>商品描述:</td><td><textarea id="describe" name="desc"></textarea></td>
		</tr>
		<tr>
			<td>商品图片:</td><td><input id="url" name="file"/></td>
		</tr>
		<tr>
			<td>商品状态:</td><td><input type="radio" value="Y" name="status"/>在售
			<input type="radio" value="Y" name="status"/>下架</td>
		</tr>
		<tr>
			<td>生产日期:</td><td><input id="date" name="pubDate"/></td>
		</tr>
		<tr>
			<td>商品产地:</td><td><input id="place" name="address"/></td>
		</tr>
	</table>
</form>

<a id="submitBtn"/>
<a id="toMainBtn"/>

</body>
</html>

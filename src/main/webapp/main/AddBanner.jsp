<%--
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
            $(function(){
                $("#")
            });
    </script>
</head>
<body>

<input id="BannerTitle" name="title"/>
<input id="BannerImgPath" name="imgPath"/>
<input id="BannerStatus" name="status"/>
<input id="BannerDescption" name="descption"/>
</body>
</html>--%>
<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function(){
        $("#bannerTitleInput").textbox({
            required:true
        });
        $("#bannerDescriptionInput").textbox({
            required:true
        });
        $("#bannerStatusInput").textbox({
            required:true
        });
        $("#addBannerCancleBtn").linkbutton({
            text:"返回上级",
            plain:true,
            iconCls:"icon-back",
            onClick:function(){
                location.href="${pageContext.request.contextPath}/main/main.jsp";
            }
        });
        $("#addBannerSubmitBtn").linkbutton({
            text:"提交",
            plain:true,
            iconCls:"icon-ok",
            onClick:function(){
                /*提交表单*/
                $("#addBannerForm").form("submit",{
                    url:"${pageContext.request.contextPath}/banner/insert",
                    onSubmit:function(){
                        return $("#addBannerForm").form("validate");
                    },
                    success:function(){
                        $.messager.show({
                            title:"系统提示",
                            msg:"添加成功!",
                            showType:"show",
                            width:300,
                            height:200
                        });
                        $("#BannerTable").datagrid("reload");
                        $("#Bannerdialog").dialog("close");
                    }
                });
            }
        });
    });
</script>


<form id="addBannerForm" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>标题</td>
            <td><input id="bannerTitleInput" name="title"/></td>
        </tr>
        <tr>
            <td>状态</td>
            <td><input id="bannerStatusInput" name="status"/></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><input id="bannerDescriptionInput" name="descption"/></td>
        </tr>
        <tr>
            <td>图片</td>
            <td><input type="file" name="file"/></td>
        </tr>
    </table>
</form>
<a id="addBannerSubmitBtn"></a>
<a id="addBannerCancleBtn"></a>
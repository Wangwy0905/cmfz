﻿<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css"/>
    <link rel="stylesheet" id="s_superplus_css_lnk" type="text/css" href="${pageContext.request.contextPath}/index_files/super_min_0cb4b166.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index_files/card_min_e8bcf60d.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index_files/ubase_83c8f0ba.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index_files/mt_min_d0e7c6d2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index_files/nsguide_a8cbc2e7.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index_files/super_ext_c02dfc40.css">
<%--
    <script type="text/javascript" src="${pageContext.request.contextPath}/index_files/jquery.js"></script>
--%>


<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script src="../echarts.min.js"></script>

    <script src="../china.js"></script>


    <script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>





<script type="text/javascript">
	<!--菜单处理-->
    $(function(){

         $.get("${pageContext.request.contextPath}/menu/queryAll",
            function (result) {
                for(var i=0;i<result.length;i++) {

                    var second = result[i].menuList;

                    var a = "";
                        for (var j = 0; j < second.length; j++) {
                            if(second[j].title=="用户活跃度"){
                                <shiro:hasPermission name="user:d">
                                    a += "<p style='text-align: center'><a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabs('" + second[j].title + "','" + second[j].iconcls + "','" + second[j].url + "')\" data-options=\"iconCls:'icon-add'\">" + second[j].title + "</a></p>";
                                </shiro:hasPermission>
                            }else if(second[j].title=="用户分布图"){
                                <shiro:hasPermission name="user:d">
                                    a += "<p style='text-align: center'><a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabs('" + second[j].title + "','" + second[j].iconcls + "','" + second[j].url + "')\" data-options=\"iconCls:'icon-add'\">" + second[j].title + "</a></p>";
                                </shiro:hasPermission>
                            }else{
                                a += "<p style='text-align: center'><a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabs('" + second[j].title + "','" + second[j].iconcls + "','" + second[j].url + "')\" data-options=\"iconCls:'icon-add'\">" + second[j].title + "</a></p>";

                            }

                        }

                        if(result[i].title =="用户模块") {
                            <shiro:hasRole name="super">
                            $("#aa").accordion("add", {
                                title: result[i].title,
                                iconCls: result[i].iconcls,
                                content: a,
                                selected: false
                            });
                            </shiro:hasRole>
                        }else{
                            $("#aa").accordion("add", {
                                title: result[i].title,
                                iconCls: result[i].iconcls,
                                content: a,
                                selected: false
                            });
                        }

                    }

            },"json")


    });
	function addTabs(title,iconcls,url){
	    console.log(title);

        if( $("#tt").tabs("exists",title)){
            $("#tt").tabs("select",title);
        }else{
            $("#tt").tabs("add",{
               title:title,
               iconCls:iconcls,
               href:"${pageContext.request.contextPath}/"+url ,
                selected: true,
                closable:true

            });
        }
    }
    function  test() {
        $.get("${pageContext.request.contextPath}/admin/logoutAdmin",
                function(result){
                    location.href="${pageContext.request.contextPath}/admin/logoutAdmin";
                },"JSON"
        )
    }

</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
        <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:<shiro:principal></shiro:principal>&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="" onclick="test()" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">


		</div>  
    </div>


    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>
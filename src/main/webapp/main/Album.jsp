<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        var row2;
        var row3;
        var chapterId;
        var toolbar = [{
            iconCls: 'icon-add',
            text: "专辑详情",
            handler: function () {
                var row = $("#album").treegrid("getSelected");
                console.log(row);
                if (! isNaN(row.id)) {
                    //获取指定行
                    $("#AlbumDialog").dialog("open");
                    row2=row.id;
                    row3=row.coverImg;
                } else {
                        $.messager.alert("警告","请先选中专辑")
                }

            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-edit',
            handler: function () {

                $("#AlbumDialog2").dialog("open");
            }
        }, '-', {
            text: "添加音频",
            iconCls: 'icon-remove',
            handler: function () {
                var rowChapter = $("#album").treegrid("getSelected");
                //console.log(rowChapter.id);
                if (! isNaN(rowChapter.id)) {
                    //获取指定行
                    chapterId=rowChapter.id;
                    $("#AlbumDialog3").dialog("open");

                } else {
                    $.messager.alert("警告","请先选中专辑");
                }
            }
        }, '-', {
            text: "音频下载",
            iconCls: 'icon-save',
            handler: function () {

            }
        }]
        $(function () {
            $('#album').treegrid({

                url:'${pageContext.request.contextPath}/album/queryAll',
                idField:'id',
                treeField:'title',
                columns:[[
                    {field:'title',title:'名字',width:60},
                    {field:'url',title:'下载路径',width:80,formatter:kkUrl},
                    {field:'size',title:'章节大小',width:80},
                    {field:'duration',title:'章节时长(min)',width:80}
                ]],
                fit:true,
                fitColumns:true,
                toolbar:toolbar,
            });

            $("#AlbumDialog").dialog({
                title:"专辑信息框",
                width:800,
                height:400,
                closed:true,
                href:'${pageContext.request.contextPath}/main/showAlbum.jsp'
            });
            $("#AlbumDialog2").dialog({
                title:"专辑信息框",
                width:800,
                height:400,
                closed:true,
                href:'${pageContext.request.contextPath}/main/addAlbum.jsp'
            });
            $("#AlbumDialog3").dialog({
                title:"专辑信息框",
                width:800,
                height:400,
                closed:true,
                href:'${pageContext.request.contextPath}/main/addChapter.jsp'
            });

        })
        function kkUrl(value,row,index){
            return "<audio controls='controls' src='${pageContext.request.contextPath}/"+value+"'/>";
        }

    </script>
</head>
<body>

<table id="album"></table>
<div id="AlbumDialog"></div>
<div id="AlbumDialog2"></div>
<div id="AlbumDialog3"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

    <script type="text/javascript">
        var row2;
        var row3;
        var chapterId;
        var toolbar = [{
            iconCls: 'icon-add',
            text: "专辑详情",
            handler: function () {
                var row = $("#album").treegrid("getSelected");

                if (row==null) {
                    $.messager.alert("警告","请先选中专辑");
                }else if (! isNaN(row.id)) {
                    //获取指定行
                    console.log(row.id);
                    row2=row.id;
                    row3=row.coverImg;
                    $("#AlbumDialog").dialog("open");

                } else{
                    $.messager.alert("警告","请先选中专辑");
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
                if (rowChapter == null) {
                    $.messager.alert("警告", "请先选中专辑");
                }else{
                    if (!isNaN(rowChapter.id)) {
                        //获取指定行
                        chapterId = rowChapter.id;
                        $("#AlbumDialog3").dialog("open");

                    } else {
                        $.messager.alert("警告", "请先选中专辑");
                    }
                }
            }
        }, '-', {
            text: "音频下载",
            iconCls: 'icon-save',
            handler: function () {
                var rowDownload = $("#album").treegrid("getSelected");
                if(rowDownload==null){
                    $.messager.alert("警告","请先选中章节");
                }else if(isNaN(rowDownload.id)){
                    location.href="${pageContext.request.contextPath}/chapter/downLoad?name="+rowDownload.url+"&title="+rowDownload.title;

                }else{
                    $.messager.alert("警告","请先选中章节");
                }

            }
        }]
        $(function () {
            $('#album').treegrid({

                onDblClickRow:function(row){
                    $("#audio_dialog").dialog("open")
                    $("#audio_url").prop("src","${pageContext.request.contextPath}/video/"+row.url);
                },
                url:'${pageContext.request.contextPath}/album/queryAll',
                idField:'id',
                treeField:'title',
                columns:[[
                    {field:'title',title:'名字',width:60},
                    {field:'url',title:'下载路径',width:80},
                    {field:'size',title:'章节大小',width:80},
                    {field:'duration',title:'章节时长(s)',width:80}
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
                cache:false,
                href:'${pageContext.request.contextPath}/main/showAlbum.jsp'
            });
            $("#AlbumDialog2").dialog({
                title:"专辑添加框",
                width:800,
                height:400,
                closed:true,
                href:'${pageContext.request.contextPath}/main/addAlbum.jsp'
            });
            $("#AlbumDialog3").dialog({
                title:"播放栏",
                width:800,
                height:400,
                closed:true,
                href:'${pageContext.request.contextPath}/main/addChapter.jsp'
            });




        })



    </script>

<table id="album"></table>
<div id="AlbumDialog"></div>
<div id="AlbumDialog2"></div>
<div id="AlbumDialog3"></div>

<div id="audio_dialog" class="easyui-dialog" title="双击播放" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <audio id="audio_url" src="" controls="controls" autoplay="autoplay">

    </audio>
</div>

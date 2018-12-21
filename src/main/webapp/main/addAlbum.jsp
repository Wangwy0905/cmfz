<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function(){
        $("#AlbumTitle").textbox({
           required:true
        });
        $("#AlbumAuthor").textbox({
            required:true
        });
        $("#AlbumBroadcast").textbox({
            required:true
        });
        $("#AlbumScore").textbox({
            required:true
        });
        $("#AlbumCount").textbox({
            required:true
        });

        $("#AlbumBrief").textbox({
            required:true
        });

        $("#AddAlbumButton").linkbutton({
                plain:true,
                 onClick:function(){
                $("#AddAlbumForm").form("submit",{
                    url:"${pageContext.request.contextPath}/album/insertAlbum",
                    onSubmit:function(){
                        $("#AddAlbumForm").form("validate");
                    },
                    success:function(){
                        $.messager.show({
                            title:"系统提示",
                            msg:"添加成功!",
                            showType:"show",
                            width:300,
                            height:200
                        });
                        $("#album").treegrid("reload");
                        $("#AlbumDialog2").dialog("close");
                    }

                })
            }
        });
    });

</script>

<form id="AddAlbumForm" method="post" enctype="multipart/form-data">
    <table>

        <tr>
            <td>
                标题:
            </td>
            <td >
                <input id="AlbumTitle" name="title"/>
            </td>
        </tr>
        <tr>
            <td >
                作者:
            </td>
            <td>
                <input id="AlbumAuthor"  name="author"/>
            </td>
        </tr>
        <tr>
            <td >
                播音:
            </td>
            <td >
                <input id="AlbumBroadcast"  name="broadcast"/>
            </td>
        </tr>

        <tr>
            <td >
                分数:
            </td>
            <td >
                <input id="AlbumScore"  name="score"/>
            </td>
        </tr>
        <tr>
            <td >
                集数:
            </td>
            <td >
                <input id="AlbumCount"  name="count"/>
            </td>
        </tr>
        <tr>
            <td >
                封面:
            </td>
            <td >
                <input type="file" name="file"/>
            </td>
        </tr>

        <tr>
            <td >
                详细介绍:
            </td>
            <td >
                <input id="AlbumBrief"  name="brief"/>
            </td>
        </tr>


    </table>
    <a id="AddAlbumButton">提交</a>


</form>

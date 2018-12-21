<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function(){
        $("#ChapterTitle").textbox({
            required:true
        });
        $("#ChapterSize").textbox({
            required:true
        });
        $("#ChapterDuration").textbox({
            required:true
        });
        $("#AddChapterButton").linkbutton({
            plain:true,
            onClick:function(){
                $("#AddChapterForm").form("submit",{
                    url:"${pageContext.request.contextPath}/chapter/insertChapter?albumId="+chapterId,
                    onSubmit:function(){
                        $("#AddChapterForm").form("validate");
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
                        $("#AlbumDialog3").dialog("close");
                    }

                })
            }
        });
    });

</script>

<form id="AddChapterForm" method="post" enctype="multipart/form-data">
    <table>

        <tr>
            <td>
                标题:
            </td>
            <td >
                <input id="ChapterTitle" name="title"/>
            </td>
        </tr>

        <tr>
            <td >
                播音:
            </td>
            <td >
                <input id="ChapterDuration"  name="duration"/>
            </td>
        </tr>
            <tr>
            <td >
                音频:
            </td>
            <td >
                <input type="file" name="file"/>
            </td>
        </tr>

    </table>
    <a id="AddChapterButton">提交</a>


</form>

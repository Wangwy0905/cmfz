<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>



<script type="text/javascript">
    $(function(){

        //页面加载后  调load查一个
        $("#AlbumForm").form("load","${pageContext.request.contextPath}/album/queryOneAlbum?id="+row2);


        var path="${pageContext.request.contextPath}/"+row3;
        $("#AlbumCoverImg").prop("src",path);

    });

</script>

<form id="AlbumForm" method="post">
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
                 <img id="AlbumCoverImg" src="" name="coverImg"/>
            </td>
        </tr>
        <tr>
            <td >
                上传日期:
            </td>
            <td >
                <input id="AlbumPubDate"  name="pubDate"/>
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



</form>

<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<script type="text/javascript">

    var goEasy = new GoEasy({
        appkey: "BC-ed05bee3bbf2424a8b7aba1b41673fe4"
    });
    goEasy.subscribe({
        channel: "141",
        onMessage: function (message) {

            $("#show2").append("wwy:"+message.content +"&#10;");
        }
    });

    function test1(){

        var goEasy = new GoEasy({
            appkey: "BC-ed05bee3bbf2424a8b7aba1b41673fe4"
        });
        goEasy.publish({
            channel: "140",
            message: $("#text").val()
        });

        $("#show2").append("jt55:"+$("#text").val()+"&#10;");
        $("#text").prop("value","");
    }

</script>
<textarea type="text" id="show2" rows="20px" cols="40"></textarea><br/>
<input type="text" id="text" value=""/>
<input  type="button"  onclick="test1()" value="提交"/><br/>

</body>
</html>
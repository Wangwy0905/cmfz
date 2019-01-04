<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">

    var goEasy = new GoEasy({
         appkey: "BC-ed05bee3bbf2424a8b7aba1b41673fe4"
    });
    goEasy.subscribe({
        channel: "140",
        onMessage: function (message) {
            //alert("Channel:" + message.channel + " content:" + message.content);

            $("#show").append("jt55:"+message.content +"&#10;");


        }
    });

    function test(){

       //var t= $("#text").val();
        var goEasy = new GoEasy({
            appkey: "BC-ed05bee3bbf2424a8b7aba1b41673fe4"
        });
        goEasy.publish({
            channel:"141",
            message: $("#text").val()
        });

        $("#show").append("wwy:"+$("#text").val()+"&#10;");
        $("#text").prop("value","");
    }

</script>
<textarea type="text" id="show" rows="20px" cols="40"></textarea><br/>
<input type="text" id="text"/>
<input  type="button" id="botton"  onclick="test()" value="提交"/><br/>

</body>
</html>
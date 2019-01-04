<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="always" name="referrer">
    <title>百度一下，你就知道</title>
    <style id="style_super_inline">
        html {
            color: #000;
            overflow-y: scroll;
            overflow: -moz-scrollbars

        }

        body,button,input,select,textarea {
            font: 12px arial
        }


        .s_lm_hide {
            display: none !important
        }


        .s-lite-version #m {
            padding-top: 125px
        }

        #head_wrapper .s-p-top {
            height: 61.8%;
            min-height: 181px;
            position: relative;
            z-index: 0;
            text-align: center
        }

        #s_lg_img {
            position: absolute;
            bottom: 10px;
            left: 50%;
            margin-left: -135px
        }

        #head_wrapper .s-word-top {
            margin-top: -1px;
            margin-bottom: 11px
        }

        #form {
            z-index: 1
        }

        #s_lm_wrap {
            position: absolute;
            margin-left: -447px;
            bottom: 0;
            left: 50%;
            z-index: 0;
            height: 30px;
            width: 895px;
            line-height: 30px;
            text-align: center
        }

        #lm {
            color: #666;
            height: 15px;
            line-height: 16px;
            padding: 7px 0
        }

        #lm a {
            text-decoration: underline;
            color: #666
        }

        #nv {
            margin: 0 0 5px;
            _margin-bottom: 4px;
            padding: 2px 0 0;
            text-align: left;
            text-indent: 50px
        }

        #nv a,#nv b {
            margin-left: 19px
        }

        #nv a,#nv b,.btn,#lk {
            font-size: 14px
        }

        .s_form {
            width: 641px;
            height: 100%;
            min-height: 293px;
            margin: 0 auto 0 auto;
            text-align: left;
            z-index: 100
        }

        .s-down .s_form {
            padding-left: 0;
            margin-top: 0;
            min-height: 0
        }

        .s_form .tools {
            position: absolute;
            right: -55px
        }

        .s_form_wrapper {
            height: 100%
        }

        #head_wrapper.s-down #kw,#kw {
            width: 500px;
            height: 40px;
            padding: 9px 7px;
            font: 16px arial;
            border: 1px solid #b8b8b8;
            border-bottom: 1px solid #ccc;
            border-right: 0;
            vertical-align: top;
            outline: none;
            box-shadow: none
        }

        .s-skin-hasbg .self-btn {
            background:
                    url(https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/spis7_d7c9959e.png)
                    no-repeat #fff
        }

        .btn {
            color: white;
            background-color: #38f;
            width: 102px;
            height: 38px;
            font-size: 16px;
            border: 0
        }

    </style>
    <link rel="stylesheet" id="s_superplus_css_lnk" type="text/css" href="${pageContext.request.contextPath}/index_files/super_min_0cb4b166.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index_files/card_min_e8bcf60d.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index_files/ubase_83c8f0ba.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index_files/mt_min_d0e7c6d2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index_files/nsguide_a8cbc2e7.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index_files/super_ext_c02dfc40.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/index_files/jquery.js"></script>
    <script type="text/javascript">
        function test(){

            var kw=$("#kw").val();
           // alert(kw);
            $.post("${pageContext.request.contextPath}/lucene/showLucene",
                "params="+$("#kw").val(),
                function(result){
                    $("#tbody").empty();
                    for(var i=0;i<result.length;i++){

                        var ll="http://192.168.198.135/"+result[i].url;
                        //console.log(ll);
                       // var td1=$("<tr><td></td></tr>").text(result[i].id);
                        var td2=$("<tr><td></td></tr>").html(result[i].name);
                        var td3=$("<tr><td></td></tr>").text(result[i].price);
                        var td4=$("<tr><td></td></tr>").html(result[i].desc);
                        var td5=$("<tr><td></td></tr>").html("<img src='"+ll+"'/>");
                        var td6=$("<tr><td></td></tr>").text(result[i].pubDate);
                        var td7=$("<tr><td></td></tr>").text(result[i].status);
                        var td8=$("<tr><td></td></tr>").text(result[i].address);
                        var td9=$("<tr><td></td></tr>").text("--------------------");
                        //var tr=$("<tr></tr>");
                       // console.log(result[i].name);
                        $("#tbody").append(td2).append(td3).append(td4).append(td5).append(td6).append(td7).append(td8).append(td9);

                        //$.append(tr);
                    }
                }
            )
        }
    </script>
<body>
<div id="head_wrapper" class="s-isindex-wrap head_wrapper s-title-img ">
    <div id="s_fm" class="s_form">
        <div class="s_form_wrapper" id="s_form_wrapper">
            <div id="lg" class="s-p-top">
                <img id="s_lg_img" src="${pageContext.request.contextPath}/index_files/logo.png">
            </div>
            <form id="form" action="" class="fm">
                <input type="text" class="s_ipt" name="keyWords" id="kw" maxlength="100" autocomplete="off">
                <input type="button" value="搜索一下" onclick="test()" id="su" class="btn self-btn bg s_btn">
            </form>

        </div>
    </div>
</div>


<hr>
<div id="ff"></div>

<table>
    <tbody id="tbody"></tbody>
</table>

</body>
</html>
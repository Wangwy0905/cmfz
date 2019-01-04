<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>

    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->




<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main2" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('main2'));
    var option = {
        title: {
            text: '用户活跃度'
        },
        tooltip: {},
        legend: {
            type: "scroll",
            data: ['用户活跃度']
        },
        xAxis: {
            data: ['近一周', '近两周','近三周']
        },
        yAxis: {}
    };
    myChart.setOption(option);
    $.ajax({

        url: "${pageContext.request.contextPath}/user/totalNum",
        dataType: "JSON",
        success: function (data) {

            myChart.setOption({
                series: [{
                    name: '用户活跃度',
                    data: data,
                    type:"bar"
                }]
            })

        }
    });



    var goEasy = new GoEasy({

        appkey: "BC-ed05bee3bbf2424a8b7aba1b41673fe4"
    });
    goEasy.subscribe({
        channel: "cmfz",
        //channel: "用户活跃度",
        onMessage: function (message) {

            var data=eval(message.content);
            alert(data);
            myChart.setOption({
                series: [{
                    name: '用户活跃度',
                    data: data,
                    type:"bar"
                }]
            })
        }
    });


</script>


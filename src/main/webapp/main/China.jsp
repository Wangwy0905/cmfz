<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>

    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main1" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main1'));

    option = {
        title : {
            text: '持明发洲用户分布图',
            subtext: '动态分布',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:['用户数量']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        }

    };
    myChart.setOption(option)

    $.ajax({

        url: "${pageContext.request.contextPath}/user/query",
        dataType: "JSON",
        success: function (data) {
            console.log(data.data)
            myChart.setOption({
                series : [
                    {
                        name: '用户数量',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data: data.data
                    }

                ]
            })
        }
    })
</script>

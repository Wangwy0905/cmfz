<%@page contentType="text/html; utf-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

        $("#ArticleTable").edatagrid({
            fitColumns:true,
            fit:true,
            url:"${pageContext.request.contextPath}/article/queryAllArticle",
            pagination:true,
            pageSize:5,
            pageList:[1,3,5,7,9],

            view:detailview,
            columns:[[
                {field:'title', title: '文章名', width: 100},

                {field: 'wy', title: '所属上师', width: 100,formatter:name}
            ]],
            detailFormatter: function (rowIndex, rowData) {

                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/shouye/' + rowData.insertImg + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.content + '</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });

    function name(value,row,index) {
        return row.guru.dharma;
    }
</script>

<table id="ArticleTable"></table>
<div id="ArticleDialog"></div>
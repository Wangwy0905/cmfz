<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
     var toolbar=[{
         iconCls:"icon-edit",
         text:"用户导出",
         handler:function(){
             location.href="${pageContext.request.contextPath}/export/exportUser";
                 }
            },'-',{
             iconCls:"icon-edit",
            text:"用户导入",
         handler:function(){
                 location.href="${pageContext.request.contextPath}/import/ImportUser";
         }
     }
     ]
    $(function(){
       $("#UserTable").datagrid({
          url:"${pageContext.request.contextPath}/user/queryAllUser",
          fitColumns:true,
          fit:true,
           toolbar:toolbar,
          pagination:true,
          pageSize:5,
          pageList:[1,3,5,7,9],
           view: detailview,
           columns:[[
               {field: 'phone', title: '账号', width: 100},
               {field: 'password', title: '密码', width: 100},
               {field: 'sign', title: '详细描述', width: 100},
               {field: 'name', title: '真实姓名', width: 100},
               {field: 'sex', title: '性别', width: 100},
               {field: 'province', title: '省', width: 100},
               {field: 'city', title: '居住城市', width: 100}


           ]],
           detailFormatter: function (rowIndex, rowData) {

               return '<table><tr>' +
                   '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/shangshi/' + rowData.headPic + '" style="height:50px;"></td>' +
                   '<td style="border:0">' +
                   '<p>描述: ' + rowData.dharma + '</p>' +
                   '<p>日期: ' + rowData.regDate + '</p>' +
                   '</td>' +
                   '</tr></table>';
           }

       });
    });
</script>

<table id="UserTable"></table>
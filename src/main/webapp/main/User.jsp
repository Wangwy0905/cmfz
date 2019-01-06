<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
     },'-',{
         iconCls:"icon-edit",
         text:"启用账户",
         handler:function(){
             var rowUser=$("#UserTable").datagrid("getSelected");
             if(rowUser==null){
                 $.messager.alert("警告","请先选中一名用户") ;
             }else if (rowUser.status==1) {
                 $.messager.alert("警告","此用户为激活用户");
             }else{
                console.log(rowUser.id);

                 $.get("${pageContext.request.contextPath}/user/updateUser",
                     {id:rowUser.id,status:rowUser.status},
                        function(result){
                            $("#UserTable").datagrid("reload");
                        })


             }

         }
     },'-',{
         iconCls:"icon-edit",
         text:"冻结账户",
         handler:function(){
             var rowUser=$("#UserTable").datagrid("getSelected");
             if(rowUser==null){
                 $.messager.alert("警告","请先选中一名用户") ;
             }else if (rowUser.status==0) {
                 $.messager.alert("警告","此用户已被冻结");
             }else{

                 $.get("${pageContext.request.contextPath}/user/updateUser",
                     {id:rowUser.id,status:rowUser.status},
                     function(result){
                         $("#UserTable").datagrid("reload");
                     })


             }

         }
     }
     ];
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
               {field: 'sex', title: '性别', width: 100,formatter:sex},
               {field: 'province', title: '省', width: 100},
               {field: 'status', title: '状态', width: 100,formatter:ok},
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

     function ok(value,row,index){
         if(value==1){
             return "正常";
         }else{
             return "已冻结";
         }
     }
     function sex(value,row,index){
         if(value==1){
             return "男";
         }else{
             return "女";
         }
     }
</script>

<table id="UserTable"></table>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

        <script type="text/javascript">

                $(function(){
                    //修改

                    $("#bannerUpdate").linkbutton({
                        plain:true,

                        onClick: function(){

                            var row=$("#BannerTable").edatagrid("getSelected");

                            if(row!=null){
                                //获取选中行的下标
                                var index= $("#BannerTable").edatagrid("getRowIndex",row);
                                //通过row下标找出需姚编辑的行
                                $("#BannerTable").edatagrid("editRow",index);
                            }else{
                                $.messager.alert("警告","您选择的行为空");
                            }
                        }
                    });

                    $("#BannerTable") .edatagrid({
                        fitColumns:true,
                        fit:true,
                        url:"${pageContext.request.contextPath}/banner/queryDto",
                        updateUrl:"${pageContext.request.contextPath}/banner/updateBanner",
                        pagination:true,
                        pageSize:5,
                        pageList:[1,3,5,7,9],
                        toolbar:tb,
                        view: detailview,
                        columns: [[
                            {field: 'id', title: 'Id', width: 100},
                            {field: 'title', title: '标题', width: 100},
                            {
                                field: 'status', title: '状态', width: 100, editor: {
                                    type: "text",
                                    options: {required:true}
                                },formatter:status
                            },
                            {field: 'pubDate', title: '时间', width: 100, align: 'right'},
                            {field: 'descption', title: '详细描述'}
                        ]],
                        detailFormatter: function (rowIndex, rowData) {

                            return '<table><tr>' +
                                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                                '<td style="border:0">' +
                                '<p>描述: ' + rowData.descption + '</p>' +
                                '<p>日期: ' + rowData.pubDate + '</p>' +
                                '</td>' +
                                '</tr></table>';
                        }

                    });

                    //添加
                    $("#bannerAdd").linkbutton({
                        plain:true,
                        iconCls:"icon-add",
                        onClick:function(){
                            $("#Bannerdialog").dialog("open");
                        }
                    });


                    //保存
                    $("#bannerSave").linkbutton({
                        plain:true,


                        onClick: function () {

                            $("#BannerTable").edatagrid("saveRow");
                        }

                    });


                    //删除
                    $("#bannerDelete").linkbutton({
                        plain:true,

                        onClick:function(){

                         var banner= $("#BannerTable").datagrid("getSelected");

                          $.messager.confirm(
                              "删除提示",
                              "确认删除吗？",
                            function(r){
                                  if(r==true){
                                      $.post("${pageContext.request.contextPath}/banner/delete2",
                                              "id="+banner.id,
                                               function(){}
                                      ),
                                      $("#BannerTable").datagrid("reload");
                                      $.messager.show({
                                          title:"消息提示框",
                                          msg:"删除成功",
                                          timeout:500
                                      });
                                  }
                            }
                          )
                        }
                    });


                    $("#Bannerdialog").dialog({
                        title:"添加框",
                        width:400,
                        height:200,
                        closed: true,
                        href: '${pageContext.request.contextPath}/main/AddBanner.jsp',
                        modal: true

                    });

                });

                function status(value,row,idx) {

                if(row.status==1){
                    return "是";
                }else{
                    return "否";
                }
                }
        </script>
        <table id="BannerTable">
         <%--   <thead>
                <tr>

                    <th data-options="field:'id',width:1">Id</th>
                    <th data-options="field:'title',width:1">标题</th>
                    <th data-options="field:'status',width:1,editor:{type:'text', options: {}},formatter:status">状态</th>
                    <th data-options="field:'pubDate',width:1">上传时间</th>
                    <th data-options="field:'descption'">详细描述</th>
                </tr>
            </thead>--%>
        </table>
        <div id="tb">
            <a id="bannerAdd">添加</a>
            <a id="bannerUpdate">修改</a>
            <a id="bannerDelete">删除</a>
            <a id="bannerSave">保存</a>
        </div>
            <div id="Bannerdialog"></div>
<#--<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />-->
<html>
<head>
    <title>freemarker Test</title>
</head>
<body>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Data Tables
        <small>advanced tables</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-xs-12">

            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Hover Data Table<@jspTag.security.authorize access="hasAnyAuthority('admin')">
权限测试
                    </@jspTag.security.authorize>
                    <@jspTag.security.authentication property="name" />
                        <@jspTag.security.authentication property="principal.username" />


                    ${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.username)!"default value"}

                         <#if (Session.SPRING_SECURITY_CONTEXT.authentication.authorities)?exists>
                             <#list Session.SPRING_SECURITY_CONTEXT.authentication.authorities as authority>
                                 ${authority.authority}
                             </#list>
                         </#if>
                    </h3>
                </div>

                <form id="searchForm" class="form-horizontal">
                    <div class="box-body">
                        <div class="form-group col-md-6">
                            <label for="inputUserId" class="col-xs-2 control-label">ID</label>

                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputUserId" name="inputUserId"
                                       placeholder="ID">
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputUserName" class="col-xs-2 control-label">用户名</label>

                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputUserName" name="inputUserName"
                                       placeholder="用户名">
                            </div>
                        </div>


                        <div class="form-group col-md-6">
                            <label for="inputUserId2" class="col-xs-2 control-label">ID2</label>

                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputUserId2" placeholder="ID">
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputUserName2" class="col-xs-2 control-label">用户名2</label>

                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputUserName2" placeholder="用户名">
                            </div>
                        </div>

                        <div class="form-group col-md-6">
                            <div class="col-md-6 col-md-offset-2">
                                <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                            </div>
                        </div>
                    </div>
                    <!-- /.box-body -->
                <#--<div class="box-footer">
                    <button id="searchBtn" type="button" class="btn btn-default offset-1">查询</button>
                    <button type="button" class="btn btn-info pull-right">查询</button>
                </div>-->
                    <!-- /.box-footer -->
                </form>

            </div>

            <div class="box">

                <!-- /.box-header -->
                <div class="box-body">
                    <table id="table"></table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- /.content -->

<div id="toolbar" class="btn-group">
    <button id="btn_add" type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
    </button>
<#--<button id="btn_delete" type="button" class="btn btn-default" onclick="batchUploadShow();">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>批量上传
</button>
<button id="btn_edit" type="button" class="btn btn-default" onclick="editMemberInfoShow();">
    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>选择修改
</button>-->
    <button id="btn_delete" type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
    </button>
    <#--data-toggle="modal" data-target="#modal-default"-->
    <button type="button" id="modalBtn" class="btn btn-default"  >
        Launch Default Modal
    </button>

    <button type="button" id="menuBtn" class="btn btn-default">
        menu
    </button>
    <button type="button" id="menuBtn2" class="btn btn-default">
        menu2
    </button>
</div>


<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Default Modal</h4>
            </div>
            <div class="modal-body">
                <section class="content">
                    <div class="row">

                        <div class="col-sm-12">


                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Simple Form</h3>
                                </div>
                                <div class="panel-body">
                                    <form id="signupForm" method="post" class="form-horizontal">

                                        <div class="form-group">
                                            <label class="col-sm-4 control-label" for="id">ID</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="id" name="id"
                                                       placeholder="id" value="${(vo.id)!}" readonly="readonly"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 control-label" for="userName">User Name</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="userName" name="userName"
                                                       placeholder="user name" value="${(vo.userName)!}"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 control-label" for="money">money</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="money" name="money"
                                                       placeholder="money"
                                                       value="${(vo.money)!}"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 control-label" for="age">age</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="age" name="age"
                                                       placeholder="age"
                                                       value="${(vo.age)!}"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 control-label" for="createTime">create_time</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="createTime"
                                                       name="createTime"
                                                       placeholder="createTime"
                                                       value="${(vo.createTime?string("yyyy-MM-dd hh:mm:ss"))!}"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 control-label" for="remark">remark</label>
                                            <div class="col-sm-5">
                                <textarea class="form-control" rows="3" id="remark" name="remark"
                                          placeholder="remark">${(vo.remark)!}</textarea>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-sm-9 col-sm-offset-4">
                                                <button type="submit" class="btn btn-primary" name="submitBtn"
                                                        id="submitBtn"
                                                        value="Submit">Submit
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- /.row -->
                </section>
                <!-- /.content -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<myscript>
    <script src="${request.contextPath}/js/account.js?_t=${lib._timestamp}"></script>
</myscript>

</body>
</html>
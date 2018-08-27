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
                    <h3 class="box-title">Hover Data Table</h3>
                </div>

                <form id="searchForm" class="form-horizontal">
                    <div class="box-body">
                        <div class="form-group col-md-6">
                            <label for="inputUserId" class="col-xs-2 control-label">ID</label>

                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputUserId" name="inputUserId" placeholder="ID">
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputUserName" class="col-xs-2 control-label">用户名</label>

                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputUserName" name="inputUserName" placeholder="用户名">
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
</div>

<script src="${request.contextPath}/js/account.js?_t=${lib._timestamp}"></script>

</body>
</html>
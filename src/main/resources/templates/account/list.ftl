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
                <!-- /.box-header -->
                <div class="box-body">

                    <div id="toolbar" class="btn-group">
                        <button id="btn_add" type="button" class="btn btn-default" onclick="addVideoShow();">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                        </button>
                        <button id="btn_delete" type="button" class="btn btn-default" onclick="batchUploadShow();">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>批量上传
                        </button>
                        <button id="btn_edit" type="button" class="btn btn-default" onclick="editMemberInfoShow();">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>选择修改
                        </button>
                        <button id="btn_delete" type="button" class="btn btn-default" onclick="delMemberVideo();">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>选择删除
                        </button>
                    </div>

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


<script src="${request.contextPath}/js/account.js"></script>

</body>
</html>
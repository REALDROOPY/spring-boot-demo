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

        <div class="col-sm-12">


            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Simple Form</h3>
                </div>
                <div class="panel-body">
                    <form id="signupForm" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="userName">User Name</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="userName" name="userName" placeholder="user name" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="money">money</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="money" name="money" placeholder="money" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="age">age</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="age" name="age" placeholder="age" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="createTime">create_time</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="createTime" name="createTime" placeholder="createTime" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="remark">remark</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" rows="3" id="remark" name="remark" placeholder="remark"></textarea>
                            </div>
                        </div>





                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-4">
                                <button type="submit" class="btn btn-primary" name="submitBtn" id="submitBtn" value="Submit">Submit</button>
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



<script src="${request.contextPath}/js/account_edit.js?_t=${lib._timestamp}"></script>

</body>
</html>
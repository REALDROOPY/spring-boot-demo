<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



    <title>Login</title>

    <link rel="stylesheet" href="${request.contextPath}/AdminLTE/plugins/iCheck/square/blue.css">
</head>
<body>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>Admin</b>LTE</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>

        <form action="${request.contextPath}/loginSubmit" method="post">
            <#--<input name="_csrf" type="hidden" value="${Session["_csrf"]!}" />-->
            <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Email" name="username">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>

                <#if (Session.SPRING_SECURITY_LAST_EXCEPTION.message)?? && (Session.SPRING_SECURITY_LAST_EXCEPTION.message) != "">
                <div class="form-group has-feedback">
                    <p class="text-red">${(Session.SPRING_SECURITY_LAST_EXCEPTION.message)!}</p>
                </div>
                </#if>

            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> Remember Me
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>

                </div>
                <!-- /.col -->


            </div>
        </form>

        <a href="#">I forgot my password</a><br>
        <a href="register.html" class="text-center">Register a new membership</a>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->


<script src="${request.contextPath}/AdminLTE/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
</script>
</body>
</html>
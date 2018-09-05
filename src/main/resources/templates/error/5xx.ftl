<html>
<head>
    <#include "/common/inc/head1.ftl">
    <title>
        SiteMesh3: 404
    </title>
    <#include "/common/inc/head2.ftl">

</head>
<body class="hold-transition skin-blue">



<#--<div class="wrapper">-->

<!-- Content Wrapper. Contains page content -->
<#--<div class="content-wrapper">-->
<!-- Content Header (Page header) -->
<#--<section class="content-header">
    <h1>
    ${(Request.status)!} Error Page
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">${(Request.status)!} error</li>
    </ol>
</section>-->

<!-- Main content -->
<section class="content">
    <div class="error-page">
        <h2 class="headline text-red"> ${(Request.status)!}</h2>

        <div class="error-content">
            <h3><i class="fa fa-warning text-red"></i> Oops! ${(Request.error)!}.</h3>
            <p>Path: ${(Request.path)!}</p>
            <p>
            ${(Request.message)!}.<br/>
                Meanwhile, you may <a href="../../index.html">return to dashboard</a> or try using the search form.
            </p>
            <p>${((Request.timestamp)?string("yyyy-MM-dd HH:mm:ss.SSS"))!}</p>
        </div>
        <!-- /.error-content -->
    </div>
    <!-- /.error-page -->
</section>
<!-- /.content -->
<#--</div>-->
<!-- /.content-wrapper -->


<#--<h1>Whitelabel Error Page ${(Request.status)!}</h1>
<div id='created'>${((Request.timestamp)?string("yyyy-MM-dd HH:mm:ss"))!}</div>
<div>There was an unexpected error (type=${(Request.error)!}, status=${(Request.status)!}).</div>
<div>${(Request.path)!}</div>
<div>${(Request.exception)!}</div>
<div>${(Request.message)!}</div>-->
<#--</div>-->
</body>
</html>
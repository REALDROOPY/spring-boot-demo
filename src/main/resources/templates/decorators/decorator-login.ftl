<!DOCTYPE html>
<html>
<head>
    <#include "/common/inc/head1.ftl">
    <title>
        SiteMesh3:
        <sitemesh:write property="title"/>
    </title>
    <#include "/common/inc/head2.ftl">
    <!-- sitemesh head begin -->
    <sitemesh:write property='head'/>
    <!-- sitemesh head end -->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition login-page">

    <#include "/common/inc/foot.ftl">

<!-- sitemesh body begin -->
<sitemesh:write property='body'/>
<!-- sitemesh body begin -->

</body>
</html>
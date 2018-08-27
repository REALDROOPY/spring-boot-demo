$(function () {

    $('#table').bootstrapTable({
        search: false,
        pagination: true,
        sidePagination: "server",
        pageSize: 5,
        pageList: [5, 10, 15, 20],
        showColumns: true,
        showRefresh: true,
        showToggle: false,
        cache: false,
        smartDisplay: false,
        locale: "zh-CN",
        striped: true,
        sortable: true,
        silentSort: true,
        toolbar: "#toolbar",
        url: "/account/loadData",
        contentType: "application/x-www-form-urlencoded",
        dataField: "list",
        idField: "id",
        queryParams: queryParams,
        columns: [{
            field: 'id',
            title: 'User ID',
            sortable: true
        }, {
            field: 'userName',
            title: '用户名',
            sortable: true,
            sortName: "user_name"
        }, {
            field: 'money',
            title: 'Item Money',
            sortable: true
        }]
    });

    $("#searchBtn").click(function () {
        console.log("11111");
        var result = $("#searchForm").valid();
        if (result) {
            $('#table').bootstrapTable('refresh');
        }
        return false;
    });

    $("#searchForm").validate({
        rules: {
            inputUserId: {
                required: false,
                maxlength: 5,
                number: true
            },
            inputUserName: {
                required: false,
                maxlength: 5
            }
        },
        // messages: {
        //
        //     inputUserId: {
        //         required: "Please enter a username",
        //         minlength: "Your username must consist of at least 2 characters"
        //     },
        //     inputUserName: {
        //         required: "Please provide a password",
        //         minlength: "Your password must be at least 5 characters long"
        //     }
        // },
        errorElement: "em",
        errorPlacement: function (error, element) {
            // Add the `help-block` class to the error element
            error.addClass("help-block");

            if (element.prop("type") === "checkbox") {
                error.insertAfter(element.parent("label"));
            } else {
                error.insertAfter(element);
            }
        },
        highlight: function (element, errorClass, validClass) {
            $(element).parents(".col-xs-10").addClass("has-error").removeClass("has-success");
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".col-xs-10").addClass("has-success").removeClass("has-error");
        }
    });

});

//请求服务数据时所传参数
function queryParams(params) {
    return {
        pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        pageNum: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
        pageSort: params.sort,
        pageOrder: params.order,
        id: $("#inputUserId").val(),
        userName: $("#inputUserName").val(),
        // pageSort: params.sortName,
        // pageOrder: params.sortOrder,
        param: "Your Param" //这里是其他的参数，根据自己的需求定义，可以是多个
    }
}
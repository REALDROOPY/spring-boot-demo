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
            checkbox: true,
            align: 'center'
        }, {
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
        }, {
            //field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter: actionFormatter,
            events: actionEvents
        }]
    });

    $("#btn_add").click(function () {
        $("#searchForm").attr('action', '/account/insert');
        $("#searchForm").submit();
    });

    $("#btn_delete").click(function () {
        var a = $("#table").bootstrapTable('getSelections');
        if (a.length <= 0) {
            alert("请选中一行")
        } else {
            var b = JSON.stringify(a);
            alert(b);
        }
    });

    $("#searchBtn").click(function () {
        console.log("11111");
        var result = $("#searchForm").valid();
        if (result) {
            $('#table').bootstrapTable('refresh');
        }
        return false;
    });

    $("#menuBtn").click(function () {
        console.log("11111");
        $("#menu31").addClass("active");
        $("#menu3").addClass("menu-open active");
    });

    $("#menuBtn2").click(function () {
        console.log("11111");
        $("#menu31").removeClass("active");
        $("#menu3").removeClass("menu-open active");
    });


    $("#modalBtn").click(function () {
        $('#modal-default').modal('toggle')
    });

    $('#modal-default').on('show.bs.modal', function (e) {
        $.ajax({
            type: "GET",                      //请求类型
            url: "/rest/account/1",           //URL
            data: {uid: 234},   //传递的参数
            dataType: "json",                 //返回的数据类型
            success: function (data) {          //data就是返回的json类型的数据
                // alert("success!" + JSON.stringify(data));
                // alert("success!" + data.success);
                // alert("success!" + data.result);

                if (data.success) {
                    $("#id").val(data.result.id);
                    $("#userName").val(data.result.userName);
                    $("#money").val(data.result.money);
                    $("#age").val(data.result.age);
                    $("#createTime").val(data.result.createTime);
                    $("#remark").val(data.result.remark);

                } else {
                    alert("error! code: " + data.code + ", msg: " + data.msg);
                }
            },
            error: function (data) {
                //alert("error! " + JSON.stringify(data));
                var result = JSON.parse(data.responseText);
                alert("error! status: " + data.status + ", statusText: " + data.statusText + ", code: " + result.code + ", msg: " + result.msg);
            }
        });
    });


    $("#searchForm").validate({
        rules: {
            inputUserId: {
                required: false,
                maxlength: 5,
                digits: true
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


    // $('.update').on("click",function(){
    //     alert("row:"+row)
    // })

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

function actionFormatter(value) {
    return [
        '<a class="myupdate" title="Update Item"><i class="glyphicon glyphicon-edit"></i></a>&nbsp;',
        '<a class="myremove" title="Delete Item"><i class="glyphicon glyphicon-remove-circle"></i></a>',
    ].join('');
}


window.actionEvents = {
    'click .myupdate': function (e, value, row, index) {
        // alert(JSON.stringify(row));
        $("#searchForm").attr('action', '/account/' + row.id);
        $("#searchForm").submit();
    },
    'click .myremove': function (e, value, row, index) {
        alert(JSON.stringify(row));
    }
};


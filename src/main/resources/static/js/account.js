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
            sortName: "user_name"
        }, {
            field: 'money',
            title: 'Item Money',
            sortable: true
        }]
    });

    $("#searchBtn").click(function () {
        console.log("11111");
        $('#table').bootstrapTable('refresh');
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
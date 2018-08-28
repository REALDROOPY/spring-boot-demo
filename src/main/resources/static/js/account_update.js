$(function () {

    $("#signupForm").attr('action', '/account/updateSubmit');

    // $('#create_time').datepicker({
    //     autoclose: true,
    //     format: 'yyyy-mm-dd',
    //     language: 'zh-CN'
    // });

    $('#createTime').daterangepicker({
        singleDatePicker: true,
        startDate: moment(),
        timePicker24Hour: true,
        timePicker: true,
        "locale": {
            format: 'YYYY-MM-DD HH:mm',
            applyLabel: "应用",
            cancelLabel: "取消",
            resetLabel: "重置",
            fromLabel: "起始时间",
            toLabel: "结束时间'",
            customRangeLabel: "自定义",
            weekLabel: "W",
            daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
            monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            firstDay: 1
        }
    });

    $("#signupForm").validate({
        rules: {
            userName: {
                required: true,
                maxlength: 50
            },
            money: {
                required: true,
                number: true,
                maxlength: 10
            },
            age: {
                required: true,
                digits: true,
                maxlength: 5
            },
            remark: {
                required: false,
                maxlength: 200
            },
            createTime: {
                required: true,
                // dateISO: true,
                maxlength: 16
            }
        },
        // messages: {
        //     firstname: "Please enter your firstname",
        //     lastname: "Please enter your lastname",
        //     username: {
        //         required: "Please enter a username",
        //         minlength: "Your username must consist of at least 2 characters"
        //     },
        //     password: {
        //         required: "Please provide a password",
        //         minlength: "Your password must be at least 5 characters long"
        //     },
        //     confirm_password: {
        //         required: "Please provide a password",
        //         minlength: "Your password must be at least 5 characters long",
        //         equalTo: "Please enter the same password as above"
        //     },
        //     email: "Please enter a valid email address",
        //     agree: "Please accept our policy"
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
            $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
        }
    });

});

//全局变量对话框
var dialog;

function openDialog(title, url) {
    //打开弹出窗口
    dialog = $.dialog({
        title: title,
        width: '750px',
        height: '160px',
        drag: false,
        resize: false,
        content: 'url:' + url
    });
}

//关闭窗口
function closeDialog(msg) {//关闭窗口
    $("#tip").html(msg);
    dialog.close();//关闭窗口
    if (msg != '') {//没有做增删改就不能刷新
        findList();//刷新页面
    }
}


//记录新增公共方法
function cAdd(addUrl) {
    var param = $("#form1").serialize();
    $.ajax(
        {
            type: "POST",
            url: addUrl,
            data: param,
            dataType: "json",
            success: function (data) {
                parent.closeDialog(data.msg);
            }
        }
    );
}

//记录删除公共方法
function cDelete(url) {
    $.ajax(
        {
            type: "POST",
            url: url,
            dataType: "json",
            success: function (data) {
                $("#tip").html(data.msg);
                findList();
            }
        }
    );
}


//记录更新初始化公共方法
function cUpdateInit(id, url) {
    $.ajax(
        {
            type: "POST",
            url: url,
            data: "id=" + id,
            dataType: "json",
            success: function (data) {
                //循环对象，根据属性名找到表单元素并赋值
                $.each(data, function (n, v) {
                    // alert(n + " : " + v);
                    if ($("input[name=" + n + "][type!=file]").length == 1) {
                        $("input[name=" + n + "][type!=file]").val(v);
                    } else if ($("select[name=" + n + "]").length == 1) {
                        $("select[name=" + n + "] > option[value=" + v + "]").attr("selected", true);
                    }
                });
            }
        }
    );
}

//记录更新公共方法
function cUpdate(url) {
    var param = $("#form1").serialize();
    $.ajax(
        {
            type: "POST",
            url: url,
            data: param,
            dataType: "json",
            success: function (data) {
                parent.closeDialog(data.msg);
            }
        }
    );
}
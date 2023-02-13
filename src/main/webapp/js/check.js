// window.onload = function() {
// 	checkByName('username')
// }

// 校验单个名称
function checkByName(name) {
    console.log(name);
    var obj = document.getElementsByName(name)[0];


    obj.onfocus = function() {
        //内嵌函数
        console.log(this);
        if (this.value.length == 0) {
            this.className = 'err';
        }
    }

    obj.onblur = function() {
        if (this.value.length > 0) {
            this.className = 'ipt';
        }
    }
}

/**
 * 更新样式
 */
function changeStyle(obj) {
    if (obj.value.trim().length > 0) {
        obj.className = 'ipt';
    } else {
        obj.className = 'err';
    }
}

var names;

//校验页面的所有名称数组
function checkByNameArr(names) {
    this.names = names;
    //循环遍历获取页面的name的对象
    for (var i = 0; i < names.length; i++) {
        //根据names数组的名称获取对应的对象
        var obj = document.getElementsByName(names[i])[0];

        console.log(obj);
        //动态绑定获得焦点的事件
        obj.onfocus = function() {
            //内置函数
            console.log("获得焦点", this);
            changeStyle(this);
        }

        //动态绑定失去焦点的事件
        obj.onblur = function() {
            console.log("失去焦点", this);
            changeStyle(this);
        }
    }

    //动态绑定form表单提交前的校验
    var form = document.getElementById('form1');
    form.onsubmit = function() {
        return checkAll(names);
    }
}

//循环校验表单上所需要校验的输入框
function checkAll() {
    //标志是否所有的输入框都有值,默认是都是值
    var isAllHasValue = true;
    for (var i = 0; i < names.length; i++) {
        //获取输入中每一个输入框的对象
        var obj = document.getElementsByName(names[i])[0];

        console.log(i, obj.nextSibling);
        if (0 === obj.value.trim().length) {
            //只要有一个没有值，标识改成false
            isAllHasValue = false;
            //这里是没有值的情况
            obj.className = 'err';

            //动态加节点提示错误文字
            var errSpan = document.createElement("span");
            errSpan.setAttribute('class', 'err-span');
            errSpan.innerHTML = obj.alt + '不能为空';

            if (null != obj.nextSibling) {
                obj.parentNode.removeChild(obj.nextSibling);
            }
            obj.parentNode.appendChild(errSpan);
        } else {
            //输入框有值的情况下
            obj.className = 'ipt';
            if (null != obj.nextSibling) {
                obj.parentNode.removeChild(obj.nextSibling);
            }
        }
    }
    return isAllHasValue;
}
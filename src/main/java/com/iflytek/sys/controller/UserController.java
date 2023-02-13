package com.iflytek.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytek.sys.bean.User;
import com.iflytek.sys.dao.IUserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的描述:
 * 项目名称:  Sys_V1_0505PM
 * 类的包名:  com.iflytek.sys.servleet
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/5 16:59
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/5 16:59
 * 修改备注:
 * 修订版本:  V1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    private Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private IUserDao userDao;

    /**
     * 查询用户信息
     */
    @ResponseBody
    @RequestMapping("/list")
    private Object findAllUserList() {
        System.out.println("----------查询所有的用户-----------");
        Map<String, Object> map = new HashMap<>();
        map.put("name", pd.getName());
        map.put("username", pd.getUsername());
        map.put("sex", pd.getSex());

        //第一次查询是查询有多少条数据
        PageHelper.startPage(getPage().getCurrentPage(), getPage().getRowsPerPage());
        List<User> userList = userDao.findAllUserList(map);
        PageInfo<User> pageInfo = new PageInfo<>(userList, getPage().getCurrentPage());
        getPage().setTotalRows((int) pageInfo.getTotal());
        map.put("page", getPage());

        rm.put("list", userList);
        rm.put("page", getPage());
        return rm;
    }

    /**
     * 新增用户
     */
    @ResponseBody
    @RequestMapping("/add")
    private Object add() {
        pd.setPassword("123");//默认给123
        pd.setRoleId(1);
        int num = userDao.add(pd);
        setMsg(num > 0 ? "添加成功" : "添加失败");
        return rm;
    }

    /**
     * 删除用户信息
     */
    @ResponseBody
    @RequestMapping("/delete")
    private Object delete() {
        int num = userDao.delete(pd.getId());
        setMsg(num > 0 ? "删除成功" : "删除失败");
        return rm;
    }

    /**
     * 更新用户信息
     */
    @ResponseBody
    @RequestMapping("/update")
    private Object update() {
        System.out.println("------------------用户更新---------------");
        if (isUpdate) {
            System.out.println("------------------用户更新提交---------------");
            //进行数据更新的逻辑
            int num = userDao.update(pd);
            setMsg(num > 0 ? "更新成功" : "更新失败");
            return rm;
        } else {
            System.out.println("------------------更新用户数据查询---------------");
            //查询用户数据并回写到更新页面的逻辑
            User user = userDao.getUserById(pd.getId());
            return user;
        }
    }
}

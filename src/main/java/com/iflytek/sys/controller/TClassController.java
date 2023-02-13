package com.iflytek.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytek.sys.bean.TClass;
import com.iflytek.sys.dao.ITClassDao;
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
@RequestMapping("/class")
public class TClassController extends BaseController<TClass> {

    @Autowired
    private ITClassDao itClassDao;

    /**
     * 查询班级信息
     */
    @ResponseBody
    @RequestMapping("/list")
    private Object findAllTClassList() {
        System.out.println("----------查询所有的班级-----------");

        Map<String, Object> map = new HashMap<>();
        map.put("name", pd.getName());
        map.put("charger", pd.getCharger());

        PageHelper.startPage(getPage().getCurrentPage(), getPage().getRowsPerPage());
        List<TClass> list = itClassDao.findAllTClassList(map);
        PageInfo<TClass> pageInfo = new PageInfo<>(list, getPage().getCurrentPage());
        getPage().setTotalRows((int) pageInfo.getTotal());
        map.put("page", getPage());
        rm.put("list", list);
        rm.put("page", getPage());
        return rm;
    }

    /**
     * 新增班级
     */
    @ResponseBody
    @RequestMapping("/add")
    private Object add() {
        int num = itClassDao.add(pd);
        setMsg(num > 0 ? "新增成功" : "新增失败");
        return rm;
    }

    /**
     * 删除班级信息
     */
    @ResponseBody
    @RequestMapping("/delete")
    private Object delete() {
        int num = itClassDao.delete(pd.getId());
        setMsg(num > 0 ? "删除成功" : "删除失败");
        return rm;
    }

    /**
     * 更新班级信息
     */
    @ResponseBody
    @RequestMapping("/update")
    private Object update() {
        System.out.println("------------------班级更新---------------");
        if (isUpdate) {
            System.out.println("------------------用户更新提交---------------");
            int num = itClassDao.update(pd);
            setMsg(num > 0 ? "更新成功" : "更新失败");
            return rm;
        } else {
            System.out.println("------------------更新班级数据查询---------------");
            //查询用户数据并回写到更新页面的逻辑
            TClass tClass = itClassDao.getTClassById(pd.getId());
            return tClass;
        }
    }
}

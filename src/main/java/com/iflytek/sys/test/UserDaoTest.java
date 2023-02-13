package com.iflytek.sys.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.HashMap;
import java.util.Map;

/**
 * 类的描述:
 * 项目名称:  Sys_V20520AM
 * 类的包名:  com.iflytek.sys.test
 * 创建的人:  农子科(296608517@qq.com)
 * 创建时间:  2022/5/23 11:15
 * 修改的人:  农子科(296608517@qq.com)
 * 修改时间:  2022/5/23 11:15
 * 修改备注:
 * 修订版本:  V1.0
 */
public class UserDaoTest {

    //单元测试(白盒测试) ——> 继承测试(灰盒测试)  ——> 系统测试(黑盒测试) ——> 验收测试(内部测试)
    /*public static void main(String[] args) {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.login("a", "a121");
        if (1 == userList.size()) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }*/

    private static Map<String, Object> map;

    @BeforeClass
    public static void beforeClassTest() {
        map = new HashMap<>();
        System.out.println("---------在类测试之前执行------");
    }

    @AfterClass
    public static void afterClassTest() {
        map = new HashMap<>();
        System.out.println("---------在类测试之后执行------");
    }

//    @Before
    public void testDown() {
        System.out.println("------在方法之前执行");
    }

//    @After
    public void testUp() {
        System.out.println("---------在方法之后执行");
    }

    /*@Test
    public void testLogin() {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.login("a", "a121");
        assert 1 == userList.size();//断言,判断表达式
        System.out.println("断言成功");
    }

    @Test
    public void testFindAllUserList() {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.findAllUserList(map);
        System.out.println("查询成功" + userList);
    }*/





}

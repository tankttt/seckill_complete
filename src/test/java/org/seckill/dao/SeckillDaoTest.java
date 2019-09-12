package org.seckill.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.sql.*;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author tank
 * @Date 2019/8/16 - 20:05
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for(Seckill seckill : seckills){
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws ClassNotFoundException, SQLException {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L,killTime);
        System.out.println("updateCount=" + updateCount);
    }

    @Test
    //原生jdbc连接数据库
    public void testOriginConnection() throws ClassNotFoundException, SQLException {
        //注册
        Class.forName("com.mysql.cj.jdbc.Driver");

//连接
        Connection connention = DriverManager.getConnection("jdbc:mysql://localhost:3306/seckill"+"?serverTimezone=GMT%2B8", "root", "123456");
        String sql = "SELECT * FROM seckill"; //准备sql语句
//获取Statement对象（简称：特）
        Statement statement = connention.createStatement();
//执行
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet);
        while(resultSet.next()){
//ResultSet里面的get相关方法列号是从1开始的，切记。
            System.out.println("abc");
        }
//关闭（倒关）
        resultSet.close();
        statement.close();
        connention.close();
    }

}

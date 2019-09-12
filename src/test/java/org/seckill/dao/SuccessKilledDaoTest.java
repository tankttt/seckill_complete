package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author tank
 * @Date 2019/8/16 - 23:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        /**
         * 第一次执行：insertCount=1
         * 第二次执行：insertCount=0
         */
        long id = 1000;
        long phone = 131341322123L;
        int insertCount = successKilledDao.insertSuccessKilled(id ,phone);
        System.out.println("insertCount" +
                "=" + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1000;
        long phone = 131341322123L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}

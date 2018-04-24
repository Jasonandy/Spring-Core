package cn.ucaner.analyze.data.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ucaner.analyze.data.jdbc.dao.UserJdbcDao;
import cn.ucaner.analyze.data.jdbc.entity.UserEntity;

public class DataSourceClient {


    public static void main(String[] args) throws InterruptedException {

//        testInsertAll();
//        testInsertOne();
        testQueryList();
    }



    public static void testQueryList() throws InterruptedException {
        // 创建 Spring 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config/spring-core.xml");
        UserJdbcDao userJdbcDao = ctx.getBean(UserJdbcDao.class);
        List<UserEntity> userEntityList = userJdbcDao.getUserByName("test001");
        for(UserEntity userEntity : userEntityList){
            System.out.println(userEntity.getUserName());
        }
    }


    public static void testInsertOne() throws InterruptedException {
        // 创建 Spring 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config/spring-core.xml");
        UserJdbcDao userJdbcDao = ctx.getBean(UserJdbcDao.class);
        userJdbcDao.create(new UserEntity());
    }

    public static void testInsertAll() throws InterruptedException {
        // 创建 Spring 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config/spring-core.xml");
        UserJdbcDao userJdbcDao = ctx.getBean(UserJdbcDao.class);

        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(100);

        Long startTime = System.currentTimeMillis();
        System.out.println("开始数据测试,开始时间: " + new SimpleDateFormat("HH:mm:ss:SSS").format(new Date(startTime)));
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (atomicInteger.get() < 5000) {
                        int num = atomicInteger.addAndGet(1);
                        UserEntity userEntity = new UserEntity();
                        userEntity.setUserName("testUser" + num);
                        userJdbcDao.create(userEntity);
                        if (num % 1000 == 0) {
                            System.out.println("当前插入 : " + num);
                        }
                    }
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
        countDownLatch.await();
        Long endTime = System.currentTimeMillis();
        System.out.println("结束时间: " + new SimpleDateFormat("HH:mm:ss:SSS").format(new Date(endTime)));
        System.out.println("总共耗时: " + (endTime - startTime) / 1000);

    }


}

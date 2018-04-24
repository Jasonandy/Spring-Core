package spring.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spring.BaseTest;
import cn.ucaner.analyze.data.jdbc.entity.UserEntity;
import cn.ucaner.analyze.service.UserService;


public class ServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertTest(){
        userService.create(new UserEntity());
    }
}

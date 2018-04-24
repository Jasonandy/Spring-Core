package spring.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spring.BaseTest;
import cn.ucaner.analyze.data.jdbc.dao.UserJdbcDao;
import cn.ucaner.analyze.data.jdbc.entity.UserEntity;

public class DriverManagerDataSourceTest extends BaseTest{

    @Autowired
    private UserJdbcDao userJdbcDao;

    @Test
    public void insertTest(){
        userJdbcDao.create(new UserEntity());
    }
}

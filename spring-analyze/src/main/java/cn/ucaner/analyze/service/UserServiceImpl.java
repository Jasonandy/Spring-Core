package cn.ucaner.analyze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ucaner.analyze.data.jdbc.dao.UserJdbcDao;
import cn.ucaner.analyze.data.jdbc.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJdbcDao userJdbcDao;

    @Override
    public void create(UserEntity userEntity) {
        userJdbcDao.create(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {

    }
}

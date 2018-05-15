package cn.ucaner.analyze.data.jdbc.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import cn.ucaner.analyze.data.jdbc.entity.UserEntity;

@Component
public interface UserJdbcDao {

    public void create(UserEntity userEntity);

    
    public List<UserEntity> getUserByName(String userName);



    public UserEntity getUser(String name);

    public List<UserEntity> listUsers();

    public void delete(Long id);

    public void update(UserEntity userEntity);

}

package cn.ucaner.analyze.service;

import org.springframework.stereotype.Service;

import cn.ucaner.analyze.data.jdbc.entity.UserEntity;

@Service
public interface UserService {

    public void create(UserEntity userEntity);

    public void update(UserEntity userEntity);


}

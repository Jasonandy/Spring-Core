package cn.ucaner.analyze.data.mybatis.mapper;

import cn.ucaner.analyze.data.mybatis.entity.UserEntity;

public interface MybatisUserEntityMapper {


    int insert(UserEntity record);


    UserEntity selectByPrimaryKey(Long id);

}

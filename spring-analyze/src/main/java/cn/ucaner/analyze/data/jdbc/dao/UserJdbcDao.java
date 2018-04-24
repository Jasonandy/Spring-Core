package cn.ucaner.analyze.data.jdbc.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import cn.ucaner.analyze.data.jdbc.entity.UserEntity;

@Component
public interface UserJdbcDao {

    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    public void create(UserEntity userEntity);
    /**
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
     */

    public List<UserEntity> getUserByName(String userName);



    public UserEntity getUser(String name);
    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */


    public List<UserEntity> listUsers();
    /**
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
     */
    public void delete(Long id);
    /**
     * This is the method to be used to update
     * a record into the Student table.
     */
    public void update(UserEntity userEntity);

}

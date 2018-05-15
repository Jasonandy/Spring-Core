package cn.ucaner.analyze.data.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.ucaner.analyze.data.jdbc.entity.UserEntity;

/**
* @Package：cn.ucaner.analyze.data.jdbc.mapper   
* @ClassName：UserJdbcMapper   
* @Description：   <p> UserJdbcMapper </p>
* @Author： -    
* @CreatTime：2018年5月15日 下午3:35:12   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
public class UserJdbcMapper implements RowMapper<UserEntity> {
	
	
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(rs.getLong("id"));
        userEntity.setUserName(rs.getString("user_name"));
        userEntity.setSex(rs.getString("sex"));
        userEntity.setAge(rs.getLong("age"));
        userEntity.setEmail(rs.getString("email"));
        userEntity.setPhone(rs.getString("phone"));
        userEntity.setVersion(rs.getLong("version"));
        userEntity.setLastModifyTime(rs.getDate("last_modify_time"));
        userEntity.setCreateTime(rs.getDate("create_time"));
        return userEntity;
    }


}

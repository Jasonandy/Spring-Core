package mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.ucaner.analyze.data.mybatis.entity.UserEntity;
import cn.ucaner.analyze.data.mybatis.mapper.MybatisUserEntityMapper;

public class MybatisTest {

    public static void main(String[] args) {
        //mybatis的配置文件
        String resource = "mybaits/mybatisConfig.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        try(SqlSession session = sessionFactory.openSession()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setAge(10l);
            //使用mapper接口执行SQL
            MybatisUserEntityMapper userEntityMapper =  session.getMapper(MybatisUserEntityMapper.class);
            userEntityMapper.insert(userEntity);
            //使用statement执行SQL
//            session.insert("com.houlu.java.spring.data.mybatis.mapper.MybatisUserEntityMapper.insert",userEntity);
//            session.commit();

            userEntity = userEntityMapper.selectByPrimaryKey(178l);
            System.out.println("userEntity is" + userEntity);
        }
    }
}

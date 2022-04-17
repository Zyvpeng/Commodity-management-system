package service;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import util.SqlSessionFactoryUtils;

public class UserService {
    //调用BrandMapper.selectAll()
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public boolean SelectUser(String userName,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.SelectUser(userName, password);
        if (user==null){
            return false;
        }
        return true;
    }

    public boolean CheckUser(String username){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        User user = mapper.CheckUser(username);
        if(user==null){
            return false;
        }
        return true;

    }


    public void InsertUser(String username,String password){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        mapper.InsertUser(username,password);
        sqlSession.commit();
        sqlSession.close();
    }


}

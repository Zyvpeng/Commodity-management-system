package service;

import mapper.AdminMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Admin;
import util.SqlSessionFactoryUtils;

public class AdminService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void InsertAdmin(Admin admin){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminMapper mapper=sqlSession.getMapper(AdminMapper.class);

        mapper.InsertAdmin(admin);
        sqlSession.commit();
        sqlSession.close();

    }

    public Admin SelectAdminByName(String adminName){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        AdminMapper mapper=sqlSession.getMapper(AdminMapper.class);

        Admin admin=mapper.SelectAdminByName(adminName);

        return admin;
    }
}

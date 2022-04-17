package service;

import mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class BrandService {
    //调用BrandMapper.selectAll()
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){


        SqlSession sqlSession=sqlSessionFactory.openSession();

        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);


        //调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();
        return brands;
    }

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand){
        SqlSession sqlSession=sqlSessionFactory.openSession();

        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit();
        sqlSession.close();
    }


    public void delete(int id){
        SqlSession sqlSession =sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();




    }

    public Brand SelectById(int id){
        SqlSession sqlSession=sqlSessionFactory.openSession();

        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();

        return brand;

    }


    public void Update(Brand brand){
        SqlSession sqlSession=sqlSessionFactory.openSession();

        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);

        mapper.update(brand);

        sqlSession.commit();
        sqlSession.close();

    }



}

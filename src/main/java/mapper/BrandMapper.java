package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Brand;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */

    @Select("select * from tb_brand")
    @ResultMap("BrandMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    @Delete("delete from tb_brand where id=#{ID}")
    void delete(@Param("ID") Integer id);

    @Select("select * from tb_brand where id =#{ID}")
    @ResultMap("BrandMap")
    Brand selectById(@Param("ID") int id);

    @Update("update tb_brand set  id=#{id},brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void update(Brand brand);



}

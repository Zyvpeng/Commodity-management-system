package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;

public interface UserMapper {

    @Select("select *from tb_user where user_name=#{user_name} and password=#{password}")
    @ResultMap("UserMap")
    User SelectUser(@Param("user_name") String userName, @Param("password") String password);

    @Select("select *from tb_user where user_name =#{user_name}")
    @ResultMap("UserMap")
    User CheckUser(@Param("user_name") String name);

    @Insert("insert into tb_user(user_name, password) values (#{user_name},#{password})")
    void InsertUser(@Param("user_name") String username,@Param("password") String password);


    @Select("select * from tb_user")
    @ResultMap("UserMap")
    List<User> SeletAllUser();

}

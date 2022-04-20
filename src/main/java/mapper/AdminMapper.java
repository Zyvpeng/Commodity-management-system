package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.Admin;

import java.util.List;

public interface AdminMapper{

    @Insert("insert into admin values(null,#{adminName},#{password})")
    void InsertAdmin(Admin admin);

    @Select("select * from admin where admin_name=#{adminName}")
    @ResultMap("AdminMap")
    Admin SelectAdminByName(@Param("adminName") String adminName);

    @Select("select * from admin")
    @ResultMap("AdminMap")
    List<Admin> selectAll();
}

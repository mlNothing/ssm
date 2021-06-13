package lml.dao;

import lml.domain.Role;
import lml.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IuserDao {

    @Select("select *from users where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username" ,property = "username"),
            @Result(column = "email" ,property = "email"),
            @Result(column = "password" ,property = "password"),
            @Result(column = "phoneNum" ,property = "phoneNum"),
            @Result(column = "status" ,property = "status"),
            @Result(column = "id" ,property = "roles",javaType = List.class,many = @Many(select = "lml.dao.IroleDao.findRoleByUserId"))

    })
    public UserInfo findByUsername(String username);
    @Select("select *from users")
    List<UserInfo> findAll();

    @Insert("INSERT INTO users(username,password,email,phoneNum,status) VALUES(#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo user);

    @Select("select *from users where id=#{Oid}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username" ,property = "username"),
            @Result(column = "email" ,property = "email"),
            @Result(column = "password" ,property = "password"),
            @Result(column = "phoneNum" ,property = "phoneNum"),
            @Result(column = "status" ,property = "status"),
            @Result(column = "id" ,property = "roles",javaType = List.class,many = @Many(select = "lml.dao.IroleDao.findRoleByUserId"))

    })
    UserInfo findById(Integer Oid);

    @Select("SELECT *FROM users WHERE id IN(SELECT userId FROM users_ROLE WHERE  roleId=#{id})")
   public List<UserInfo> findUserByRoleId(Integer id);

    @Select("select *from role where id not in(SELECT roleId FROM users_ROLE WHERE  userId=#{id})")
    List<Role> findUserByIdAndAllRole(Integer id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}

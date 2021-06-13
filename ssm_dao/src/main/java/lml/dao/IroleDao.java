package lml.dao;

import lml.domain.Permission;
import lml.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IroleDao {
    @Select("SELECT *FROM role WHERE id IN(SELECT roleId FROM users_ROLE WHERE  userID =#{pid})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc" ,column = "roleDesc"),
            @Result(column = "id",property = "permission",javaType = List.class,
            many = @Many(select = "lml.dao.IpermissionDao.findPermissionByUserId")
            )
    })
    public List<Role> findRoleByUserId(Integer pid);

    @Select("select *from role")
    List<Role> findAll();

    @Select("INSERT INTO role(roleName,roleDesc) VALUES (#{roleName},#{roleDesc})")
    void save(Role role);
    @Select("SELECT *FROM role WHERE id =#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc" ,column = "roleDesc"),
            @Result(column = "id",property = "users",javaType = List.class,
                    many = @Many(select = "lml.dao.IuserDao.findUserByRoleId")
            ),
            @Result(column = "id",property = "permission",javaType = List.class,
                    many = @Many(select = "lml.dao.IpermissionDao.findPermissionByUserId")
            )
    })
    Role findById(Integer id);

    @Select("select *from permission where id not in(SELECT permissionId FROM role_permission WHERE  roleId=#{id})")
    List<Permission> findRoleByIdAndAllPermission(Integer id);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);
}

package lml.dao;

import lml.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IpermissionDao {
    @Select("SELECT *FROM permission WHERE id IN(SELECT permissionId FROM role_permission WHERE  roleId=#{Pid})")
    public List<Permission> findPermissionByUserId(Integer Pid);
    @Select("select *From permission")
    List<Permission> findAll();
    @Select("INSERT INTO permission(permissionName,url) VALUES (#{permissionName},#{url})")
    void save(Permission permission);
}

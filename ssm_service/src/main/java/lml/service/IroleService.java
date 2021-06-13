package lml.service;

import lml.domain.Permission;
import lml.domain.Role;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IroleService{

    List<Role> findAll();

    void save(Role role);

    Role findById(Integer id);

    List<Permission> findRoleByIdAndAllPermission(Integer id);

    void addPermissionToRole(Integer roleId, Integer[] permissionsId);
}

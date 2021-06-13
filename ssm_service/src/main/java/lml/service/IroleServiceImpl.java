package lml.service;

import lml.dao.IroleDao;
import lml.domain.Orders;
import lml.domain.Permission;
import lml.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IroleServiceImpl implements IroleService{
    @Autowired
    private IroleDao iroleDao;
    @Override
    public List<Role> findAll() {
        return iroleDao.findAll();
    }

    @Override
    public void save(Role role) {
        iroleDao.save(role);
    }

    @Override
    public Role findById(Integer id) {
        return iroleDao.findById(id);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(Integer id) {
        return iroleDao.findRoleByIdAndAllPermission(id);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionsId) {
        for (Integer permissionId : permissionsId) {
            iroleDao.addPermissionToRole(roleId,permissionId);
        }
    }


}

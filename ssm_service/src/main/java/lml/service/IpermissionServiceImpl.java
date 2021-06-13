package lml.service;

import lml.dao.IpermissionDao;
import lml.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IpermissionServiceImpl implements IpermissionService{
    @Autowired
    private IpermissionDao ipermissionDao;
    @Override
    public List<Permission> findAll() {
        return ipermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        ipermissionDao.save(permission);
    }
}

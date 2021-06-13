package lml.service;

import lml.domain.Permission;

import java.util.List;


public interface IpermissionService {
    List<Permission> findAll();

    void save(Permission permission);
}

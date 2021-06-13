package lml.service;

import lml.domain.Role;
import lml.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IuserService extends UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    List<UserInfo> findAll();

    void save(UserInfo user);

    UserInfo findById(Integer id);

    List<Role> findUserByIdAndAllRole(Integer id);

    void addRoleToUser(Integer userId,Integer[] rolesId);
}

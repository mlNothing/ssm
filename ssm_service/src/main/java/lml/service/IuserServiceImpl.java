package lml.service;


import lml.dao.IuserDao;
import lml.domain.Role;
import lml.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class IuserServiceImpl implements IuserService{
    @Autowired
    private IuserDao iuserDao;
    /*对密码进行加密*/
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = iuserDao.findByUsername(username);
        List<Role> roles = userInfo.getRoles();
        //获取role中的权限名
        List<SimpleGrantedAuthority> authority = getAuthority(roles);
       // boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority > authorities
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,authority);
        return user;
    }

    @Override
    public List<UserInfo> findAll() {
        return iuserDao.findAll();
    }

    @Override
    public void save(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        iuserDao.save(user);
    }

    @Override
    public UserInfo findById(Integer id) {
        return iuserDao.findById(id);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(Integer id) {
        return iuserDao.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoleToUser(Integer userId,Integer[] rolesId) {
        for (Integer roleId : rolesId) {
            iuserDao.addRoleToUser(userId,roleId);
        }
    }

    //获取权限名字
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> authorities = new ArrayList();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" +role.getRoleName()));
        }
    return authorities;
    }
}

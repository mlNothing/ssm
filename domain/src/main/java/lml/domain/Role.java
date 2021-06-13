package lml.domain;

import java.util.List;

public class Role {
    private Integer id;//无意义 主键
    private String roleName;//角色名
    private String roleDesc;//角色描述
    private List<Permission> permission;
    private List<UserInfo> users;

    public List<Permission> getPermissions() {
        return permission;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permission = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}

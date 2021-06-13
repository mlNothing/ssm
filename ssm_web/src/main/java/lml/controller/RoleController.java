package lml.controller;

import lml.domain.Permission;
import lml.domain.Role;
import lml.domain.UserInfo;
import lml.service.IroleService;
import lml.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IroleService iroleService;
    @RequestMapping("/save")
    public String save(Role role) throws Exception{
        iroleService.save(role);
        return "redirect:findAll";
    }
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roles= iroleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role= iroleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public  ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true)Integer id){
        ModelAndView mv = new ModelAndView();
        Role role = iroleService.findById(id);
        List<Permission> permissionList = iroleService.findRoleByIdAndAllPermission(id);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)Integer roleId,@RequestParam(name = "ids",required = true)Integer[] permissionsId){
        iroleService.addPermissionToRole(roleId,permissionsId);
        return "redirect:findAll";
    }
}

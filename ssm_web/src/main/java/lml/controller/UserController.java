package lml.controller;

import lml.domain.Role;
import lml.domain.UserInfo;
import lml.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IuserService iuserService;
    //pre-post-annotations 具体使用spel表达式进行权限操作 只有宝宝用户可以进行保存
    @PreAuthorize("authentication.principal.username=='宝宝'")
    @RequestMapping("/save")
    public String save(UserInfo user) throws Exception{
         iuserService.save(user);
        return "redirect:findAll";
    }
    //使用jsr250注解 对权限进行控制
 /*   @RolesAllowed("ADMIN")*/
    //使用表达式
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/findAll")

    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
       List<UserInfo> userInfos= iuserService.findAll();
       mv.addObject("userList",userInfos);
       mv.setViewName("user-list");
       return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfos= iuserService.findById(id);
        mv.addObject("user",userInfos);
        mv.setViewName("user-show");
        return mv;
    }

    //查找所没有的角色
    @RequestMapping("/findUserByIdAndAllRole")
    public  ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)Integer id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfos = iuserService.findById(id);
        List<Role> roleList = iuserService.findUserByIdAndAllRole(id);
        mv.addObject("user",userInfos);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }
    //添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)Integer userId,@RequestParam(name = "ids",required = true)Integer[] rolesId){
            iuserService.addRoleToUser(userId,rolesId);
        return "redirect:findAll";
    }
}

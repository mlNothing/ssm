package lml.controller;

import lml.domain.Permission;
import lml.service.IpermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private IpermissionService ipermissionService;
    @RequestMapping("/save")
    public String save(Permission permission) throws Exception{
        ipermissionService.save(permission);
        return "redirect:findAll";
    }
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission> permission= ipermissionService.findAll();
        mv.addObject("permissionList",permission);
        mv.setViewName("permission-list");
        return mv;
    }

}

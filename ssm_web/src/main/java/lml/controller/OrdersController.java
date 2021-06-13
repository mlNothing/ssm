package lml.controller;

import com.github.pagehelper.PageInfo;
import lml.domain.Orders;
import lml.service.IordersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private IordersService iordersService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4")Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> all = iordersService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("ordersList",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
@RequestMapping("/findById")
    public  ModelAndView findById(@RequestParam(name = "id" ,required = true )Integer Oid ){
        ModelAndView mv = new ModelAndView();
        Orders orders=   iordersService.findById(Oid);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}

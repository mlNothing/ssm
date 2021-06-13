package lml.controller;

import lml.domain.Product;
import lml.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IproductService iproductService;
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        iproductService.save(product);
        return "redirect:findAll";
    }
    /*不能省略前缀 Role 而jsr250可以省略*/
    @Secured("ROLE_ADMIN")
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<lml.domain.Product> products = iproductService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }

}

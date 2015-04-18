package cz.jiripinkas.jba.controller;


import cz.jiripinkas.jba.service.UzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author ksolodovnik
 */
@Controller
public class UserController {

    @Autowired
    private UzerService uzerService;

    @RequestMapping(value = "/users")
    public String users(Model model){
        model.addAttribute("users", uzerService.getAllUzers());
        return "users";
    }

    @RequestMapping(value = "/users/{id}")
    public String detail(Model model, @PathVariable long id){
        model.addAttribute("user", uzerService.getUzerById(id));
        return "user-detail";
    }
}

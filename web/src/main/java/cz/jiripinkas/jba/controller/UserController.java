package cz.jiripinkas.jba.controller;


import cz.jiripinkas.jba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ksolodovnik
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(name = "/users")
    public String users(Model model){
        model.addAttribute("users",userService.findAll());
        return "users";
    }
}

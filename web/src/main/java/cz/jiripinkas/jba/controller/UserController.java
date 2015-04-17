package cz.jiripinkas.jba.controller;


import cz.jiripinkas.jba.entity.Uzer;
import cz.jiripinkas.jba.service.UzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ksolodovnik
 */
@Controller
public class UserController {

    @Autowired
    UzerService uzerService;

    @RequestMapping(name = "/users")
    public String users(Model model){
        model.addAttribute("users", uzerService.getAllUzers());
        List<Uzer> uzers = new ArrayList<>();
        uzers = uzerService.getAllUzers();
        System.out.println(uzers.get(0).getName());
        return "users";
    }
}

package cz.jiripinkas.jba.controller;


import cz.jiripinkas.jba.entity.Uzer;
import cz.jiripinkas.jba.service.UzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author ksolodovnik
 */
@Controller
public class UserController {

    @Autowired
    private UzerService uzerService;

    @ModelAttribute("user")
    public Uzer construct(){
        return new Uzer();
    }

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

    @RequestMapping(value = "/register")
    public String showRegister(){
        return "user-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegistration(@ModelAttribute("user") Uzer uzer){
        uzerService.createUzer(uzer);
        return "user-register";
    }
}

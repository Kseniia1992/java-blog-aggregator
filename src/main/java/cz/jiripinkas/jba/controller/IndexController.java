package cz.jiripinkas.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ksolodovnik
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index"; // or whole path "/WEB-INF/jsp/index.jsp"
                        //this name corresponds to the name of definition in general.xml definition file
    }
}

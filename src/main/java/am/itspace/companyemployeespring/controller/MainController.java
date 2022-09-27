package am.itspace.companyemployeespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Controller
public class MainController {
    @GetMapping(value = "/")
    public String mainPage(){
        return "index";
    }
}

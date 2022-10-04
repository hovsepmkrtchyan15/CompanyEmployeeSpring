package am.itspace.companyemployeespring.controller;

import am.itspace.companyemployeespring.entity.Role;
import am.itspace.companyemployeespring.entity.User;
import am.itspace.companyemployeespring.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    @GetMapping(value = "/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "/accessDenied";
    }

    @GetMapping("/loginsuccess")
    public String loginSuccess(@AuthenticationPrincipal CurrentUser currentUser){
        if(currentUser != null){
            User user = currentUser.getUser();
            if(user.getRole() == Role.ADMIN){
                return "redirect:/admin";
            }else if(user.getRole() == Role.USER){
                return "redirect:/user";
            }
        }
        return "redirect:/";
    }
    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "error", required = false) String error, ModelMap modelMap){
        if(error!=null && error.equals("true")){
            modelMap.addAttribute("error","true");
        }
        return "/loginPage";
    }
}

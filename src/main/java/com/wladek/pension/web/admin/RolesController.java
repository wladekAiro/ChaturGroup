package com.wladek.pension.web.admin;

import com.wladek.pension.domain.Role;
import com.wladek.pension.domain.User;
import com.wladek.pension.service.UserService;
import com.wladek.pension.service.pension.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wladek on 11/24/15.
 */
@Controller
@RequestMapping(value = "/admin/roles")
public class RolesController {
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public String roles(Model model){
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles" , roles);
        return "/admin/roles/index";
    }

    @RequestMapping(value = "/form" , method = RequestMethod.GET)
    public String form(Model model){
        model.addAttribute("action" , "CREATE");
        model.addAttribute("role" , new Role());
        return "/admin/roles/form";
    }

    @RequestMapping(value = "/form/{action}" , method = RequestMethod.POST)
    public String post(@ModelAttribute @Valid Role role ,  BindingResult result,RedirectAttributes redirectAttributes ,
                       @PathVariable("action") String action , Model model){

        if(action.equals("CREATE")){
            if(result.hasErrors()) {
                model.addAttribute("role" , role);
                return "/admin/roles/form";
            }

            Role newRole = roleService.create(role);
            redirectAttributes.addFlashAttribute("message" , "Role created successfully");

            return "redirect:/admin/roles/home";
        }

        return "/admin/roles/form";
    }
}

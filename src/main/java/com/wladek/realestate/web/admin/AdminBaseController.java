package com.wladek.realestate.web.admin;

import com.wladek.realestate.domain.Role;
import com.wladek.realestate.domain.User;
import com.wladek.realestate.service.UserService;
import com.wladek.realestate.service.pension.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wladek on 11/24/15.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminBaseController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "/admin/index";
    }

    @RequestMapping(value = "/users" , method = RequestMethod.GET)
    public String users(@RequestParam(value = "roles" , required = false , defaultValue = "false") boolean roles,
                        Model model){

        if (roles){
            List<Role>  roleList = roleService.findAll();
            model.addAttribute("roleList" , roleList);
            model.addAttribute("roles" , roles);
            model.addAttribute("role" , new Role());
            return "/admin/users/index";
        }

        List<User>  users = userService.findAll();
        model.addAttribute("users" , users);
        model.addAttribute("roles" , roles);
        model.addAttribute("user" , new User());
        return "/admin/users/index";
    }

    @RequestMapping(value = "/users/createUser" , method = RequestMethod.POST)
    public String postUser(@ModelAttribute @Valid User user, BindingResult result ,
                           RedirectAttributes redirectAttributes , Model model){

        if (result.hasErrors()){
            List<User>  users = userService.findAll();

            model.addAttribute("message" , true);
            model.addAttribute("content" , "Form has errors");
            model.addAttribute("user" , user);
            model.addAttribute("users" , users);

            return "/admin/users/index";
        }

        userService.addNewUser(user);
        redirectAttributes.addAttribute("message" , true);
        redirectAttributes.addFlashAttribute("content" , "User added");

        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/users/createRole" , method = RequestMethod.POST)
    public String postRole(@ModelAttribute @Valid Role role, BindingResult result ,
                           RedirectAttributes redirectAttributes , Model model){

        if (result.hasErrors()){

            List<Role>  roleList = roleService.findAll();
            model.addAttribute("roleList" , roleList);
            model.addAttribute("message" , true);
            model.addAttribute("content" , "Form has errors");
            model.addAttribute("role" , role);
            model.addAttribute("roles" , true);

            return "/admin/users/index";
        }

        roleService.create(role);
        redirectAttributes.addAttribute("message" , true);
        redirectAttributes.addFlashAttribute("content" , "Role added");

        return "redirect:/admin/users?roles=true";
    }
}

package com.wladek.realestate.web;

import com.wladek.realestate.domain.User;
import com.wladek.realestate.domain.enumeration.UserRole;
import com.wladek.realestate.service.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wladek on 7/6/15.
 */
@Controller
public class PageDirectorController {

    @RequestMapping(value = "/url-processor" , method = RequestMethod.GET)
    public String redirect(){
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userDetails.getUser();

        if (user.getUserRole().equals(UserRole.ADMIN)){
            return "redirect:/admin/home" ;
        }

        if (user.getUserRole().equals(UserRole.EMPLOYEE)){
            return "redirect:/employee/home" ;
        }

        return "redirect:/";

    }
}

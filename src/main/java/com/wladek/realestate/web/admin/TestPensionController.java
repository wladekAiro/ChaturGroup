package com.wladek.realestate.web.admin;

import com.wladek.realestate.domain.realestate.Employer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by george on 11/28/15.
 */
@Controller
@RequestMapping(value = "/test/pension")
public class TestPensionController {
    
    @RequestMapping(value = "/form" , method = RequestMethod.GET)
    public String getPensionForm(Model model){
        model.addAttribute("employer", new Employer());
        return "/admin/realestate/employerPensionForm";
    }
}

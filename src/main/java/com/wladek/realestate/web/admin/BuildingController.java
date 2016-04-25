package com.wladek.realestate.web.admin;

import com.wladek.realestate.domain.Building;
import com.wladek.realestate.domain.Property;
import com.wladek.realestate.service.property.BuildingService;
import com.wladek.realestate.service.property.PropertyService;
import com.wladek.realestate.web.front.support.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by george on 12/18/15.
 */

@Controller
@RequestMapping(value = "/admin/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "/home/{id}")
    public String show(@PathVariable("id") Long id , Model model){
        Building building = buildingService.findOne(id);
        model.addAttribute("building" , building);
        return "/admin/property/building/buildingHome";
    }
}

package com.wladek.realestate.web.admin;

import com.wladek.realestate.domain.Building;
import com.wladek.realestate.domain.Floor;
import com.wladek.realestate.domain.Property;
import com.wladek.realestate.service.property.BuildingService;
import com.wladek.realestate.service.property.FloorService;
import com.wladek.realestate.service.property.PropertyService;
import com.wladek.realestate.web.front.support.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired private BuildingService buildingService;
    @Autowired private FloorService floorService;

    @RequestMapping(value = "/home/{id}" , method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id , @RequestParam(value = "form" , required = false , defaultValue = "false") boolean form ,
                       @RequestParam(value = "page" , required = false , defaultValue = "1") int page,
                       @RequestParam(value = "size" , required = false , defaultValue = "10") int size,
                       Model model){
        Building building = buildingService.findOne(id);
        Page<Floor> floorPage = floorService.findByBuilding(building , page ,size);

        model.addAttribute("floorPage" , floorPage);
        model.addAttribute("pagenatedUrl" , "/admin/building/home/"+id);
        model.addAttribute("building" , building);

        if (form){
            model.addAttribute("floorFom" , form);
            model.addAttribute("floor" , new Floor());
        }

        return "/admin/property/building/buildingHome";
    }

    @RequestMapping(value = "/home/{id}" , method = RequestMethod.POST)
    public String createFloor(@ModelAttribute("floor") Floor floor , BindingResult result ,
                              RedirectAttributes redirectAttributes, @PathVariable("id") Long id , Model model){

        if (result.hasErrors()){

            Building building = buildingService.findOne(id);

            model.addAttribute("building" , building);
            model.addAttribute("floorFom" , true);
            model.addAttribute("floor" , new Floor());

            return "/admin/property/building/buildingHome";
        }

        Floor newFloor = floorService.create(floor);

        redirectAttributes.addFlashAttribute("message", true);
        redirectAttributes.addFlashAttribute("content" , newFloor.getNumber()+" floor added");

        return "redirect:/admin/building/home/"+id;
    }

}

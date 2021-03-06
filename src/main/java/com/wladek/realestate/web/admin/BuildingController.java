package com.wladek.realestate.web.admin;

import com.wladek.realestate.domain.Building;
import com.wladek.realestate.domain.Floor;
import com.wladek.realestate.domain.Property;
import com.wladek.realestate.domain.Shop;
import com.wladek.realestate.service.property.BuildingService;
import com.wladek.realestate.service.property.FloorService;
import com.wladek.realestate.service.property.PropertyService;
import com.wladek.realestate.web.front.support.EmployeeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by george on 12/18/15.
 */

@Controller
@RequestMapping(value = "/admin/building")
public class BuildingController {

    Logger logger = LoggerFactory.getLogger(BuildingController.class);

    @Autowired private BuildingService buildingService;
    @Autowired private FloorService floorService;

    @RequestMapping(value = "/home/{id}" , method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id , @RequestParam(value = "form" , required = false , defaultValue = "false") boolean form ,
                       @RequestParam(value = "page" , required = false , defaultValue = "1") int page,
                       @RequestParam(value = "size" , required = false , defaultValue = "10") int size,
                       @RequestParam(value = "floor" , required = false , defaultValue = "0") int floor,
                       @RequestParam(value = "room" , required = false , defaultValue = "false") boolean room,
                       Model model){
        Building building = buildingService.findOne(id);

        Page<Floor> floorPage = floorService.findByBuilding(building , page ,size);

        Floor selectedFloor = null;

        String pagenatedUrl = "/admin/building/home/"+id;

        if(floor != 0){
            selectedFloor = floorService.findOne(new Long(floor));
        }

        if (selectedFloor != null){
            pagenatedUrl = "/admin/building/home/"+id+"?floor="+floor;
        }

        if(room){
            model.addAttribute("shop", new Shop());
        }
        model.addAttribute("floorPage", floorPage);
        model.addAttribute("pagenatedUrl" , pagenatedUrl);
        model.addAttribute("building" , building);
        model.addAttribute("selectedFloor" , selectedFloor);
        model.addAttribute("roomForm" , room);

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

    @RequestMapping(value = "/home/room/{id}" , method = RequestMethod.POST)
    public String addRoom(@ModelAttribute("shop") Shop shop , BindingResult result ,
                          RedirectAttributes redirectAttributes,@PathVariable("id") Long id ,
                          @RequestParam(value = "floor" , required = false , defaultValue = "0") int floor,
                          @RequestParam(value = "room" , required = false , defaultValue = "false") boolean room,
                       Model model){
        Building building = buildingService.findOne(id);

        Floor selectedFloor = null;

        String pagenatedUrl = "/admin/building/home/"+id;

        if(floor != 0){
            selectedFloor = floorService.findOne(new Long(floor));
        }

        if (selectedFloor != null){
            pagenatedUrl = "/admin/building/home/"+id+"?floor="+floor;
        }

        if (result.hasErrors()){
            if(room){
                model.addAttribute("shop", shop);
            }

            model.addAttribute("pagenatedUrl" , pagenatedUrl);
            model.addAttribute("building" , building);
            model.addAttribute("selectedFloor" , selectedFloor);
            model.addAttribute("roomForm" , room);

            return "/admin/property/building/buildingHome";
        }

        Shop newShop = floorService.addShop(shop);

        redirectAttributes.addFlashAttribute("message", true);
        redirectAttributes.addFlashAttribute("content" , "Room "+newShop.getNumber() + " added ");

        return "redirect:/admin/building/home/"+id+"?floor="+floor;
    }

}

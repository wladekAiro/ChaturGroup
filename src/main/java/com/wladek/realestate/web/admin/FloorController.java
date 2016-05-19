package com.wladek.realestate.web.admin;

import com.wladek.realestate.domain.Building;
import com.wladek.realestate.domain.Floor;
import com.wladek.realestate.service.property.BuildingService;
import com.wladek.realestate.service.property.FloorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by george on 12/18/15.
 */

@Controller
@RequestMapping(value = "/admin/floor")
public class FloorController {

    Logger logger = LoggerFactory.getLogger(FloorController.class);

    @Autowired private BuildingService buildingService;
    @Autowired private FloorService floorService;

    @RequestMapping(value = "/home/{id}" , method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id , @RequestParam(value = "form" , required = false , defaultValue = "false") boolean form ,
                       @RequestParam(value = "page" , required = false , defaultValue = "1") int page,
                       @RequestParam(value = "size" , required = false , defaultValue = "10") int size,
                       @RequestParam(value = "floor" , required = false , defaultValue = "0") int floor,
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

        logger.warn(" *********** SELECTED FLOOR ID ============= "+((floor == 0) ? " null " : floor) + " ********** FLOOR NUMBER "+ (selectedFloor == null ? "null" : selectedFloor.getNumber()));

        model.addAttribute("floorPage", floorPage);
        model.addAttribute("pagenatedUrl" , pagenatedUrl);
        model.addAttribute("building" , building);
        model.addAttribute("selectedFloor" , selectedFloor);

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

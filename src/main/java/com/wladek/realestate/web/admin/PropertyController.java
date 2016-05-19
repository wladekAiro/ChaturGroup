package com.wladek.realestate.web.admin;

import com.wladek.realestate.domain.Building;
import com.wladek.realestate.domain.Property;
import com.wladek.realestate.domain.realestate.Assets;
import com.wladek.realestate.service.AssetService;
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
@RequestMapping(value = "/admin/property")
public class PropertyController {

    @Autowired
    EmployeeValidator employeeValidator;
    @Autowired
    PropertyService propertyService;
    @Autowired
    private BuildingService buildingService;


    @RequestMapping(value = "/propertyForm", method = RequestMethod.GET)
    public String employerForm(Model model) {
        model.addAttribute("property", new Property());
        model.addAttribute("action" , "CREATE");
        return "/admin/property/propertyForm";
    }

    @RequestMapping(value = "/newProperty/{action}", method = RequestMethod.POST)
    public String newUser(@ModelAttribute @Valid Property property, BindingResult result ,
                          @PathVariable("action") String action , Model model) {
        String path = "Failed";

        if(action.equals("CREATE")){
            if(result.hasErrors()) {
                model.addAttribute("property", property);
                return "/admin/property/propertyForm";
            }
            Property newProperty = propertyService.create(property);

            return "redirect:/admin/property/home";
        }

        if (action.equals("EDIT")){
            if(result.hasErrors()) {
                model.addAttribute("property", property);
                return "/admin/property/propertyForm";
            }
            Property editedProperty = propertyService.update(property);
            return "redirect:/admin/property/"+editedProperty.getId();
        }

        return path;
    }

    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public String getAssets(@RequestParam(value = "company" , required = false , defaultValue = "0") int company ,Model model){
        List<Property>  propertyList = propertyService.findAll();
        Property selectedProperty = null;

        if (company != 0){
            selectedProperty = propertyService.findOne(new Long(company));
        }

        model.addAttribute("building" , new Building());
        model.addAttribute("action" , "CREATE");
        model.addAttribute("selectedProperty" , selectedProperty);
        model.addAttribute("propertyList", propertyList);
        return "/admin/property/propertyList";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getInvestment(@PathVariable("id") Long id, Model model){
        Property property = propertyService.findOne(id);
        model.addAttribute("property" , property);
        return "/admin/property/show";
    }

    @RequestMapping( value = "/{id}/edit", method = RequestMethod.GET)
    public String editInvestment(@PathVariable("id") Long id, Model model){
        Property property = propertyService.findOne(id);
        model.addAttribute("property" , property);
        model.addAttribute("action" , "EDIT");
        return  "/admin/property/propertyForm";
    }

    @RequestMapping( value = "/property/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployer(@PathVariable("id") Long id , RedirectAttributes redirectAttributes){
        boolean message = propertyService.delete(id);
        redirectAttributes.addFlashAttribute("message" , message);
        return "redirect:/admin/property/home";
    }

    @RequestMapping( value = "/building/{action}", method = RequestMethod.POST)
    public String buildingForm(@ModelAttribute @Valid Building building, BindingResult result ,
                               RedirectAttributes redirectAttributes, @PathVariable("action") String action , Model model){

        if(action.equals("CREATE")){
            if(result.hasErrors()) {
                model.addAttribute("building", building);
                return "/admin/property/home?company="+building.getPropertyId();
            }

            Building newBuilding = buildingService.create(building);
            redirectAttributes.addFlashAttribute("result" , true);
            return "redirect:/admin/property/home?company="+building.getPropertyId();
        }

        return "redirect:/admin/property/home";
    }
}

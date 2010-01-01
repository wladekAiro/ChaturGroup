package com.wladek.realestate.web.admin;

import com.wladek.realestate.domain.realestate.Employee;
import com.wladek.realestate.service.EmployeeService;
import com.wladek.realestate.service.EmployerService;
import com.wladek.realestate.web.front.support.EmployeeValidator;
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
 * Created by george on 12/18/15.
 */

@Controller
@RequestMapping(value = "/admin/pension")
public class EmployeeController {

    @Autowired
    EmployeeValidator employeeValidator;

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployerService employerService;

    @RequestMapping(value = "/employee/{id}/add", method = RequestMethod.GET)
    public String addEmployee(@PathVariable("id") Long id , Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employer" , employerService.findOne(id));
        model.addAttribute("action" , "CREATE");
        return "/admin/realestate/employeeForm";
    }

    @RequestMapping(value = "/newemployee/{action}", method = RequestMethod.POST)
    public String newUser(@ModelAttribute @Valid Employee employee, BindingResult result ,
                          @PathVariable("action") String action , Model model) {
        String path = "Failed";

        if(action.equals("CREATE")){
            employeeValidator.validateNewEmployee(employee, result);
            if(result.hasErrors()) {
                model.addAttribute("employee", employee);
                return "/admin/realestate/employeeForm";
            }
            Employee newEmployee = employeeService.addNewEmployee(employee);
            return "redirect:/admin/realestate/employer/"+employee.getEmployer().getId();
        }

        if (action.equals("EDIT")){
            if(result.hasErrors()) {
                model.addAttribute("employee", employee);
                return "/admin/realestate/employeeForm";
            }
            Employee editedEmployee = employeeService.editEmployee(employee);
            return "redirect:/admin/realestate/employer/"+employee.getEmployer().getId();
        }

        return path;
    }

    @RequestMapping(value = "/employees" , method = RequestMethod.GET)
    public String getEmployees(Model model){
        List<Employee> employees = employeeService.findAllEmployees();

        model.addAttribute("employees" , employees);
        return "/admin/realestate/employeeList";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable("id") Long id, Model model){
        Employee employee = employeeService.getOne(id);
        model.addAttribute("employee" , employee);
        return "/admin/realestate/employee";
    }

    @RequestMapping( value = "/employee/{id}/edit", method = RequestMethod.GET)
    public String editEmployee(@PathVariable("id") Long id, Model model){
        Employee employee = employeeService.getOne(id);
        model.addAttribute("employee" , employee);
        model.addAttribute("employer" , employee.getEmployer());
        model.addAttribute("action" , "EDIT");
        return "/admin/realestate/employeeForm";
    }

    @RequestMapping( value = "/employee/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long id , RedirectAttributes redirectAttributes){
        boolean message = employeeService.delete(id);
        redirectAttributes.addFlashAttribute("message" , message);
        return "redirect:/admin/realestate/employees";
    }
}

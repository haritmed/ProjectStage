package com.example.employeeimput.restcontrollers;

import com.example.employeeimput.entities.Employee;
import com.example.employeeimput.services.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/createEmployee")
    public String createEmployee() {
        return "CreateEmployee";
    }

    @RequestMapping("saveEmployee")
    public String saveEmployee(

            @ModelAttribute("employeeVue") Employee employeeController) {

       /* employeeController.setEmployeeState(EmployeeState.Active);*/
        employeeService.saveEmployee(employeeController);//Create
        return "CreateEmployee";
    }







    //Modification a faire pour la pagination
    @RequestMapping("/EmployeesList")
    public String categoryList(ModelMap modelMap,
                               @RequestParam(name ="page",defaultValue = "0")int page,
                               @RequestParam(name ="size",defaultValue = "2")int size) {
        Page<Employee> customerController = employeeService.getAllEmployeeByPage(page, size);
        modelMap.addAttribute("CustomerVue", customerController);
        modelMap.addAttribute("pages",new int[customerController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "CustomersList";
    }

    //Modification a faire pour la pagination

    @RequestMapping("/deleteCustomer")

    public String deleteCustomer(@RequestParam("id") Long id, ModelMap modelMap,
                                 @RequestParam(name ="page",defaultValue = "0")int page,
                                 @RequestParam(name ="size",defaultValue = "2")int size) {
        employeeService.deleteEmployeeById(id);
        Page<Employee> customersController = employeeService.getAllEmployeeByPage(page, size);
        modelMap.addAttribute("customersVue", customersController);//Passer les objets du controllers vers la vue
        modelMap.addAttribute("pages",new int[customersController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "CustomersList";
    }





    @RequestMapping("/editCustomer")

    public String editCustomer(@RequestParam("id") Long id, ModelMap modelMap){
        Employee employeeController= employeeService.getEmployeeById(id);
        modelMap.addAttribute("customerView",employeeController);
        return "EditCustomer";
    }
    @RequestMapping("updateCustomer")

    public String updateCustomer(

            @ModelAttribute("customerView")  Employee customerController ){

        employeeService.updateEmployee(customerController);
        return "redirect:customersList";

    }
}


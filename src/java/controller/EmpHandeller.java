package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.EmpService;

//@Controller
@RequestMapping("/")
public class EmpHandeller {

    //@Autowired
    EmpService empService;

    public EmpService getEmpService() {
        return empService;
    }

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    @RequestMapping(value = "/add_Employee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute() Employees employees, HttpServletResponse response) throws Exception {
        empService.addEmployee(employees);
        return "add-employee-success";
    }

    @RequestMapping(value = "/edit_employee", method = RequestMethod.GET)
    public String editEmployee(ModelMap model, HttpServletRequest request) throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));
        List<Employees> empListE = empService.getEmployeebyId(id);
        // System.out.println(empListE.toString());
        request.setAttribute("empListE", empListE);
        return "edit-employee-success";
    }

    @RequestMapping(value = "/SaveEdit", method = RequestMethod.POST)
    public String SaveEdit(ModelMap model, Employees employees) throws Exception {
        List<Employees> empList = empService.SaveEdit(employees);
        model.addAttribute("empList", empList);
        return "list-employee";
    }

    @RequestMapping(value = "/delete_employee", method = RequestMethod.GET)
    public String deleteEmployee(ModelMap model, HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Employees> empList = empService.deleteEmployees(id);
        model.addAttribute("empList", empList);
        return "list-employee";
    }

    @RequestMapping(value = "/list_employee", method = RequestMethod.GET)
    public String listEmployee(ModelMap model) throws Exception {
        List<Employees> empList = empService.getEmpList();
        model.addAttribute("empList", empList);
        return "list-employee";
    }

}

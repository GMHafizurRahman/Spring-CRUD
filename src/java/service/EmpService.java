package service;

import java.util.List;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmpRepository;

//@Service
public class EmpService {

    //@Autowired
    EmpRepository empRepository;

    public EmpRepository getEmpRepository() {
        return empRepository;
    }

    public void setEmpRepository(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public void addEmployee(Employees employees) {
        empRepository.addEmployee(employees);
    }

    public List<Employees> getEmpList() {
        List<Employees> empList = empRepository.getEmpList();
        return empList;
    }

    public List<Employees> deleteEmployees(int id) {
        List<Employees> empList = empRepository.deleteById(id);
        return empList;
    }

    public List<Employees> getEmployeebyId(int id) {
        List<Employees> empListE = empRepository.getEmployeebyId(id);
        return empListE;
    }

    public List<Employees> SaveEdit(Employees employees) {
      List<Employees> empList =  empRepository.SaveEdit(employees);
      return empList;
    }

}

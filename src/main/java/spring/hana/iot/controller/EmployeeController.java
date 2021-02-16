package spring.hana.iot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.hana.iot.model.Employee;
import spring.hana.iot.services.EmployeeService;


@RestController
public class EmployeeController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeService employeeService ;

    @RequestMapping("/employee/count")
    public Long count() {
        log.info("Search total number of employees");
        return employeeService.getCount();
    }

    @RequestMapping("/employee/all")
    public List<Employee> getAllEmployees() {
        log.info("Get All Employees");
        return employeeService.findAllEmployee();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/employee/all")
    public boolean addEmployee(@RequestBody Employee employee) {
        log.info("Add a new employee");
        return employeeService.insertEmployee(employee);
    }

    @RequestMapping("/employee/{id}")
    public Employee findById(@PathVariable Long id) {
        log.info("Searching employee by id: " + id);
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/employee/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        log.info("Delete employee: " + id);
        return employeeService.deleteEmployee(id);
    }

}

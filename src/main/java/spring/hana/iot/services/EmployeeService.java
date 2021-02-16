package spring.hana.iot.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hana.iot.model.Employee;
import spring.hana.iot.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public long getCount() {
        return employeeRepository.count();
    }

    public List<Employee> findAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        employeeRepository.findAll().forEach(employees::add);        
        return employees;
    }

    public boolean insertEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
            // return false;
        }
    }

    public Employee findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee;
    }

    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employeeRepository.delete(employee);
            return true;
        } else {
            return false;
        }
    }
}

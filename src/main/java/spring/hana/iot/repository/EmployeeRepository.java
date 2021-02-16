package spring.hana.iot.repository;

import org.springframework.data.repository.CrudRepository;
import spring.hana.iot.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    
}

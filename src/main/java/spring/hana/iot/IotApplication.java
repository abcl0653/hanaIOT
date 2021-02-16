package spring.hana.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import spring.hana.iot.model.Employee;
import spring.hana.iot.services.EmployeeService;

@SpringBootApplication
public class IotApplication {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(IotApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("========================================test=======================");
			Employee employee = new Employee();
			employee.setId(90001);

			// EmployeeService employeeService = new EmployeeService();
			boolean success = employeeService.insertEmployee(employee);
			System.out.println(success);

		};
	}
}

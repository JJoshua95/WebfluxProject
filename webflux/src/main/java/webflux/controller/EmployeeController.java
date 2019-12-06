package webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.model.Employee;
import webflux.repository.EmployeeRepository;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    private Mono<Employee> getEmployeeEndpoint(@PathVariable String id) {
        return employeeRepository.findEmployeeById(Integer.parseInt(id));
    }

    @GetMapping()
    private Flux<Employee> getAllEmployeesEndpoint() {
        return employeeRepository.findAllEmployees();
    }

}

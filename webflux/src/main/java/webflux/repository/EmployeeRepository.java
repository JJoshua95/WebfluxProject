package webflux.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.model.Employee;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    public static Map<Integer, Employee> employeeData;

    static {

        employeeData = new HashMap<>();
        employeeData.put(1, new Employee(1,"1"));
        employeeData.put(2, new Employee(2,"2"));
        employeeData.put(3, new Employee(3,"3"));
        employeeData.put(4, new Employee(4,"4"));
        employeeData.put(5, new Employee(5,"5"));
        employeeData.put(6, new Employee(6,"6"));
        employeeData.put(7, new Employee(7,"7"));
        employeeData.put(8, new Employee(8,"8"));
        employeeData.put(9, new Employee(9,"9"));

    }

    public Mono<Employee> findEmployeeById(Integer id) {
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
        return Mono.just(employeeData.get(id));
    }

    public Flux<Employee> findAllEmployees() {
        return Flux.fromIterable(employeeData.values());
    }

}

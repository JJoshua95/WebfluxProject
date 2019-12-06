package webflux.client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.model.Employee;

public class EmployeeWebClient {

    WebClient webClient = WebClient.create("localhost:8080");

    public Flux<Employee> requestAllEmployees() {
        return webClient.get().uri("/employees").retrieve().bodyToFlux(Employee.class);
    }

    public Mono<Employee> requestSingleEmployee(Integer id) {
        return webClient.get().uri("/employees/" + id).retrieve().bodyToMono(Employee.class);
    }

}

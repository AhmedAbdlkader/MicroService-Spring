package my.micro.builingservice.services;

import my.micro.builingservice.dto.Customers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    public Customers findCustomersById(@PathVariable(name="id") Long id);

  
}

package org.sid.customerservice;

import org.sid.customerservice.Entity.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean

    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder().nom("Hassane").Email("hassan@gmail.com").build());
            customerRepository.save(Customer.builder().nom("amir").Email("amir@gmail.com").build());
            customerRepository.save(Customer.builder().nom("Mohmed").Email("mohmed@gmail.com").build());
            customerRepository.findAll().forEach(c->{
                System.out.println(c);
            });
        };


    }
}

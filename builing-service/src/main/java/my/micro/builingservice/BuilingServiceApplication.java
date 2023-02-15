package my.micro.builingservice;

import my.micro.builingservice.dto.Customers;
import my.micro.builingservice.dto.Product;
import my.micro.builingservice.entity.Bill;
import my.micro.builingservice.entity.ProductItem;
import my.micro.builingservice.repo.BillRepo;
import my.micro.builingservice.repo.ProductItemRepo;
import my.micro.builingservice.services.CustomerRestClient;
import my.micro.builingservice.services.ProductItemRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class BuilingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuilingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepo billRepo ,
                            ProductItemRepo itemrepo,
                            CustomerRestClient customerRestClient,
                            ProductItemRestClient productItemRestClient)
    {
        return args -> {
            Collection<Product> products = productItemRestClient.allProducts().getContent();
            System.out.println(products);
            Long customerId=1L;
            Customers customers = customerRestClient.findCustomersById(customerId);
            if(customers==null) throw new RuntimeException("not ounddd");
            Bill bill = new Bill();
            bill.setBilldate(new Date());
            bill.setCustomerId(customerId);
            Bill savedbill = billRepo.save(bill);
            products.forEach(product -> {
                ProductItem productItem = new ProductItem();
                productItem.setBill(savedbill);
                productItem.setProductId(product.getId());
                productItem.setQuantity(1+ new Random().nextInt(10));
                productItem.setDiscount(Math.random());
                itemrepo.save(productItem);
            });
        };
    }
}

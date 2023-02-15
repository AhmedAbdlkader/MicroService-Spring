package my.micro.builingservice.services;

import my.micro.builingservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("INVENTORY-SERVICE")
public interface ProductItemRestClient {


    @GetMapping("/products/{id}")
    Product FindProductById(@PathVariable long id);
    @GetMapping("/products")
    PagedModel<Product> allProducts();

}

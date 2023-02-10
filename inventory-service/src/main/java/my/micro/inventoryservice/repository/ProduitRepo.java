package my.micro.inventoryservice.repository;

import my.micro.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProduitRepo extends JpaRepository<Product, Long> {
}

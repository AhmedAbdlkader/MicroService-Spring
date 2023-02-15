package my.micro.builingservice.repo;

import my.micro.builingservice.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepo extends JpaRepository<ProductItem , Long> {
}

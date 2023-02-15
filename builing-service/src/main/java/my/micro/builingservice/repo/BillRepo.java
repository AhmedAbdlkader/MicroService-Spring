package my.micro.builingservice.repo;

import my.micro.builingservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillRepo  extends JpaRepository<Bill , Long> {
}

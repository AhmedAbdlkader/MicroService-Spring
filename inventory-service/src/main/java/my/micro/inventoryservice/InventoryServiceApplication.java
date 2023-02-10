package my.micro.inventoryservice;

import my.micro.inventoryservice.entity.Product;
import my.micro.inventoryservice.repository.ProduitRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start (ProduitRepo repo)
	{
		return  args -> {
					repo.save(Product.builder().nom("dell").prix(52).build());
			repo.save(Product.builder().nom("hp").prix(55).build());
			repo.save(Product.builder().nom("ymv").prix(22).build());

			repo.save(Product.builder().nom("mop").prix(758).build());

		};
	}
}

package my.micro.builingservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {
    private long id ;
    private String nom;
    private int prix ;
}

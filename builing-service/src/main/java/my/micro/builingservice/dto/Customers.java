package my.micro.builingservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Customers {
    private long id;
    private String nom;
    private String Email;
}

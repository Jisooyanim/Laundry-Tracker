package project.LaundryTracker.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO extends BaseModelDTO{
    private Long id;
    private String name;
    private String contactNumber;
    private String email;
}
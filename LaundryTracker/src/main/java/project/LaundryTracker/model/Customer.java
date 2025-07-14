package project.LaundryTracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
// @Table(name = "customers")
public class Customer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, name="customer_id")
    private Long id;

    @Column(nullable=false, name="name")
    private String name;

    @Pattern(regexp = "^\\+?[0-9]{7,15}$")
    @Column(nullable=false, name="contact_number")
    private String contactNumber;

    @Column(name="email")
    private String email;
}
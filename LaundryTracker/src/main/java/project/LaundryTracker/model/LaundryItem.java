package project.LaundryTracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name="laundry_item")
public class LaundryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, name="item_id")
    private Long id;

    @Column(nullable=false, name="type")
    private String serviceType;

    @Column(name="notes")
    private String notes;

    @Column(nullable=false, name="quantity")
    private double quantity; 

    @Column(nullable=false, name="price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private LaundryOrder order;
}

package project.LaundryTracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import project.LaundryTracker.enums.OrderStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name="laundry_order")
public class LaundryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, name="order_id")
    private Long id;

    @Column(nullable=false, unique=true, name="tracking_number")
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, name="order_status")
    private OrderStatus status;

    @Column(nullable=false, name="dropoff_dt")
    private LocalDateTime dropOffDate;

    @Column(nullable=false, name="expected_pickup_dt")
    private LocalDate expectedPickupDate;

    @Column(nullable=false, name="pickup_dt")
    private LocalDateTime pickedUpAt;

    @Column(nullable=false, name="total_price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(nullable = false, name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<LaundryItem> items;
}
